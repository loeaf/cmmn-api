package com.spo.cmmn.admin.sys.wordmng.service;

import com.spo.cmmn.admin.sys.wordmng.model.TnAnlgDict;

import java.util.HashMap;
import java.util.List;

public interface TnAnlgDictService{


    int deleteByPrimaryKey(String ANLG_DICT_ID);

    int insert(TnAnlgDict record);

    int insertSelective(TnAnlgDict record);

    TnAnlgDict selectByPrimaryKey(String ANLG_DICT_ID);

    int updateByPrimaryKeySelective(TnAnlgDict record);

    int updateByPrimaryKey(TnAnlgDict record);

    List<HashMap> selectByKeyWd(String keyWd);

}
