package com.spo.cmmn.admin.sys.mnmng.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface  MnmngService {
	public List<?> selectListMenu(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> selectMenuDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public List<?> selectListMenuPrgmCmbo(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public List<?> selectListMenuProgram(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	
	public Map<String, Object> insertMenu(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> modifyMenu(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> deleteMenu(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> insertProgram(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> modifyProgram(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> mulDeleteProgram(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
