package com.spo.cmmn.admin.audit.incidentAuthStatus.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface  IncidentAuthStatusService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
