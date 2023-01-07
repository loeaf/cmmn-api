package com.spo.cmmn.admin.sys.orgmng.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.sys.orgmng.service.OrgmngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.sys.orgmng.mapper.mysql.OrgmngMapper;

@Service
public class OrgmngServiceImpl implements OrgmngService {

	@Autowired
	private OrgmngMapper orgmngMapper;


	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListInst(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return orgmngMapper.selectListInst(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectInstDetail(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		return orgmngMapper.selectInstDetail(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> checkInstCode(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		int cnt = orgmngMapper.checkInstCode(params);
		
		if (cnt > 0) {
			params.put("check", "N");
			params.put("msg", "중복된 기관코드 입니다.");

		} else {
			params.put("check", "Y");
			params.put("msg", "사용가능한 기관코드 입니다.");
		}
		
		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> checkInstEngAbbrNm(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		int cnt = orgmngMapper.checkInstEngAbbrNm(params);
		
		if (cnt > 0) {
			params.put("check", "N");
			params.put("msg", "중복된 기관영문약어명 입니다.");

		} else {
			params.put("check", "Y");
			params.put("msg", "사용가능한 기관영문약어명 입니다.");
		}
		
		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> saveInst(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		int cnt = orgmngMapper.saveInst(params);

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
	public Map<String, Object> deleteInst(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		
		for(String instCd : (ArrayList<String>)params.get("instCd")) {
			params.put("instCode", instCd);
			
			int cnt = orgmngMapper.deleteInst(params);
			
			if (cnt < 0) {
				throw new Exception();
			}
		}

		params.put("rslt", "Y");
		params.put("msg", "삭제 되었습니다.");

		return params;
	}

}
