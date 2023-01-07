package com.spo.cmmn.admin.audit.transAuthStatus.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.audit.transAuthStatus.mapper.mysql.TransAuthStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.audit.transAuthStatus.service.TransAuthStatusService;

@Service
public class TransAuthStatusServiceImpl implements TransAuthStatusService {

	@Autowired
	private TransAuthStatusMapper transAuthStatusMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return transAuthStatusMapper.selectList(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return transAuthStatusMapper.selectDetail(params);
	}

}
