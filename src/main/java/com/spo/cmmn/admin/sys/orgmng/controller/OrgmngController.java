package com.spo.cmmn.admin.sys.orgmng.controller;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.sys.orgmng.service.OrgmngService;
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

@Controller
@RequestMapping(value="/api/admin/sys/orgmng")
public class OrgmngController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
    OrgmngService orgmngService;
	
	
	/** 
	 * 기관목록 조회
	 */
	@GetMapping(value="/inst/list")
	public ResponseEntity<List<?>> selectListInst(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListInst");
		
		List<?> gList = orgmngService.selectListInst(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 기관정보 상세조회
	 */
	@GetMapping(value="/inst/detail")
	public ResponseEntity<Map<String, Object>> selectInstDetail(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectInstDetail");
		
		Map<String, Object> gList = orgmngService.selectInstDetail(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 기관코드 중복체크
	 */
	@GetMapping(value="/inst/check")
	public ResponseEntity<Map<String, Object>> checkInstCode(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("checkInstCode");
		
		Map<String, Object> gList = orgmngService.checkInstCode(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}
	
	
	/** 
	 * 기관영문약어명 중복체크
	 */
	@GetMapping(value="/instEngAbbrNm/check")
	public ResponseEntity<Map<String, Object>> checkInstEngAbbrNm(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("checkInstEngAbbrNm");
		
		Map<String, Object> gList = orgmngService.checkInstEngAbbrNm(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}
	
	
	
	/********************************↑ get ↑****************************************/
	
	/********************************↓ post ↓****************************************/
	
	/** 
	 * 코드유형목록 저장
	 */
	@PostMapping(value="/inst/save")
	public ResponseEntity<Map<String, Object>> saveInst(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("saveInst");
		
		return new ResponseEntity<Map<String, Object>>(orgmngService.saveInst(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 코드유형목록 삭제
	 */
	@PostMapping(value="/inst/delete")
	public ResponseEntity<Map<String, Object>> deleteInst(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("deleteInst");
		
		return new ResponseEntity<Map<String, Object>>(orgmngService.deleteInst(params, request), HttpStatus.OK);
	}
	
	
}
