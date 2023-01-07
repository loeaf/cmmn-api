package com.spo.cmmn.admin.stats.orgAccessStats.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface  OrgAccessStatsService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
