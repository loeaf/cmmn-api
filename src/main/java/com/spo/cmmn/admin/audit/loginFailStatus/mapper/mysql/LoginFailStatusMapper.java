package com.spo.cmmn.admin.audit.loginFailStatus.mapper.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginFailStatusMapper {
	 
	List<?> selectList(HashMap<String, Object> params) throws Exception;
	Map<String, Object> selectDetail(HashMap<String, Object> params) throws Exception;
}