package com.spo.cmmn.admin.comm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface  CommonService {
	public List<?> selectListAllUser(HashMap<String, Object> params) throws Exception;
	public Map<String, Object> selectUser(String userId) throws Exception;
	public List<Map<String, Object>> selectUserAuthrt(String userId) throws Exception;
	public List<?> selectUserMenuList(HashMap<String, Object> params) throws Exception;
	public Boolean checkUserMenuAuthrt(HashMap<String, Object> params) throws Exception;
	public Boolean checkUserTrnscAuthrt(HashMap<String, Object> params) throws Exception;
	public List<?> selectDeptTreeList(HashMap<String, Object> params) throws Exception;
	public List<?> selectDeptTreeUserList(HashMap<String, Object> params) throws Exception;
	public Map<String, Object> selectInstSchm(HashMap<String, Object> params) throws Exception;
	
}
