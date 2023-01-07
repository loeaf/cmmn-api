package com.spo.cmmn.admin.audit.loginFailStatus.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface  LoginFailStatusService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> selectDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
