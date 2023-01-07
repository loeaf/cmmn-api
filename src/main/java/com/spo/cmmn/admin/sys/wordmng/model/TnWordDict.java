package com.spo.cmmn.admin.sys.wordmng.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 단어사전기본
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TnWordDict {
    /**
    * 사전ID
    */
    private String DICT_ID;

    /**
    * 사전키워드명
    */
    private String DICT_KEYWD_NM;

    /**
    * 사전키워드설명
    */
    private String DICT_KEYWD_DESC;

    /**
    * 단어사전사용여부
    */
    private String WORD_DICT_USE_YN;

    /**
    * 삭제여부
    */
    private String DEL_YN;

    /**
    * 등록자ID
    */
    private String REGR_ID;

    /**
    * 등록자IP주소
    */
    private String REGR_IP_ADDR;

    /**
    * 등록일시
    */
    private Date REG_DT;

    /**
    * 변경자ID
    */
    private String CHGR_ID;

    /**
    * 변경자IP주소
    */
    private String CHGR_IP_ADDR;

    /**
    * 변경일시
    */
    private Date CHG_DT;
}