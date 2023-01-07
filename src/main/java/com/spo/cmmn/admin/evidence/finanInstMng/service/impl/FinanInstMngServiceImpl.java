package com.spo.cmmn.admin.evidence.finanInstMng.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.evidence.finanInstMng.mapper.mysql.FinanInstMngMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.evidence.finanInstMng.service.FinanInstMngService;

@Service
public class FinanInstMngServiceImpl implements FinanInstMngService {

	@Autowired
	private FinanInstMngMapper finanInstMngMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return finanInstMngMapper.selectList(params);
	}
}
