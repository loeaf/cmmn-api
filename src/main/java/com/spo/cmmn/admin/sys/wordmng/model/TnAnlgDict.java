package com.spo.cmmn.admin.sys.wordmng.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 유사사전기본
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TnAnlgDict {
    /**
    * 유사어사전ID
    */
    private String ANLG_DICT_ID;

    /**
    * 사전키워드명
    */
    private String DICT_KEYWD_NM;

    /**
    * 유사어키워드명
    */
    private String ANLG_KEYWD_NM;

    /**
    * 유사어구분코드
    */
    private String ANLG_SE_CD;

    /**
    * 유사어키워드설명
    */
    private String ANLG_KEYWD_DESC;

    /**
    * 유사어사전사용여부
    */
    private String ANLG_DICT_USE_YN;

    /**
    * 삭제여부
    */
    private String DEL_YN;

    /**
    * 등록자ID
    */
    private String RGTR_ID;

    /**
    * 등록자IP주소
    */
    private String RGTR_IP_ADDR;

    /**
    * 등록일시
    */
    private Date REG_DT;

    /**
    * 변경자ID
    */
    private String CHNRG_ID;

    /**
    * 변경자IP주소
    */
    private String CHNRG_IP_ADDR;

    /**
    * 변경일시
    */
    private Date CHG_DT;
}