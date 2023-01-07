package com.spo.cmmn.admin.audit.userAuthStatuse.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.audit.userAuthStatuse.mapper.mysql.UserAuthStatuseMapper;
import com.spo.cmmn.admin.audit.userAuthStatuse.service.UserAuthStatuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAuthStatuseServiceImpl implements UserAuthStatuseService {

	@Autowired
	private UserAuthStatuseMapper userAuthStatuseMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return userAuthStatuseMapper.selectList(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return userAuthStatuseMapper.selectDetail(params);
	}


}
