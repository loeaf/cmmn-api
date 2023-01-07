package com.spo.cmmn.admin.sys.batchMng.controller;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.sys.batchMng.service.BatchMngService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/api/admin/sys/batchMng")
public class BatchMngController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
    BatchMngService batchMngService;
	
	
	/** 
	 * 목록 조회
	 */
	@GetMapping(value="/list")
	public ResponseEntity<List<?>> selectListBatch(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		List<?> gList = batchMngService.selectListBatch(params, request);
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}

	// 수정 / 등록 / 삭제

	@PostMapping(value="/delete")
	public ResponseEntity<Map<String, Object>> deleteBatch(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		System.out.println("batchIds : " + params.get("batchId"));
		return new ResponseEntity<Map<String, Object>>(batchMngService.deleteBatch(params, request), HttpStatus.OK);
	}

	@PostMapping(value="/save")
	public ResponseEntity<Map<String, Object>> saveBatch(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		params.put("batchId", UUID.randomUUID().toString());
		String cronExprs = (String)params.get("mmExprs")
				+ " " + (String)params.get("ddExprs")
				+ " " + (String)params.get("hrExprs")
				+ " " + (String)params.get("miExprs")
				+ " " + (String)params.get("wkExprs")
				+ " " + (String)params.get("batchNm");

		params.put("batchClassNm", "classNm");
		params.put("cronExprs", cronExprs);
		params.put("rgtrId", "administrator");
		params.put("rgtrIpAddr", "127.0.0.1");
		params.put("chnrgId", "administrator");
		params.put("chnrgIpAddr", "127.0.0.1");

		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("formatNow : " + formatedNow);

		if(params.get("batchStrtDt") == "" || params.get("batchStrtDt") == null){
			params.put("batchStrtDt", formatedNow);
		}
		if(params.get("batchEndDt") == "" || params.get("batchEndDt") == null){
			params.put("batchEndDt", formatedNow);
		}
		if(params.get("useYn") == "" || params.get("useYn") == null){
			params.put("useYn", 'Y');
		}

		return new ResponseEntity<Map<String, Object>>(batchMngService.saveBatch(params, request), HttpStatus.OK);
	}

	@PostMapping(value="/modify")
	public ResponseEntity<Map<String, Object>> modifyBatch(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		String cronExprs = (String)params.get("mmExprs")
				+ " " + (String)params.get("ddExprs")
				+ " " + (String)params.get("hrExprs")
				+ " " + (String)params.get("miExprs")
				+ " " + (String)params.get("wkExprs")
				+ " " + (String)params.get("batchNm");

		params.put("batchClassNm", "classNm");
		params.put("cronExprs", cronExprs);
		params.put("rgtrId", "administrator");
		params.put("rgtrIpAddr", "127.0.0.1");
		params.put("chnrgId", "administrator");
		params.put("chnrgIpAddr", "127.0.0.1");


		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("formatNow : " + formatedNow);

		if(params.get("batchStrtDt") == ""){
			params.put("batchStrtDt", formatedNow);
		}
		if(params.get("batchEndDt") == ""){
			params.put("batchEndDt", formatedNow);
		}

		return new ResponseEntity<Map<String, Object>>(batchMngService.modifyBatch(params, request), HttpStatus.OK);
	}
}
