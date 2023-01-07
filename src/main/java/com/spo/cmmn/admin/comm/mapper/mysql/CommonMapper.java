package com.spo.cmmn.admin.comm.mapper.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	 
	List<?> selectListAllUser(HashMap<String, Object> params) throws Exception;
	Map<String, Object> selectUser(String userId) throws Exception;
	List<Map<String, Object>> selectUserAuthrt(String userId) throws Exception;
	List<?> selectUserMenuList(HashMap<String, Object> params) throws Exception;
	int checkUserMenuAuthrt(HashMap<String, Object> params) throws Exception;
	int checkUserTrnscAuthrt(HashMap<String, Object> params) throws Exception;
	List<?> selectDeptTreeList(HashMap<String, Object> params) throws Exception;
	List<?> selectDeptTreeUserList(HashMap<String, Object> params) throws Exception;
	Map<String, Object> selectInstSchm(HashMap<String, Object> params) throws Exception;
}