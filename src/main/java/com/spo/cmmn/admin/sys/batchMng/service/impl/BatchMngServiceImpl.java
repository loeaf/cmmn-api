package com.spo.cmmn.admin.sys.batchMng.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.CamelHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.sys.batchMng.mapper.mysql.BatchMngMapper;
import com.spo.cmmn.admin.sys.batchMng.service.BatchMngService;

@Service
public class BatchMngServiceImpl implements BatchMngService {

	@Autowired
	private BatchMngMapper batchMngMapper;

	@Value("${batch.path}")
	private String FILE_PATH = "";

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly = false)
	public List<?> selectListBatch(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
//		System.out.println("batchNm : " + params.get("batchNm"));
//		System.out.println("batchDesc : " + params.get("batchDesc"));
//		System.out.println("useYn : " + params.get("useYn"));
		if(params.get("batchNm") != "" && params.get("batchDesc") != "" && params.get("useYn") != "")
			return batchMngMapper.selectListBatch(params);
		else if(params.get("batchNm") != "" && params.get("useYn") != ""){
			return batchMngMapper.selectListSearchBatchNmUseYn(params);
		}
		else if(params.get("batchDesc") != "" && params.get("useYn") != ""){
			return batchMngMapper.selectListSearchBatchDescUseYn(params);
		}
		else if(params.get("batchNm") != "" && params.get("batchDesc") != ""){
			return batchMngMapper.selectListSearchBatchNmBatchDesc(params);
		}
		else if(params.get("batchNm") != "" && params.get("batchDesc") != "" && params.get("useYn") != ""){
			return batchMngMapper.selectListSearchBatchNmBatchDescUseYn(params);
		}
		else if(params.get("batchNm") != ""){
			return batchMngMapper.selectListSearchBatchNm(params);
		}
		else if(params.get("batchDesc") != ""){
			return batchMngMapper.selectListSearchBatchDesc(params);
		}
		else if(params.get("useYn") != ""){
			return batchMngMapper.selectListSearchUseYn(params);
		}
		return batchMngMapper.selectListBatch(params);
	}

	@Override
	public HashMap<String, Object> deleteBatch(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		int cnt = batchMngMapper.deleteBatch(params);
		if(cnt <= 0){
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");
		} else{
			params.put("rslt", "Y");
			params.put("msg", "저장 되었습니다.");
		}
		return params;
	}

	@Override
	public HashMap<String, Object> saveBatch(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		int cnt = batchMngMapper.saveBatch(params);
		if(cnt <= 0){
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");
		} else{
			params.put("rslt", "Y");
			params.put("msg", "저장 되었습니다.");
		}

		// crontab 명령어 전부 다시 파일에 쓰기
		try {
			File file = new File(FILE_PATH);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);

			List<?> items = batchMngMapper.selectListBatch(new HashMap<String, Object>());

			for (Object item : items) {
				String useYn = (String)(((CamelHashMap) item).get("useYn"));
				System.out.println("useYn : " + useYn);
				if(useYn.equals("Y")){
					writer.write((String) (((CamelHashMap) item).get("cronExprs")) + "\n");
				}
			}
			writer.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		return params;
	}

	@Override
	public HashMap<String, Object> modifyBatch(HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		int cnt = batchMngMapper.modifyBatch(params);
		if(cnt <= 0){
			params.put("rslt", "N");
			params.put("msg", "정상적으로 처리되지 않았습니다.\n\n시스템관리자에게 문의바랍니다.");
		} else{
			params.put("rslt", "Y");
			params.put("msg", "저장 되었습니다.");
		}
		return params;
	}


}
