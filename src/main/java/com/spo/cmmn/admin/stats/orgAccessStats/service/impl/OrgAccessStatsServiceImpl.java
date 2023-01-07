package com.spo.cmmn.admin.stats.orgAccessStats.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.stats.orgAccessStats.mapper.mysql.OrgAccessStatsMapper;
import com.spo.cmmn.admin.stats.orgAccessStats.service.OrgAccessStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrgAccessStatsServiceImpl implements OrgAccessStatsService {

	@Autowired
	private OrgAccessStatsMapper orgAccessStatsMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return orgAccessStatsMapper.selectList(params);
	}
}
