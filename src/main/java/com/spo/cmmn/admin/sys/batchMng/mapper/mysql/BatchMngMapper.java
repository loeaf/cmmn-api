package com.spo.cmmn.admin.sys.batchMng.mapper.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Mapper
public interface BatchMngMapper {

	List<?> selectListBatch(@Param("map") HashMap<String, Object> params) throws Exception;
	List<?> selectListSearchBatchNm(@Param("map") HashMap<String, Object> params) throws Exception;
	List<?> selectListSearchUseYn(@Param("map") HashMap<String, Object> params) throws Exception;
	List<?> selectListSearchBatchDesc(@Param("map") HashMap<String, Object> params) throws Exception;
	List<?> selectListSearchBatchNmUseYn(@Param("map") HashMap<String, Object> params) throws Exception;
	List<?> selectListSearchBatchDescUseYn(@Param("map") HashMap<String, Object> params) throws Exception;
	List<?> selectListSearchBatchNmBatchDesc(@Param("map") HashMap<String, Object> params) throws Exception;
	List<?> selectListSearchBatchNmBatchDescUseYn(@Param("map") HashMap<String, Object> params) throws Exception;
	int deleteBatch(@Param("map") HashMap<String, Object> params) throws Exception;
	int saveBatch(@Param("map") HashMap<String, Object> params) throws Exception;
	int modifyBatch(@Param("map") HashMap<String, Object> params) throws Exception;
}
