package com.spo.cmmn.admin.sys.wordmng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.spo.cmmn.admin.sys.wordmng.mapper.mysql.TnAnlgDictMapper;
import com.spo.cmmn.admin.sys.wordmng.model.TnAnlgDict;
import com.spo.cmmn.admin.sys.wordmng.service.TnAnlgDictService;

import java.util.HashMap;
import java.util.List;

@Service
public class TnAnlgDictServiceImpl implements TnAnlgDictService{

    @Resource
    private TnAnlgDictMapper tnAnlgDictMapper;

    @Override
    public int deleteByPrimaryKey(String ANLG_DICT_ID) {
        return tnAnlgDictMapper.deleteByPrimaryKey(ANLG_DICT_ID);
    }

    @Override
    public int insert(TnAnlgDict record) {
        return tnAnlgDictMapper.insert(record);
    }

    @Override
    public int insertSelective(TnAnlgDict record) {
        return tnAnlgDictMapper.insertSelective(record);
    }

    @Override
    public TnAnlgDict selectByPrimaryKey(String ANLG_DICT_ID) {
        return tnAnlgDictMapper.selectByPrimaryKey(ANLG_DICT_ID);
    }

    @Override
    public int updateByPrimaryKeySelective(TnAnlgDict record) {
        return tnAnlgDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TnAnlgDict record) {
        return tnAnlgDictMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<HashMap> selectByKeyWd(String keyWd) {
        return tnAnlgDictMapper.selectByKeyWd(keyWd);
    }

}
