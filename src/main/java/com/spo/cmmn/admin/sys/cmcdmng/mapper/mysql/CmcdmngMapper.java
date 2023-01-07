package com.spo.cmmn.admin.sys.cmcdmng.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmcdmngMapper {
	 
	List<?> selectListCmmnTyCd(HashMap<String, Object> params) throws Exception;
	List<?> selectListCmmnCd(HashMap<String, Object> params) throws Exception;
	List<?> selectListChildCd(HashMap<String, Object> params) throws Exception;
	
	int saveCmmnTyCd(HashMap<String, Object> params) throws Exception;
	int deleteCmmnTyCd(HashMap<String, Object> params) throws Exception;
	int saveCmmnCd(HashMap<String, Object> params) throws Exception;
	int deleteCmmnCd(HashMap<String, Object> params) throws Exception;
	List<?> selectCrimeListCmmnTyCd(HashMap<String, Object> params) throws Exception;

	List<?> selectTopickListCmmnTyCd(HashMap<String, Object> params) throws Exception;
}