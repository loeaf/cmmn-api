package com.spo.cmmn.admin.sys.batchMng.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface  BatchMngService {
	public List<?> selectListBatch(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public HashMap<String, Object> deleteBatch(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public HashMap<String, Object> saveBatch(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public HashMap<String, Object> modifyBatch(HashMap<String, Object> params, HttpServletRequest request) throws Exception;

}
