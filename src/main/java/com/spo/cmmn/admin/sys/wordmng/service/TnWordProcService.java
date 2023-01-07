package com.spo.cmmn.admin.sys.wordmng.service;

import java.util.HashMap;
import java.util.List;

public interface TnWordProcService {

    int procInsertWordDict(HashMap<String, Object> params) throws Exception;
    int procUpdateWordDict(HashMap<String, Object> params) throws Exception;
    int procDeleteWordDict(HashMap<String, Object> params) throws Exception;
    List<HashMap> procSelectAllWordDict(HashMap<String, Object> params) throws Exception;
}
