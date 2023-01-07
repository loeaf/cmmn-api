package com.spo.cmmn.admin.sys.cmcdmng.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface  CmcdmngService {
	public List<?> selectListCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public List<?> selectListCmmnCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public List<?> selectListChildCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	
	public Map<String, Object> saveCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> deleteCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> saveCmmnCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	public Map<String, Object> deleteCmmnCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;

	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	List<?> selectCrimeListCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
	@Transactional(transactionManager = "mysqlTxManager", readOnly = true)
	List<?> selectTopickListCmmnTyCd(HashMap<String, Object> params, HttpServletRequest request) throws Exception;
}
