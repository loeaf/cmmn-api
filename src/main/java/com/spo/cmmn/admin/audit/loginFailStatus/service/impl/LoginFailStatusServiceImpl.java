package com.spo.cmmn.admin.audit.loginFailStatus.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.audit.loginFailStatus.mapper.mysql.LoginFailStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.audit.loginFailStatus.service.LoginFailStatusService;

@Service
public class LoginFailStatusServiceImpl implements LoginFailStatusService {

	@Autowired
	private LoginFailStatusMapper loginFailStatusMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return loginFailStatusMapper.selectList(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return loginFailStatusMapper.selectDetail(params);
	}
}
