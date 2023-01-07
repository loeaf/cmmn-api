package com.spo.cmmn.admin.sys.cmcdmng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.sys.cmcdmng.mapper.mysql.CmcdmngMapper;
import com.spo.cmmn.admin.sys.cmcdmng.service.CmcdmngService;

@Service
public class CmcdmngServiceImpl implements CmcdmngService {

	@Autowired
	private CmcdmngMapper cmcdmngMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return cmcdmngMapper.selectListCmmnTyCd(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListCmmnCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return cmcdmngMapper.selectListCmmnCd(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListChildCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return cmcdmngMapper.selectListChildCd(params);
	}


	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = true, rollbackFor = {Exception.class})
	public Map<String, Object> saveCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		int cnt = cmcdmngMapper.saveCmmnTyCd(params);

		if (cnt <= 0) {
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");

		} else {
			params.put("rslt", "Y");
			params.put("msg", "저장 되었습니다.");
		}

		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = true, rollbackFor = {Exception.class})
	public Map<String, Object> deleteCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		
		cmcdmngMapper.deleteCmmnTyCd(params);
		cmcdmngMapper.deleteCmmnCd(params);

		params.put("rslt", "Y");
		params.put("msg", "삭제 되었습니다.");

		return params;
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = true, rollbackFor = {Exception.class})
	public Map<String, Object> saveCmmnCd(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		int cnt = cmcdmngMapper.saveCmmnCd(params);

		if (cnt <= 0) {
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");

		} else {
			params.put("rslt", "Y");
			params.put("msg", "저장 되었습니다.");
		}

		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = true, rollbackFor = {Exception.class})
	public Map<String, Object> deleteCmmnCd(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		
		cmcdmngMapper.deleteCmmnCd(params);

		params.put("rslt", "Y");
		params.put("msg", "삭제 되었습니다.");

		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectCrimeListCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return cmcdmngMapper.selectCrimeListCmmnTyCd(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectTopickListCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return cmcdmngMapper.selectTopickListCmmnTyCd(params);
	}


}
