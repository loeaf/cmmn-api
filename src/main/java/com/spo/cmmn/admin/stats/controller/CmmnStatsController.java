package com.spo.cmmn.admin.stats.controller;

import java.util.HashMap;
import java.util.List;

import com.spo.cmmn.admin.stats.service.CmmnStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/api/admin/stats")
public class CmmnStatsController {
	
	@Autowired
	private CmmnStatsService statsService;

	/**
	 * 기관별 실적 조회
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/byInstRslt")
	public ResponseEntity<List<HashMap<String, Object>>> selectByInstRsltList(@RequestParam HashMap<String, Object> params) throws Exception{
		return new ResponseEntity<List<HashMap<String, Object>>>(statsService.selectByInstRsltList(params), HttpStatus.OK);
	}
	
	/**
	 * 접속 통계 조회
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/connStats")
	public ResponseEntity<List<HashMap<String, Object>>> selectConnStatsList(@RequestParam HashMap<String, Object> params) throws Exception{
		return new ResponseEntity<List<HashMap<String, Object>>>(statsService.selectConnStatsList(params), HttpStatus.OK);
	}
	
	/**
	 * 매체정보 통계 조회 - 디지털증거 매체 유형
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/mediaInfoStats")
	public ResponseEntity<List<HashMap<String, Object>>> selectMediaInfoStatsList(@RequestParam HashMap<String, Object> params) throws Exception{
		return new ResponseEntity<List<HashMap<String, Object>>>(statsService.selectMediaInfoStatsList(params), HttpStatus.OK);
	}
	
	/**
	 * 매체정보 통계 조회 - 데이터파일 유형
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/dataFileStats")
	public ResponseEntity<List<HashMap<String, Object>>> selectDataFileStatsList(@RequestParam HashMap<String, Object> params) throws Exception{
		return new ResponseEntity<List<HashMap<String, Object>>>(statsService.selectDataFileStatsList(params), HttpStatus.OK);
	}
	
	/**
	 * 업무실적(증거처리 실적) 조회
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/workRslt")
	public ResponseEntity<List<HashMap<String, Object>>> selectWorkRsltList(@RequestParam HashMap<String, Object> params) throws Exception{
		return new ResponseEntity<List<HashMap<String, Object>>>(statsService.selectWorkRsltList(params), HttpStatus.OK);
	}
	
	/**
	 * 실적통계(암호해제 실적) 조회
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/rsltStats")
	public ResponseEntity<List<HashMap<String, Object>>> selectRsltStatsList(@RequestParam HashMap<String, Object> params) throws Exception{
		return new ResponseEntity<List<HashMap<String, Object>>>(statsService.selectRsltStatsList(params), HttpStatus.OK);
	}
}
