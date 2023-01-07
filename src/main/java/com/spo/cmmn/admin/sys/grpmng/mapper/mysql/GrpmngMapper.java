package com.spo.cmmn.admin.sys.grpmng.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GrpmngMapper {
	List<HashMap<String, Object>> selectAuthgrpList (HashMap<String, Object> params) throws Exception;
	List<HashMap<String, Object>> selectMntree(HashMap<String, Object> params) throws Exception;
	List<HashMap<String, Object>> selectMntreeAuthmenu(HashMap<String, Object> params) throws Exception;
	void mntreeAuthmenuDelete(String authrtId) throws Exception;
	void mntreeAuthmenuSave(HashMap<String, Object> params) throws Exception;
	List<HashMap<String, Object>> selectAuthgrpTrgt(HashMap<String, Object> params) throws Exception;
	int updateAuthgrp(HashMap<String, Object> params) throws Exception;
	List<HashMap<String, Object>> selectAuthgrpModify(HashMap<String, Object> params) throws Exception;
	int deleteAuthgrp(HashMap<String, Object> params) throws Exception;
	int insertAuthgrp(HashMap<String, Object> params);
}
