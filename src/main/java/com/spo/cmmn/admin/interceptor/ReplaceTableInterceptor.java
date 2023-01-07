package com.spo.cmmn.admin.interceptor;

import java.lang.invoke.MethodHandles;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Intercepts({ @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}), @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}) })
public class ReplaceTableInterceptor implements Interceptor {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final static Map<String,String> TABLE_MAP = new LinkedHashMap<>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
    	HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	String userName = (String) req.getSession(true).getAttribute("accountName");
    	
    	if(userName == null || "".equals(userName)) {
    		return invocation.proceed();
    	}
    	
    	TABLE_MAP.put("tc_", userName + ".tc_");
    	TABLE_MAP.put("TC_", userName + ".TC_");
    	
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameterObject = args[1];

        BoundSql boundSql = ms.getBoundSql(parameterObject);
        String sql = boundSql.getSql();
        LOGGER.debug(" Before interception sql :\n" + sql);
        
        if(isReplaceTableName(sql)){
            for(Map.Entry<String, String> entry : TABLE_MAP.entrySet()){
                sql = sql.replace(entry.getKey(),entry.getValue());
            }
            LOGGER.debug(" After the intercept sql :\n" + sql);
            
            BoundSql bs = new BoundSql(ms.getConfiguration(),sql,boundSql.getParameterMappings(),parameterObject);
            MappedStatement newMs = copyMappedStatement(ms, new BoundSqlSqlSource(bs));
            args[0] = newMs;
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    	//
    }

    private boolean isReplaceTableName(String sql){
        for(String tableName : TABLE_MAP.keySet()){
            if(sql.contains(tableName)){
                return true;
            }
        }
        return false;
    }

    private MappedStatement copyMappedStatement (MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0) {
            builder.keyProperty(String.join(",",ms.getKeyProperties()));
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    public static class BoundSqlSqlSource implements SqlSource {
        private BoundSql boundSql;
        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }
        @Override
        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }
}
