package com.spo.cmmn.admin.evidence.addrFailDataMng.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface  AddrFailDataMngService {
	public List<?> selectList(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
