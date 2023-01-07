package com.spo.cmmn.admin.sys.patchLogMng.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.sys.patchLogMng.mapper.mysql.PatchLogMngMapper;
import com.spo.cmmn.admin.sys.patchLogMng.service.PatchLogMngService;

@Service
public class PatchLogMngServiceImpl implements PatchLogMngService {

	@Autowired
	private PatchLogMngMapper patchLogMngMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return patchLogMngMapper.selectList(params);
	}

}
