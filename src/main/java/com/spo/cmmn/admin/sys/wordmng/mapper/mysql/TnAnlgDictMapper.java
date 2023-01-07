package com.spo.cmmn.admin.sys.wordmng.mapper.mysql;

import com.spo.cmmn.admin.sys.wordmng.model.TnAnlgDict;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TnAnlgDictMapper {
    int deleteByPrimaryKey(String ANLG_DICT_ID);

    int insert(TnAnlgDict record);

    int insertSelective(TnAnlgDict record);

    TnAnlgDict selectByPrimaryKey(String ANLG_DICT_ID);

    int updateByPrimaryKeySelective(TnAnlgDict record);

    int updateByPrimaryKey(TnAnlgDict record);

    List<HashMap> selectByKeyWd(@Param("DICT_KEYWD_NM") String DICT_KEYWD_NM);
}