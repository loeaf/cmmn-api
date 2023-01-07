package com.spo.cmmn.admin.comm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spo.cmmn.admin.comm.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.comm.mapper.mysql.CommonMapper;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonMapper commonMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListAllUser(HashMap<String, Object> params) throws Exception {
		return commonMapper.selectListAllUser(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectUser(String userId) throws Exception {
		return commonMapper.selectUser(userId);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<Map<String, Object>> selectUserAuthrt(String userId) throws Exception {
		return commonMapper.selectUserAuthrt(userId);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectUserMenuList(HashMap<String, Object> params) throws Exception {
		return commonMapper.selectUserMenuList(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Boolean checkUserMenuAuthrt(HashMap<String, Object> params) throws Exception {
		Boolean rtnChk = commonMapper.checkUserMenuAuthrt(params) > 0 ? true : false;
		return rtnChk;
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Boolean checkUserTrnscAuthrt(HashMap<String, Object> params) throws Exception {
		Boolean rtnChk = commonMapper.checkUserTrnscAuthrt(params) > 0 ? true : false;
		return rtnChk;
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectDeptTreeList(HashMap<String, Object> params) throws Exception {
		return commonMapper.selectDeptTreeList(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectDeptTreeUserList(HashMap<String, Object> params) throws Exception {
		return commonMapper.selectDeptTreeUserList(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectInstSchm(HashMap<String, Object> params) throws Exception {
		return commonMapper.selectInstSchm(params);
	}


}
