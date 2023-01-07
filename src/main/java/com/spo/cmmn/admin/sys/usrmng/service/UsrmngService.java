package com.spo.cmmn.admin.sys.usrmng.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface  UsrmngService {
	public List<?> selectListOrgnzt(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> selectOrgnztDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> checkOrgnztCode(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public List<?> selectListOrgnztUser(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> selectOrgnztUserDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> checkOrgnztUserId(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	
	public Map<String, Object> insertOrgnzt(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> modifyOrgnzt(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> deleteOrgnzt(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> insertOrgnztUser(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> modifyOrgnztUser(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> deleteOrgnztUser(HashMap<String, Object> params, HttpServletRequest request) throws Exception;

}
