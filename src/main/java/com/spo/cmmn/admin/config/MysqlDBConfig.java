package com.spo.cmmn.admin.config;//package com.spo.cmmn.admin.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = {"com.spo.cmmn.admin.**.mapper.mysql"}, sqlSessionFactoryRef = "mysqlSqlSessionFactory")
@EnableTransactionManagement
public class MysqlDBConfig {
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
    	return DataSourceBuilder.create().build();
    }

	@Bean(name = "mysqlSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mysqlDataSource, ApplicationContext applicationContext)
            throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(mysqlDataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:mappers/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mappers/mysql/**/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name="mysqlSqlSession")
    public SqlSessionTemplate mysqlSqlSession(@Autowired @Qualifier("mysqlSqlSessionFactory") SqlSessionFactory mysqlSqlSessionFactory) {
        return new SqlSessionTemplate(mysqlSqlSessionFactory);
    }

    @Bean(name="mysqlTxManager")
    public DataSourceTransactionManager mysqlTxManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
    	return new DataSourceTransactionManager(dataSource);
    }
}