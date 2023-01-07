package com.spo.cmmn.admin.sys.mnmng.controller;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spo.cmmn.admin.sys.mnmng.service.MnmngService;
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
@RequestMapping(value="/api/admin/sys/mnmng")
public class MnmngController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
    MnmngService mnmngService;
	
	
	/** 
	 * 메뉴트리 조회
	 */
	@GetMapping(value="/menu/list")
	public ResponseEntity<List<?>> selectListMenu(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListMenu");

		List<?> gList = mnmngService.selectListMenu(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 선택 메뉴트리 상세조회
	 */
	@GetMapping(value="/menu/detail")
	public ResponseEntity<Map<String, Object>> selectMenuDetail(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectMenuDetail");
		
		Map<String, Object> gList = mnmngService.selectMenuDetail(params, request);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 메뉴정보 > 프로그램경로 콤보박스 목록
	 */
	@GetMapping(value="/menu/prgmCmbo")
	public ResponseEntity<List<?>> selectListMenuPrgmCmbo(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListMenuPrgmCmbo");
		
		List<?> gList = mnmngService.selectListMenuPrgmCmbo(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 선택 메뉴트리 프로그램 목록 조회
	 */
	@GetMapping(value="/menu/prgm/list")
	public ResponseEntity<List<?>> selectListMenuProgram(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListMenuProgram");
		
		List<?> gList = mnmngService.selectListMenuProgram(params, request);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	/********************************↑ get ↑****************************************/
	
	/********************************↓ post ↓****************************************/
	
	/** 
	 * 메뉴 정보 생성
	 */
	@PostMapping(value="/menu/insert")
	public ResponseEntity<Map<String, Object>> insertMenu(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("insertMenu");
		
		return new ResponseEntity<Map<String, Object>>(mnmngService.insertMenu(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 메뉴 정보 변경
	 */
	@PostMapping(value="/menu/modify")
	public ResponseEntity<Map<String, Object>> modifyMenu(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("modifyMenu");
		
		return new ResponseEntity<Map<String, Object>>(mnmngService.modifyMenu(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 메뉴 정보 삭제
	 */
	@PostMapping(value="/menu/delete")
	public ResponseEntity<Map<String, Object>> deleteMenu(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("deleteMenu");
		
		return new ResponseEntity<Map<String, Object>>(mnmngService.deleteMenu(params, request), HttpStatus.OK);
	}
	
	
	
	/** 
	 * 프로그램 생성
	 */
	@PostMapping(value="/menu/prgm/insert")
	public ResponseEntity<Map<String, Object>> insertProgram(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("insertProgram");
		
		return new ResponseEntity<Map<String, Object>>(mnmngService.insertProgram(params, request), HttpStatus.OK);
	}
	
	/** 
	 * 프로그램 변경
	 */
	@PostMapping(value="/menu/prgm/modify")
	public ResponseEntity<Map<String, Object>> modifyProgram(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("modifyProgram");
		
		return new ResponseEntity<Map<String, Object>>(mnmngService.modifyProgram(params, request), HttpStatus.OK);
	}
	

	
	/** 
	 * 프로그램 다중 삭제
	 */
	@PostMapping(value="/menu/prgm/mulDelete")
	public ResponseEntity<Map<String, Object>> mulDeleteProgram(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("mulDeleteProgram");
		
		return new ResponseEntity<Map<String, Object>>(mnmngService.mulDeleteProgram(params, request), HttpStatus.OK);
	}
}
