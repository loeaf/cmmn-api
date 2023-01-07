package com.spo.cmmn.admin.stats.orgUsePerf.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrgUsePerfMapper {
	 
	List<?> selectList(HashMap<String, Object> params) throws Exception;
}