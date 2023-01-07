package com.spo.cmmn.admin.stats.service;

import java.util.HashMap;
import java.util.List;

public interface CmmnStatsService {
	public List<HashMap<String, Object>> selectByInstRsltList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectConnStatsList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectMediaInfoStatsList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectDataFileStatsList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectWorkRsltList(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectRsltStatsList(HashMap<String, Object> params) throws Exception;
}
