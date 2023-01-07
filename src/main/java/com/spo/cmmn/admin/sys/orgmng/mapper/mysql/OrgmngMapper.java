package com.spo.cmmn.admin.sys.orgmng.mapper.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrgmngMapper {
	
	List<?> selectListInst(HashMap<String, Object> params) throws Exception;
	Map<String, Object> selectInstDetail(HashMap<String, Object> params) throws Exception;
	int checkInstCode(HashMap<String, Object> params) throws Exception;
	int checkInstEngAbbrNm(HashMap<String, Object> params) throws Exception;

	int saveInst(HashMap<String, Object> params) throws Exception;
	int deleteInst(HashMap<String, Object> params) throws Exception;
}