package com.spo.cmmn.admin.audit.incidentAuthStatus.controller;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;

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

import com.spo.cmmn.admin.audit.incidentAuthStatus.service.IncidentAuthStatusService;

/**
 * 
 * 사건접근 권한 부여 현황
 *
 */
@Controller
@RequestMapping(value="/api/admin/sys/incidentAuthStatus")
public class IncidentAuthStatusController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
	IncidentAuthStatusService incidentAuthStatusService;
	
	
	/** 
	 * 목록 조회
	 */
	@GetMapping(value="/list")
	public ResponseEntity<List<?>> selectList(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		
		List<?> gList = incidentAuthStatusService.selectList(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
}
