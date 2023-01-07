package com.spo.cmmn.admin.sys.usrmng.controller;

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

import com.spo.cmmn.admin.sys.usrmng.service.UsrmngService;

@Controller
@RequestMapping(value="/api/admin/sys/usrmng")
public class UsrmngController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
	UsrmngService usrmngService;
	
	
	/** 
	 * 조직 목록 조회
	 */
	@GetMapping(value="/orgnzt/list")
	public ResponseEntity<List<?>> selectListOrgnzt(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListOrgnzt");
		
		List<?> gList = usrmngService.selectListOrgnzt(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}

	/** 
	 * 부서 정보 조회(조직목록 선택 시)
	 */
	@GetMapping(value="/orgnzt/detail")
	public ResponseEntity<Map<String, Object>> selectOrgnztDetail(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectOrgnztDetail");
		
		Map<String, Object> gList = usrmngService.selectOrgnztDetail(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}
	
	
	/** 
	 * 부서코드 중복체크
	 */
	@GetMapping(value="/orgnzt/check")
	public ResponseEntity<Map<String, Object>> checkOrgnztCode(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("checkOrgnztCode");
		
		Map<String, Object> gList = usrmngService.checkOrgnztCode(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}
	
	
	/** 
	 * 사용자 목록 조회(조직목록 선택 시)
	 */
	@GetMapping(value="/orgnzt/user/list")
	public ResponseEntity<List<?>> selectListOrgnztUser(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListOrgnztUser");
		
		List<?> gList = usrmngService.selectListOrgnztUser(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	
	/** 
	 * 사용자 정보 조회(사용자 목록 선택 시)
	 */
	@GetMapping(value="/orgnzt/user/detail")
	public ResponseEntity<Map<String, Object>> selectOrgnztUserDetail(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectOrgnztUserDetail");
		
		Map<String, Object> gList = usrmngService.selectOrgnztUserDetail(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}
	
	
	/** 
	 * 사용자 ID 중복체크
	 */
	@GetMapping(value="/orgnzt/user/check")
	public ResponseEntity<Map<String, Object>> checkOrgnztUserId(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("checkOrgnztUserId");
		
		Map<String, Object> gList = usrmngService.checkOrgnztUserId(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}

	
	/********************************↑ get ↑****************************************/
	
	/********************************↓ post ↓****************************************/
	
	/** 
	 * 부서 정보 등록
	 */
	@PostMapping(value="/orgnzt/insert")
	public ResponseEntity<Map<String, Object>> insertOrgnzt(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("insertOrgnzt");
		
		return new ResponseEntity<Map<String, Object>>(usrmngService.insertOrgnzt(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 부서 정보 수정
	 */
	@PostMapping(value="/orgnzt/modify")
	public ResponseEntity<Map<String, Object>> modifyOrgnzt(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("modifyOrgnzt");
		
		return new ResponseEntity<Map<String, Object>>(usrmngService.modifyOrgnzt(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 부서 정보 삭제
	 */
	@PostMapping(value="/orgnzt/delete")
	public ResponseEntity<Map<String, Object>> deleteOrgnzt(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("deleteOrgnzt");
		
		return new ResponseEntity<Map<String, Object>>(usrmngService.deleteOrgnzt(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 사용자 정보 등록
	 */
	@PostMapping(value="/orgnzt/user/insert")
	public ResponseEntity<Map<String, Object>> insertOrgnztUser(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("insertOrgnztUser");
		
		return new ResponseEntity<Map<String, Object>>(usrmngService.insertOrgnztUser(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 사용자 정보 수정
	 */
	@PostMapping(value="/orgnzt/user/modify")
	public ResponseEntity<Map<String, Object>> modifyOrgnztUser(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("modifyOrgnztUser");
		
		return new ResponseEntity<Map<String, Object>>(usrmngService.modifyOrgnztUser(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 사용자 정보 삭제
	 */
	@PostMapping(value="/orgnzt/user/delete")
	public ResponseEntity<Map<String, Object>> deleteOrgnztUser(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("deleteOrgnztUser");
		
		return new ResponseEntity<Map<String, Object>>(usrmngService.deleteOrgnztUser(params, request), HttpStatus.OK);
	}
	

}
