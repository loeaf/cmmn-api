package com.spo.cmmn.admin.sys.grpmng.service;

import java.util.HashMap;
import java.util.List;

import com.spo.cmmn.admin.utils.TreeDTO;


public interface GrpmngService {
	
	List<HashMap<String, Object>> selectAuthgrpList(HashMap<String, Object> params) throws Exception;
	List<TreeDTO> selectMntree(HashMap<String, Object> params) throws Exception;
	List<TreeDTO> selectMntreeAuthmenu(HashMap<String, Object> params) throws Exception;
	void mntreeAuthmenuSave(HashMap<String, Object> params) throws Exception;
	List<HashMap<String, Object>> selectAuthgrpTrgt(HashMap<String, Object> params) throws Exception;
	int insertAuthgrp(HashMap<String, Object> params) throws Exception;
	int modifyAuthgrp(HashMap<String, Object> params) throws Exception;
	int deleteAuthgrp(HashMap<String, Object> params) throws Exception;
}
