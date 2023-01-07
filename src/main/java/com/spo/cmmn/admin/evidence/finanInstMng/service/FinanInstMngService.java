package com.spo.cmmn.admin.evidence.finanInstMng.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface  FinanInstMngService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
