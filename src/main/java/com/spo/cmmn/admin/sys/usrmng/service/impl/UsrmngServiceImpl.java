package com.spo.cmmn.admin.sys.usrmng.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.sys.usrmng.mapper.mysql.UsrmngMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.sys.usrmng.service.UsrmngService;

@Service
public class UsrmngServiceImpl implements UsrmngService {

	@Autowired
	private UsrmngMapper usrmngMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListOrgnzt(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return usrmngMapper.selectListOrgnzt(params);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectOrgnztDetail(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		return usrmngMapper.selectOrgnztDetail(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> checkOrgnztCode(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		int cnt = usrmngMapper.checkOrgnztCode(params);
		
		if (cnt > 0) {
			params.put("check", "N");
			params.put("msg", "중복된 부서코드 입니다.");

		} else {
			params.put("check", "Y");
			params.put("msg", "사용가능한 부서코드 입니다.");
		}
		
		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListOrgnztUser(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		return usrmngMapper.selectListOrgnztUser(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> selectOrgnztUserDetail(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		return usrmngMapper.selectOrgnztUserDetail(params);
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> checkOrgnztUserId(HashMap<String, Object> params, HttpServletRequest request)
			throws Exception {
		int cnt = usrmngMapper.checkOrgnztUserId(params);
				
		if (cnt > 0) {
			params.put("check", "N");
			params.put("msg", "중복된 ID 입니다.");

		} else {
			params.put("check", "Y");
			params.put("msg", "사용가능한 ID 입니다.");
		}
		
		return params;
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public Map<String, Object> insertOrgnzt(HashMap<String, Object> params, HttpServletRequest request) throws Exception {

		int cnt = usrmngMapper.modifyOrgnzt(params);

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
	public Map<String, Object> modifyOrgnzt(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		int cnt = usrmngMapper.modifyOrgnzt(params);

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
	public Map<String, Object> deleteOrgnzt(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		int cnt = usrmngMapper.deleteOrgnzt(params);

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
	public Map<String, Object> insertOrgnztUser(HashMap<String, Object> params, HttpServletRequest request) throws Exception {

		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		
		String pwd = params.get("userPswd").toString();
		String matchPwd = usrmngMapper.selectUserPwd(params);
		
		if(matchPwd != null && (encode.matches(pwd, matchPwd) || matchPwd.equals(pwd))) {//비밀번호 매치가 일치 하면 변경x
			params.put("userPswd", "");
			params.put("msg2", "비밀번호 변경 X");
		}else {//비밀번호가 일치 하지 않으면 변경
			String enCodePwd = encode.encode(pwd);//변경된 비밀번호이므로 비밀번호는 암호화
			params.put("userPswd", enCodePwd);
			params.put("msg2", "비밀번호 변경 O");
		}
		
		ArrayList<String> authrtIdList =  (ArrayList<String>)params.get("authrtId");
		
		int cnt1 = usrmngMapper.modifyOrgnztUser(params);
		int cnt2 = 0;
		
		usrmngMapper.deleteOrgnztUserAuthrtSingle(params);
		
		for(String authrtItem :authrtIdList) {
			params.put("authrtItem", authrtItem);
			cnt2 += usrmngMapper.modifyOrgnztUserAuthrt(params);
		}

		if (cnt1 <= 0 && cnt2 < authrtIdList.size()) {
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
	public Map<String, Object> modifyOrgnztUser(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		
		String pwd = params.get("userPswd").toString();
		String matchPwd = usrmngMapper.selectUserPwd(params);
		
		if(matchPwd != null && encode.matches(pwd, matchPwd) || matchPwd.equals(pwd)) {//비밀번호 매치가 일치 하면 변경x
			params.put("userPswd", "");
			params.put("msg2", "비밀번호 변경 X");
		}else {//비밀번호가 일치 하지 않으면 변경
			String enCodePwd = encode.encode(pwd);//변경된 비밀번호이므로 비밀번호는 암호화
			params.put("userPswd", enCodePwd);
			params.put("msg2", "비밀번호 변경 O");
		}
		
		ArrayList<String> authrtIdList =  (ArrayList<String>)params.get("authrtId");
		
		int cnt1 = usrmngMapper.modifyOrgnztUser(params);
		int cnt2 = 0;
		
		usrmngMapper.deleteOrgnztUserAuthrtSingle(params);
		
		for(String authrtItem :authrtIdList) {
			params.put("authrtItem", authrtItem);
			cnt2 += usrmngMapper.modifyOrgnztUserAuthrt(params);
		}

		if (cnt1 <= 0 && cnt2 < authrtIdList.size()) {
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
	public Map<String, Object> deleteOrgnztUser(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		
		usrmngMapper.deleteOrgnztUser(params);
		usrmngMapper.deleteOrgnztUserAuthrt(params);
		
		params.put("rslt", "Y");
		params.put("msg", "삭제 되었습니다.");

		return params;
	}

}
