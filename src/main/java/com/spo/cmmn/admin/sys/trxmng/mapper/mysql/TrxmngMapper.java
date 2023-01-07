package com.spo.cmmn.admin.sys.trxmng.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrxmngMapper {
	List<HashMap<String, Object>> selectTrxList(HashMap<String, Object> params) throws Exception;
	List<HashMap<String, Object>> selectTrxnames() throws Exception;
	List<HashMap<String, Object>> selectSyscode() throws Exception;
	List<HashMap<String, Object>> selectTrnscList(HashMap<String, Object> param) throws Exception;
	List<HashMap<String, Object>> selectIsAuthrtTrnsc(HashMap<String, Object> params) throws Exception;
	int insertTrnsc(HashMap<String, Object> params) throws Exception;
	int insertAuthrt(HashMap<String, Object> params) throws Exception;
	int insertTrxAuth(HashMap<String, Object> params) throws Exception;
	List<HashMap<String, Object>> selectTrnscId() throws Exception;
	int updateTrxAuth(HashMap<String, Object> params) throws Exception;
	int deleteTrnsc(HashMap<String, Object> params) throws Exception;
	int deleteAuthrt(HashMap<String, Object> params) throws Exception;
	int deleteTrxTrnsc(HashMap<String, Object> params) throws Exception;
	List<HashMap<String, Object>> selectAuthrt(HashMap<String, Object> params) throws Exception;
	HashMap<String, String> selectMaxAuthrtId() throws Exception;
	List<HashMap<String, Object>> selectTrnscAuthrtList(String trnscId) throws Exception;
	int saveTrnscInfo(HashMap<String, Object> params) throws Exception;
	int insertDefaultAuthrtList(HashMap<String, Object> params) throws Exception;
	int deleteTrnscInfo(HashMap<String, Object> params) throws Exception;
	int updateAuthrtInfo(HashMap<String, Object> params) throws Exception;
}