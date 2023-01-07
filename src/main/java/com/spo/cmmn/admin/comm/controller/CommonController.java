package com.spo.cmmn.admin.comm.controller;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import com.spo.cmmn.admin.comm.service.CommonService;
import com.spo.cmmn.admin.dto.SessionDTO;

@Controller
@RequestMapping(value="/api/admin/sys/common")
public class CommonController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Autowired
	CommonService commonService;
	
	public static final String SESSION_NAME = "SessionDTO";

	/**
	 * test Get
	 */
@GetMapping(value="/test")
public ResponseEntity<?> testGet(HttpServletRequest request) throws Exception {
	LOGGER.info("testGet");
	SessionDTO sessionDTO = (SessionDTO) request.getSession().getAttribute(SESSION_NAME);

	Map<String, Object> rtnMap = new HashMap<String, Object>();
	rtnMap.put("sessionDTO", sessionDTO);

	return new ResponseEntity<>(rtnMap, HttpStatus.OK);
}
	
	/** 
	 * 전체 유저 목록 조회 (22.11.29 요청)
	 */
	@GetMapping(value="/allUser/list")
	public ResponseEntity<List<?>> selectListAllUser(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectListAllUser");
		
		List<?> gList = commonService.selectListAllUser(params);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	/** 
	 * 유저 정보 조회
	 */
	@GetMapping(value="/user")
	public ResponseEntity<Map<String, Object>> selectUser(@RequestParam String userId, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectUser");
		
		Map<String, Object> gList = commonService.selectUser(userId);
		
		return new ResponseEntity<Map<String, Object>>(gList, HttpStatus.OK);
	}

	/** 
	 * 유저 권한 정보 조회
	 */
	@GetMapping(value="/user/authrt")
	public ResponseEntity<List<Map<String, Object>>> selectUserAuthrt(@RequestParam String userId, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectUserAuthrt");
		
		List<Map<String, Object>> gList = commonService.selectUserAuthrt(userId);
		
		return new ResponseEntity<List<Map<String, Object>>>(gList, HttpStatus.OK);
	}
	
	
	/** 
	 * 
	 * 유저 메뉴 목록 조회
	 */
	@GetMapping(value="/menu/list")
	public ResponseEntity<List<?>> selectUserMenuList(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectUserMenuList");
		
		List<?> gList = commonService.selectUserMenuList(params);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	


	/** 
	 * 
	 * 유저 메뉴 권한 체크
	 */
	@GetMapping(value="/menu/authrt")
	public ResponseEntity<Boolean> checkUserMenuAuthrt(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("checkUserMenuAuthrt");
		
		Boolean checked = commonService.checkUserMenuAuthrt(params);
		
		return new ResponseEntity<Boolean>(checked, HttpStatus.OK);
	}
	
	
	/** 
	 * 유저 트랜잭션 권한 체크
	 */
	@GetMapping(value="/trnsc/authrt")
	public ResponseEntity<Boolean> checkUserTrnscAuthrt(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("checkUserTrnscAuthrt");
		
		// 세션 가져오기
		ObjectMapper mapper = new ObjectMapper();
		SessionDTO sessionDto = mapper.convertValue(request.getSession().getAttribute(SESSION_NAME), SessionDTO.class);
		
		if(sessionDto == null) {//세션 존재하는제 확인
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		
		//개발을 위해 임시 주석처리, 추후 개발 완료 후 주석 해제 후 트랜잭션 체크 필요
		//Boolean checked = commonService.checkUserTrnscAuthrt(params);
		Boolean checked = true;
		
		return new ResponseEntity<Boolean>(checked, HttpStatus.OK);
	}
	
	
	
	/** 
	 * 조직 목록 조회 트리 (기관 + 조직 + 사용자)
	 */
	@GetMapping(value="/deptTree/list")
	public ResponseEntity<List<?>> selectDeptTreeList(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectDeptTreeList");
		
		List<?> gList = commonService.selectDeptTreeList(params);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	
	
	/** 
	 * 조직 목록 조회 트리 (기관 + 조직 + 사용자)
	 * 사용자 목록 조회
	 */
	@GetMapping(value="/deptTree/userList")
	public ResponseEntity<List<?>> selectDeptTreeUserList(@RequestParam HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectDeptTreeUserList");
		
		List<?> gList = commonService.selectDeptTreeUserList(params);
		
		return new ResponseEntity<List<?>>(gList, HttpStatus.OK);
	}
	
	
	/** 
	 * 기관 스키마 조회
	 */
	@PostMapping(value="/instSchm")
	public ResponseEntity<Map<String, Object>> selectInstSchm(@RequestBody HashMap<String, Object> params, HttpServletRequest request) throws Exception {
		LOGGER.debug("selectInstSchm");
		return new ResponseEntity<Map<String, Object>>(commonService.selectInstSchm(params), HttpStatus.OK);
	}

}
