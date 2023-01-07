package com.spo.cmmn.admin.audit.evidenceAuthStatus.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface  EvidenceAuthStatusService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
