package com.spo.cmmn.admin.audit.incidentAuthStatus.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IncidentAuthStatusMapper {
	 
	List<?> selectList(HashMap<String, Object> params) throws Exception;
}