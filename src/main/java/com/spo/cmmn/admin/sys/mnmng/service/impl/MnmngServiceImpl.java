package com.spo.cmmn.admin.sys.mnmng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.sys.mnmng.service.MnmngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.sys.mnmng.mapper.mysql.MnmngMapper;
import com.spo.cmmn.admin.utils.FromListToTree;
import com.spo.cmmn.admin.utils.TreeDTO;

@Service
public class MnmngServiceImpl implements MnmngService {

	@Autowired
	private MnmngMapper mnmngMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<TreeDTO> selectListMenu(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		@SuppressWarnings("unchecked")
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) mnmngMapper.selectListMenu(params);
		
		FromListToTree fltt = new FromListToTree();
		return fltt.ListToTreeDTO(list);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectMenuDetail(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		return mnmngMapper.selectMenuDetail(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListMenuPrgmCmbo(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return mnmngMapper.selectListMenuPrgmCmbo(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListMenuProgram(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return mnmngMapper.selectListMenuProgram(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> insertMenu(HashMap<String, Object> params, HttpServletRequest request) throws Exception {

		int cnt = mnmngMapper.modifyMenu(params);

		if (cnt <= 0) {
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");

		} else {
			params.put("rslt", "Y");
			params.put("msg", "등록 되었습니다.");
		}

		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> modifyMenu(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		int cnt = mnmngMapper.modifyMenu(params);

		if (cnt <= 0) {
			params.put("rslt", "N");
			params.put("msg", "○○○가 정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");

		} else {
			params.put("rslt", "Y");
			params.put("msg", "수정 되었습니다.");
		}

		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> deleteMenu(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		int cnt = mnmngMapper.deleteMenu(params);

		if (cnt <= 0) {
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");

		} else {
			params.put("rslt", "Y");
			params.put("msg", "삭제 되었습니다.");
		}

		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> insertProgram(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		int cnt = mnmngMapper.modifyProgram(params);
		
		int cnt2 = mnmngMapper.modifyMenuProgramm(params);

		if (cnt <= 0 && cnt2 <= 0) {
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");

		} else {
			params.put("rslt", "Y");
			params.put("msg", "등록 되었습니다.");
		}

		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> modifyProgram(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		int cnt = mnmngMapper.modifyProgram(params);
		
		int cnt2 = mnmngMapper.modifyMenuProgramm(params);

		if (cnt <= 0 && cnt2 <= 0) {
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");

		} else {
			params.put("rslt", "Y");
			params.put("msg", "수정 되었습니다.");
		}

		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = true, rollbackFor = {Exception.class})
	public Map<String, Object> mulDeleteProgram(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		
		mnmngMapper.mulDeleteProgram(params);
		mnmngMapper.mulDeleteMenuProgram(params);

		params.put("rslt", "Y");
		params.put("msg", "삭제 되었습니다.");

		return params;
	}

	

}
