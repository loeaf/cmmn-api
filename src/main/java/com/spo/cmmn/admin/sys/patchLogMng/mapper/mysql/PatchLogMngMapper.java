package com.spo.cmmn.admin.sys.patchLogMng.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatchLogMngMapper {
	 
	List<?> selectList(HashMap<String, Object> params) throws Exception;
}