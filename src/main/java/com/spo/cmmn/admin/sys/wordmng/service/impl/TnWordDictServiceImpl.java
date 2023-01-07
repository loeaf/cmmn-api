package com.spo.cmmn.admin.sys.wordmng.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.spo.cmmn.admin.sys.wordmng.model.TnWordDict;
import com.spo.cmmn.admin.sys.wordmng.mapper.mysql.TnWordDictMapper;
import com.spo.cmmn.admin.sys.wordmng.service.TnWordDictService;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;

@Service
public class TnWordDictServiceImpl implements TnWordDictService{
    private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Resource
    private TnWordDictMapper tnWordDictMapper;
    @Override
    public int deleteByPrimaryKey(String DICT_ID) {
        return tnWordDictMapper.deleteByPrimaryKey(DICT_ID);
    }

    @Override
    public int insert(TnWordDict record) {
        return tnWordDictMapper.insert(record);
    }

    @Override
    public int insertSelective(TnWordDict record) {
        return tnWordDictMapper.insertSelective(record);
    }

    @Override
    public TnWordDict selectByPrimaryKey(String DICT_ID) {
        return tnWordDictMapper.selectByPrimaryKey(DICT_ID);
    }

    @Override
    public List<HashMap> selectByKeyWd(String keyWd) {
        return tnWordDictMapper.selectByKeyWd(keyWd);
    }

    @Override
    public int updateByPrimaryKeySelective(TnWordDict record) {
        return tnWordDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TnWordDict record) {
        return tnWordDictMapper.updateByPrimaryKey(record);
    }


}
