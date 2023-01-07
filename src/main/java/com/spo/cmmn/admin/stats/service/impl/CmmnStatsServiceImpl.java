package com.spo.cmmn.admin.stats.service.impl;

import java.util.HashMap;
import java.util.List;

import com.spo.cmmn.admin.stats.mapper.mysql.CmmnStatsMapper;
import com.spo.cmmn.admin.stats.service.CmmnStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmmnStatsServiceImpl implements CmmnStatsService {
	
	@Autowired
	private CmmnStatsMapper statsMapper;

	public List<HashMap<String, Object>> selectByInstRsltList(HashMap<String, Object> params) throws Exception{
		return statsMapper.selectByInstRsltList(params);
	}
	
	public List<HashMap<String, Object>> selectConnStatsList(HashMap<String, Object> params) throws Exception{
		return statsMapper.selectConnStatsList(params);
	}
	
	public List<HashMap<String, Object>> selectMediaInfoStatsList(HashMap<String, Object> params) throws Exception{
		return statsMapper.selectMediaInfoStatsList(params);
	}
	
	public List<HashMap<String, Object>> selectDataFileStatsList(HashMap<String, Object> params) throws Exception{
		return statsMapper.selectDataFileStatsList(params);
	}
	
	public List<HashMap<String, Object>> selectWorkRsltList(HashMap<String, Object> params) throws Exception{
		return statsMapper.selectWorkRsltList(params);
	}
	
	public List<HashMap<String, Object>> selectRsltStatsList(HashMap<String, Object> params) throws Exception{
		return statsMapper.selectRsltStatsList(params);
	}
}
