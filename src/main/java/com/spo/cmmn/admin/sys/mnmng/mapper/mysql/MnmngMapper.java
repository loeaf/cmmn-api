package com.spo.cmmn.admin.sys.mnmng.mapper.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MnmngMapper {
	
	List<?> selectListMenu(HashMap<String, Object> params) throws Exception;
	Map<String, Object> selectMenuDetail(HashMap<String, Object> params) throws Exception;
	List<?> selectListMenuProgram(HashMap<String, Object> params) throws Exception;
	List<?> selectListMenuPrgmCmbo(HashMap<String, Object> params) throws Exception;
	
	int modifyMenu(HashMap<String, Object> params) throws Exception;
	int deleteMenu(HashMap<String, Object> params) throws Exception;
	
	int modifyProgram(HashMap<String, Object> params) throws Exception;
	int modifyMenuProgramm(HashMap<String, Object> params) throws Exception;
	int mulDeleteProgram(HashMap<String, Object> params) throws Exception;
	int mulDeleteMenuProgram(HashMap<String, Object> params) throws Exception;
}