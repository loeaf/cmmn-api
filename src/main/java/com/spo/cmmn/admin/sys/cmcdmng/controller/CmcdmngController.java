package com.spo.cmmn.admin.sys.cmcdmng.controller;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spo.cmmn.admin.sys.cmcdmng.service.CmcdmngService;

@Controller
@RequestMapping(value="/api/admin/sys/cmcdmng")
public class CmcdmngController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
	CmcdmngService cmcdmngService;
	
	
	/** 
	 * 코드유형목록 조회
	 */
	@GetMapping(value="/cmmnTyCd/list")
	public ResponseEntity<List<?>> selectListCmmnTyCd(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListCmmnTyCd");
		
		List<?> gList = cmcdmngService.selectListCmmnTyCd(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 상세코드목록 조회
	 */
	@GetMapping(value="/cmmnCd/list")
	public ResponseEntity<List<?>> selectListCmmnCd(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListCmmnCd");
		
		List<?> gList = cmcdmngService.selectListCmmnCd(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 하위코드유형목록 조회
	 */
	@GetMapping(value="/cmmnTyCd/typeList")
	public ResponseEntity<List<?>> selectListChildCd(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListChildCd");
		
		List<?> gList = cmcdmngService.selectListChildCd(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	
	
	/********************************↑ get ↑****************************************/
	
	/********************************↓ post ↓****************************************/
	
	/** 
	 * 코드유형목록 저장
	 */
	@PostMapping(value="/cmmnTyCd/save")
	public ResponseEntity<Map<String, Object>> saveCmmnTyCd(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("saveCmmnTyCd");
		
		return new ResponseEntity<Map<String, Object>>(cmcdmngService.saveCmmnTyCd(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 코드유형목록 삭제
	 */
	@PostMapping(value="/cmmnTyCd/delete")
	public ResponseEntity<Map<String, Object>> deleteCmmnTyCd(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("deleteCmmnTyCd");
		
		return new ResponseEntity<Map<String, Object>>(cmcdmngService.deleteCmmnTyCd(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 상세코드목록 저장
	 */
	@PostMapping(value="/cmmnCd/save")
	public ResponseEntity<Map<String, Object>> saveCmmnCd(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("saveCmmnCd");
		
		return new ResponseEntity<Map<String, Object>>(cmcdmngService.saveCmmnCd(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 상세코드목록 삭제
	 */
	@PostMapping(value="/cmmnCd/delete")
	public ResponseEntity<Map<String, Object>> deleteCmmnCd(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("deleteCmmnCd");
		
		return new ResponseEntity<Map<String, Object>>(cmcdmngService.deleteCmmnCd(params, request), HttpStatus.OK);
	}

	/**
	 * 코드죄명유형목록 조회
	 * sql에서 like 기반으로 죄명으로 관련된 값을 가져옴...
	 */
	@GetMapping(value="/cmmnTyCd/crimeTypelist")
	public ResponseEntity<List<?>> selectCrimeListCmmnTyCd(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListCrimeTyCd");

		List<?> gList = cmcdmngService.selectCrimeListCmmnTyCd(params, request);

		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	/**
	 * 코드토픽유형목록 조회
	 * sql에서 like 기반으로 죄명으로 관련된 값을 가져옴...
	 */
	@GetMapping(value="/cmmnTyCd/topickTypelist")
	public ResponseEntity<List<?>> selectTopickListCmmnTyCd(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListTopickTyCd");

		List<?> gList = cmcdmngService.selectTopickListCmmnTyCd(params, request);

		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
}
