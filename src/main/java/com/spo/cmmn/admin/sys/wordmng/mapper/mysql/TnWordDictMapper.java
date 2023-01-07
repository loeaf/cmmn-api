package com.spo.cmmn.admin.sys.wordmng.mapper.mysql;

import com.spo.cmmn.admin.sys.wordmng.model.TnWordDict;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TnWordDictMapper {
    int deleteByPrimaryKey(String DICT_ID);

    int insert(TnWordDict record);

    int insertSelective(TnWordDict record);

    TnWordDict selectByPrimaryKey(String DICT_ID);

    int updateByPrimaryKeySelective(TnWordDict record);

    int updateByPrimaryKey(TnWordDict record);

    List<HashMap> selectByKeyWd(@Param("DICT_KEYWD_NM") String DICT_KEYWD_NM);
}