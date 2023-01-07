package com.spo.cmmn.admin.stats.mediaInfoStats.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.stats.mediaInfoStats.mapper.mysql.MediaInfoStatsMapper;
import com.spo.cmmn.admin.stats.mediaInfoStats.service.MediaInfoStatsService;

@Service
public class MediaInfoStatsServiceImpl implements MediaInfoStatsService {

	@Autowired
	private MediaInfoStatsMapper mediaInfoStatsMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return mediaInfoStatsMapper.selectList(params);
	}
}
