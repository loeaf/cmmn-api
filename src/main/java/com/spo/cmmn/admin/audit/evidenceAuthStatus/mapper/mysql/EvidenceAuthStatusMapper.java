package com.spo.cmmn.admin.audit.evidenceAuthStatus.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EvidenceAuthStatusMapper {
	 
	List<?> selectList(HashMap<String, Object> params) throws Exception;
}