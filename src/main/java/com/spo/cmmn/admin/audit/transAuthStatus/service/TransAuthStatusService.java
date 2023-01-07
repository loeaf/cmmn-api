package com.spo.cmmn.admin.audit.transAuthStatus.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface  TransAuthStatusService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> selectDetail(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
