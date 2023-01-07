package com.spo.cmmn.admin.audit.incidentAuthStatus.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.audit.incidentAuthStatus.mapper.mysql.IncidentAuthStatusMapper;
import com.spo.cmmn.admin.audit.incidentAuthStatus.service.IncidentAuthStatusService;

@Service
public class IncidentAuthStatusServiceImpl implements IncidentAuthStatusService {

	@Autowired
	private IncidentAuthStatusMapper incidentAuthStatusMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return incidentAuthStatusMapper.selectList(params);
	}

}
