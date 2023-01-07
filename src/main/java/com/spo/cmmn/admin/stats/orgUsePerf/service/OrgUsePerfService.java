package com.spo.cmmn.admin.stats.orgUsePerf.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface  OrgUsePerfService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
