package com.spo.cmmn.admin.evidence.finanInstMng.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FinanInstMngMapper {
	 
	List<?> selectList(HashMap<String, Object> params) throws Exception;
}