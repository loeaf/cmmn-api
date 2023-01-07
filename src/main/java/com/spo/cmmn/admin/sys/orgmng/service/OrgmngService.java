package com.spo.cmmn.admin.sys.orgmng.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface  OrgmngService {
	
	public List<?> selectListInst(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> selectInstDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> checkInstCode(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> checkInstEngAbbrNm(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	
	public Map<String, Object> saveInst(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> deleteInst(HashMap<String, Object> params, HttpServletRequest request) throws Exception;

}
