package com.spo.cmmn.admin.sys.wordmng.controller;
import com.spo.cmmn.admin.sys.wordmng.service.impl.TnWordDictServiceImpl;
import com.spo.cmmn.admin.sys.wordmng.model.TnWordDict;
import com.spo.cmmn.admin.sys.wordmng.service.impl.TnWordProcServiceImpl;
import com.spo.cmmn.admin.sys.wordmng.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/admin/sys/wordmng")
public class TnWordDictController {
    private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    // 단어
    @Resource
    private TnWordDictServiceImpl tnWordDictServiceImpl;

    @Resource
    private TnWordProcServiceImpl tnWordProcServiceImpl;

    @GetMapping("selectOne")
    public TnWordDict selectOne(String id) {
return tnWordDictServiceImpl.selectByPrimaryKey(id);
}

    /**
     * 모든 단어정보에 대해서 들고온다
     * @param params
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/getAllWordDict", method=RequestMethod.POST)
    public List<HashMap> getAllWordDict(@RequestBody HashMap<String, Object> params) throws Exception {
//        var result = tnWordDictServiceImpl.selectByKeyWd(null);
        var result = tnWordProcServiceImpl.procSelectAllWordDict(params);
        return result;
    }

    @RequestMapping(value="/getWordDict", method=RequestMethod.POST)
    public List<HashMap> getWordDict(@RequestBody HashMap<String, Object> params) throws Exception {
//        var result = tnWordDictServiceImpl.selectByKeyWd(null);
        var result = tnWordDictServiceImpl.selectByKeyWd(null);
        return result;
    }

    /**
     * superType 분류 1
     * subType 분류 2
     * superType이 무엇이고 subType이 무엇인지에 따라 DBInsert 하는 곳이 달라짐.
     */
    @RequestMapping(value="/postWordDict", method=RequestMethod.POST)
    public int createWordDict(@RequestBody HashMap<String, Object> params) throws Exception {
        LOGGER.debug("wordDict create");
        LOGGER.debug("params: " + params.toString());
        int res = this.tnWordProcServiceImpl.procInsertWordDict(params);
        LOGGER.debug("res: " + res);
        return res;
    }

    @RequestMapping(value="/deleteWordDict", method=RequestMethod.POST)
    public int deleteWordDict(@RequestBody HashMap<String, Object> params) throws Exception {
        var aaa = tnWordProcServiceImpl.procDeleteWordDict(params);
        return aaa;
    }

    @RequestMapping(value="/putWordDict", method=RequestMethod.POST)
    public int putWordDict(@RequestBody HashMap<String, Object> params) throws Exception {
        var aaa = tnWordProcServiceImpl.procUpdateWordDict(params);
        return aaa;
    }
}
