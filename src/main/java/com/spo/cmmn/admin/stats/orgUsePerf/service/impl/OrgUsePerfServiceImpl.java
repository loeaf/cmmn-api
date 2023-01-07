package com.spo.cmmn.admin.stats.orgUsePerf.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.stats.orgUsePerf.mapper.mysql.OrgUsePerfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.stats.orgUsePerf.service.OrgUsePerfService;

@Service
public class OrgUsePerfServiceImpl implements OrgUsePerfService {

	@Autowired
	private OrgUsePerfMapper orgUsePerfMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return orgUsePerfMapper.selectList(params);
	}


}
