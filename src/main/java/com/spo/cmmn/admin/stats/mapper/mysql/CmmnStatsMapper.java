package com.spo.cmmn.admin.stats.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmmnStatsMapper {
	public List<HashMap<String, Object>> selectByInstRsltList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectConnStatsList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectMediaInfoStatsList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectDataFileStatsList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectWorkRsltList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectRsltStatsList(HashMap<String, Object> params) throws Exception;
}
