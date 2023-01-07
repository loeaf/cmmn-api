package com.spo.cmmn.admin.stats.orgAccessStats.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrgAccessStatsMapper {
	 
	List<?> selectList(HashMap<String, Object> params) throws Exception;
}