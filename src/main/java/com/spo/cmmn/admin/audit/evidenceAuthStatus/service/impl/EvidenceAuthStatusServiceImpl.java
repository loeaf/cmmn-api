package com.spo.cmmn.admin.audit.evidenceAuthStatus.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.audit.evidenceAuthStatus.mapper.mysql.EvidenceAuthStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.audit.evidenceAuthStatus.service.EvidenceAuthStatusService;

@Service
public class EvidenceAuthStatusServiceImpl implements EvidenceAuthStatusService {

	@Autowired
	private EvidenceAuthStatusMapper evidenceAuthStatusMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return evidenceAuthStatusMapper.selectList(params);
	}

}
