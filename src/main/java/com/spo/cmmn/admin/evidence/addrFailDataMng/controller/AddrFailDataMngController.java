package com.spo.cmmn.admin.evidence.addrFailDataMng.controller;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.evidence.addrFailDataMng.service.AddrFailDataMngService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/api/admin/sys/addrFailDataMng")
public class AddrFailDataMngController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
    AddrFailDataMngService addrFailDataMngService;
	
	
	/** 
	 * 목록 조회
	 */
	@GetMapping(value="/list")
	public ResponseEntity<List<?>> selectList(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		
		List<?> gList = addrFailDataMngService.selectList(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
}
