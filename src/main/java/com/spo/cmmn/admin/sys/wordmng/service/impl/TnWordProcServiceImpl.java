package com.spo.cmmn.admin.sys.wordmng.service.impl;

import com.spo.cmmn.admin.sys.wordmng.service.TnWordProcService;
import com.spo.cmmn.admin.sys.cmcdmng.mapper.mysql.CmcdmngMapper;
import com.spo.cmmn.admin.sys.wordmng.model.TnAnlgDict;
import com.spo.cmmn.admin.sys.wordmng.model.TnWordDict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TnWordProcServiceImpl implements TnWordProcService {
    private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Resource
    private TnAnlgDictServiceImpl tnAnlgDictService;

    @Resource
    private TnWordDictServiceImpl tnWordDictServiceImpl;

    @Resource
    private CmcdmngMapper cmcdmngMapper;
    @Override
    public int procInsertWordDict(HashMap<String, Object> params) throws Exception {
        int res = 999;
        String DICT_KEYWD_NM = params.get("dictKeywdNm").toString();
        String DICT_KEYWD_DESC = params.get("dictKeywdDesc").toString();
        String REGR_ID = params.get("regrId").toString();
        String REGR_IP_ADDR = params.get("regrIpAddr").toString();
        String CHGR_ID = params.get("chgrId").toString();
        String CHGR_IP_ADDR = params.get("chgrIpAddr").toString();
        String SUPER_TYPE = "";
        String SUB_TYPE = "";
        String superDictKeyNm = "";
        if (params.get("superType") != null) {
            SUPER_TYPE = params.get("superType").toString();
        }
        if (params.get("subType") != null) {
            SUB_TYPE = params.get("subType").toString();
        }
        if (params.get("wordId") != null) {
            superDictKeyNm = params.get("wordId").toString();
        }

        // 사전 10000, 죄명 20000
        if(SUPER_TYPE.equals("10000")) {
            // 기본 10004, 동의어 10001, 범죄읜어 10002, 불용어 10003
            if(SUB_TYPE.equals("10004")) {
                var obj = new TnWordDict();
                obj.setDICT_ID(DICT_KEYWD_NM);
                obj.setDICT_KEYWD_NM(DICT_KEYWD_NM);
                obj.setDICT_KEYWD_DESC(DICT_KEYWD_DESC);
                obj.setWORD_DICT_USE_YN("Y");
                obj.setDEL_YN("N");
                obj.setREGR_ID(REGR_ID);
                obj.setREGR_IP_ADDR(REGR_IP_ADDR);
                obj.setCHGR_ID(CHGR_ID);
                obj.setCHGR_IP_ADDR(CHGR_IP_ADDR);
                this.insertWordDict(obj);
            } else if(SUB_TYPE.equals("10001") ||SUB_TYPE.equals("10002") || SUB_TYPE.equals("10003")) {
                var obj = new TnAnlgDict();
                obj.setANLG_DICT_ID(DICT_KEYWD_NM);
                obj.setDICT_KEYWD_NM(superDictKeyNm);
                obj.setANLG_KEYWD_NM(DICT_KEYWD_NM);
                obj.setANLG_KEYWD_DESC(DICT_KEYWD_DESC);
                obj.setANLG_DICT_USE_YN("Y");
                obj.setDEL_YN("N");
                obj.setRGTR_ID(REGR_ID);
                obj.setRGTR_IP_ADDR(REGR_IP_ADDR);
                obj.setANLG_SE_CD(SUB_TYPE);
                obj.setCHNRG_ID(CHGR_ID);
                obj.setCHNRG_IP_ADDR(CHGR_IP_ADDR);
                this.insertAnlgDict(obj);
            }
            return 1;
        } else {
            return -999;
        }
    }

    @Override
    public int procUpdateWordDict(HashMap<String, Object> params) throws Exception {
        int res = 999;
        String DICT_ID = "";
        String SUPER_TYPE = "";
        String SUB_TYPE = "";
        String WORD_ID = "";
        String DICT_KEYWD_NM = params.get("dictKeywdNm").toString();
        if (params.get("superType") != null) {
            SUPER_TYPE = params.get("superType").toString();
        }
        if (params.get("subType") != null) {
            SUB_TYPE = params.get("subType").toString();
        }
        if (params.get("wordId") != null) {
            WORD_ID = params.get("wordId").toString();
        }
        if (params.get("dictId") != null) {
            DICT_ID = params.get("dictId").toString();
        }
        String DICT_KEYWD_DESC = params.get("dictKeywdDesc").toString();
        // 사전 10000, 죄명 20000
        if(SUPER_TYPE.equals("10000")) {
            // 기본 10004, 동의어 10001, 범죄읜어 10002, 불용어 10003
            if(SUB_TYPE.equals("10004")) {
                var obj = new TnWordDict();
                obj.setDICT_KEYWD_NM(DICT_KEYWD_NM);
                obj.setDICT_KEYWD_DESC(DICT_KEYWD_DESC);
                obj.setWORD_DICT_USE_YN("Y");
                obj.setDEL_YN("N");
                this.insertWordDict(obj);
            } else if(SUB_TYPE.equals("10001") ||SUB_TYPE.equals("10002") || SUB_TYPE.equals("10003")) {
                var obj = new TnAnlgDict();
                obj.setANLG_DICT_ID(DICT_KEYWD_NM);
                obj.setDICT_KEYWD_NM(WORD_ID);
                obj.setANLG_KEYWD_NM(DICT_KEYWD_NM);
                obj.setANLG_KEYWD_DESC(DICT_KEYWD_DESC);
                obj.setANLG_DICT_USE_YN("Y");
                obj.setANLG_SE_CD(SUB_TYPE);
                obj.setDEL_YN("N");
                this.insertAnlgDict(obj);
            }
            return 1;
        } else {
            return -999;
        }
    }

    @Override
    public int procDeleteWordDict(HashMap<String, Object> params) throws Exception {
        String SUPER_TYPE = "";
        String SUB_TYPE = "";
        String WORD_ID = "";
        String DICT_KEYWD_NM = params.get("dictKeywdNm").toString();
        if (params.get("superType") != null) {
            SUPER_TYPE = params.get("superType").toString();
        }
        if (params.get("subType") != null) {
            SUB_TYPE = params.get("subType").toString();
        }
        // 사전 10000, 죄명 20000
        if(SUPER_TYPE.equals("10000")) {
            // 기본 10004, 동의어 10001, 범죄읜어 10002, 불용어 10003
            if(SUB_TYPE.equals("10004")) {
                var obj = new TnWordDict();
                obj.setDICT_KEYWD_NM(DICT_KEYWD_NM);
                obj.setWORD_DICT_USE_YN("Y");
                obj.setDEL_YN("Y");
                this.insertWordDict(obj);
            } else if(SUB_TYPE.equals("10001") ||SUB_TYPE.equals("10002") || SUB_TYPE.equals("10003")) {
                var obj = new TnAnlgDict();
                obj.setANLG_DICT_ID(DICT_KEYWD_NM);
                obj.setANLG_KEYWD_NM(DICT_KEYWD_NM);
                obj.setANLG_DICT_USE_YN("Y");
                obj.setANLG_SE_CD(SUB_TYPE);
                obj.setDEL_YN("Y");
                this.insertAnlgDict(obj);
            }
            return 1;
        } else {
            return -999;
        }
    }

    @Override
    public List<HashMap> procSelectAllWordDict(HashMap<String, Object> params) throws Exception {
        var wordDict = this.tnWordDictServiceImpl.selectByKeyWd(null).stream().map(p -> {
            var hashMap = new HashMap();
            hashMap.put("dictId", p.get("dictId"));
            hashMap.put("dictKeywdNm", p.get("dictKeywdNm"));
            hashMap.put("dictKeywdDesc", p.get("dictKeywdDesc"));
            hashMap.put("chgDt", p.get("chgDt"));
            hashMap.put("chgrId", p.get("chgrId"));
            hashMap.put("superType", 10000);
            hashMap.put("superTypeNm", p.get("superTypeNm"));
            hashMap.put("subType", p.get("subType"));
            return hashMap;
        }).collect(Collectors.toList());
        var thAnlgDictHashMap = this.tnAnlgDictService.selectByKeyWd(null).stream().map(p -> {
            var hashMap = new HashMap();
            hashMap.put("dictId", p.get("anlgDictId"));
            hashMap.put("dictKeywdNm", p.get("anlgKeywdNm"));
            hashMap.put("dictKeywdDesc", p.get("anlgKeywdDesc"));
            hashMap.put("chgDt", p.get("chgDt"));
            hashMap.put("chgrId", p.get("chgrId"));
            hashMap.put("superTypeNm", p.get("dictKeywdNm"));
            hashMap.put("superType", 10000);
            hashMap.put("subType", p.get("anlgSeCd"));
            return hashMap;
        }).collect(Collectors.toList());;
        wordDict.addAll(thAnlgDictHashMap);
        return wordDict;
    }

    private int insertWordDict(TnWordDict obj) {
        int res = -999;
        res = this.tnWordDictServiceImpl.insert(obj);
        return res;
    }

    private int insertAnlgDict(TnAnlgDict obj) {
        int res = -999;
        res = this.tnAnlgDictService.insert(obj);
        return res;
    }
}
