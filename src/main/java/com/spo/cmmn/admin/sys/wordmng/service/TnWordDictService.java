package com.spo.cmmn.admin.sys.wordmng.service;

import com.spo.cmmn.admin.sys.wordmng.model.TnWordDict;

import java.util.HashMap;
import java.util.List;

public interface TnWordDictService{


    int deleteByPrimaryKey(String DICT_ID);

    int insert(TnWordDict record);

    int insertSelective(TnWordDict record);

    TnWordDict selectByPrimaryKey(String DICT_ID);

    List<HashMap> selectByKeyWd(String keyWd);

    int updateByPrimaryKeySelective(TnWordDict record);

    int updateByPrimaryKey(TnWordDict record);

}
