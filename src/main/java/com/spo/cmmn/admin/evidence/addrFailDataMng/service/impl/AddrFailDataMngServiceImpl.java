package com.spo.cmmn.admin.evidence.addrFailDataMng.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.evidence.addrFailDataMng.service.AddrFailDataMngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.evidence.addrFailDataMng.mapper.mysql.AddrFailDataMngMapper;

@Service
public class AddrFailDataMngServiceImpl implements AddrFailDataMngService {

	@Autowired
	private AddrFailDataMngMapper addrFailDataMngMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return addrFailDataMngMapper.selectList(params);
	}

}
