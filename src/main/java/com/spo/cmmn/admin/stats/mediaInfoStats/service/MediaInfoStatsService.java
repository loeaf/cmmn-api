package com.spo.cmmn.admin.stats.mediaInfoStats.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface  MediaInfoStatsService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
