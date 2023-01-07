package com.spo.cmmn.admin.sys.grpmng.controller;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.spo.cmmn.admin.sys.grpmng.service.GrpmngService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spo.cmmn.admin.utils.TreeDTO;
import io.swagger.annotations.Api;


@Api(value = "그룹관리매니저", tags = "그룹 관리 화면")
@RestController
@RequestMapping(value="/api/admin/sys/grpmng")
public class GrpmngController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	GrpmngService grpmngService;
	
	/** 
	 * 그룹권한 목록 조회 : 
	 */
	@RequestMapping(value="/authgrp/list", method=RequestMethod.GET)
	public List<HashMap<String, Object>> selectAuthGrpList(@RequestParam HashMap<String, Object> params) throws Exception {
		LOGGER.debug("group author list");
		LOGGER.debug("params: " + params.toString());
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = grpmngService.selectAuthgrpList(params);
		return list;
	}
	
	/** 
	 * 메뉴목록 조회
	 */
	@RequestMapping(value="/mntree", method=RequestMethod.GET)
	public List<TreeDTO> selectMntree(@RequestParam HashMap<String, Object> params) throws Exception {
		return grpmngService.selectMntree(params);
	}
	
	/** 
	 * 권한메뉴목록: 권한 있는 메뉴목록 조회, 권한메뉴목록선택>검색>권한그룹 대상정보 목록 출력
	 */
	@RequestMapping(value="/mntree/authmenu", method=RequestMethod.GET)
	public List<TreeDTO> selectMntreeAuthmenu(@RequestParam HashMap<String, Object> params) throws Exception {
		return grpmngService.selectMntreeAuthmenu(params);
	}
	
	/** 
	 * 권한메뉴목록 저장: 권한 있는 메뉴목록 조회, 권한메뉴목록선택>검색>권한그룹 대상정보 목록 저장
	 */
	@RequestMapping(value="/mntree/authmenu/save", method=RequestMethod.POST)
	public void mntreeAuthmenuSave(@RequestBody HashMap<String, Object> params) throws Exception {
		grpmngService.mntreeAuthmenuSave(params);
	}
	
	/** 
	 * 권한그룹 대상정보: 권한대상관리 조회
	 */
	@RequestMapping(value="/authgrp/trgt", method=RequestMethod.GET)
	public ResponseEntity<List<HashMap<String, Object>>> selectAuthgrpTrgt(@RequestParam HashMap<String, Object> params) throws Exception {
		LOGGER.debug("group author menutree list");
		LOGGER.debug("params: " + params.toString());
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = grpmngService.selectAuthgrpTrgt(params);
		LOGGER.debug("res: " + list.toString());
		return  new ResponseEntity<List<HashMap<String, Object>>>(list, HttpStatus.OK);
	}
	
	/** 
	 * 권한그룹추가(생성): 권한그룹목록>권한그룹추가
	 */
	@RequestMapping(value="/authgrp", method=RequestMethod.POST)
	public int insertAuthgrp(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		LOGGER.debug("group author menutree list");
		LOGGER.debug("params: " + params.toString());
		res = grpmngService.insertAuthgrp(params);
		return res;
	}
	
	/** 
	 * 권한그룹저장(변경): 권한그룹목록>권한그룹저장
	 */
	@RequestMapping(value="/authgrp/modify", method=RequestMethod.POST)
	public int modifyAuthgrp(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		LOGGER.debug("group author menutree modify");
		LOGGER.debug("params: " + params.toString());
		res = grpmngService.modifyAuthgrp(params);
		return res;
	}
	
	/** 
	 * 권한그룹삭제: 권한그룹관리>선택삭제
	 */
	@RequestMapping(value="/authgrp/delete", method=RequestMethod.POST)
	public int deleteAuthgrp(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		LOGGER.debug("group author menutree delete");
		LOGGER.debug("params: " + params.toString());
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		res = grpmngService.deleteAuthgrp(params);
		return  res;
	}
}
