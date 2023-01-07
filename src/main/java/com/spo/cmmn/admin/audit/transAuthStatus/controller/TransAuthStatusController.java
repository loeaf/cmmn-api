package com.spo.cmmn.admin.audit.transAuthStatus.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spo.cmmn.admin.audit.transAuthStatus.service.TransAuthStatusService;

/**
 * 
 * 트랜잭션 권한 부여 현황
 *
 */
@Controller
@RequestMapping(value="/api/admin/sys/transAuthStatus")
public class TransAuthStatusController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
	TransAuthStatusService transAuthStatusService;
	
	/** 
	 * 목록 조회
	 */
	@GetMapping(value="/list")
	public ResponseEntity<List<?>> selectList(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		
		List<?> gList = transAuthStatusService.selectList(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 로그 조회
	 */
	@GetMapping(value="/detail")
	public ResponseEntity<Map<String, Object>> selectDetail(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		
		Map<String, Object> gList = transAuthStatusService.selectDetail(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}
}
