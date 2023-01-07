package com.spo.cmmn.admin.sys.usrmng.mapper.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsrmngMapper {
	
	List<?> selectListOrgnzt(HashMap<String, Object> params) throws Exception;
	Map<String, Object> selectOrgnztDetail(HashMap<String, Object> params) throws Exception;
	int checkOrgnztCode(HashMap<String, Object> params) throws Exception;
	List<?> selectListOrgnztUser(HashMap<String, Object> params) throws Exception;
	Map<String, Object> selectOrgnztUserDetail(HashMap<String, Object> params) throws Exception;
	int checkOrgnztUserId(HashMap<String, Object> params) throws Exception;
	
	int modifyOrgnzt(HashMap<String, Object> params) throws Exception;
	int deleteOrgnzt(HashMap<String, Object> params) throws Exception;
	int modifyOrgnztUser(HashMap<String, Object> params) throws Exception;
	int modifyOrgnztUserAuthrt(HashMap<String, Object> params) throws Exception;
	int deleteOrgnztUser(HashMap<String, Object> params) throws Exception;
	int deleteOrgnztUserAuthrt(HashMap<String, Object> params) throws Exception;
	
	int deleteOrgnztUserAuthrtSingle(HashMap<String, Object> params) throws Exception;
	
	String selectUserPwd(HashMap<String, Object> params) throws Exception;
}