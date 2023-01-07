package com.spo.cmmn.admin.sys.trxmng.controller;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.spo.cmmn.admin.comm.Const;
import com.spo.cmmn.admin.sys.trxmng.service.impl.TrxmngServiceImpl;
import io.swagger.annotations.Api;


@Api(value = "트랜잭션매니저", tags = "트랜잭션 관리 화면")
@RestController
@RequestMapping(value="/api/admin/sys/trxmng")
public class TrxmngController {
	private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	TrxmngServiceImpl trxmngService;
	/** 
	 * 시스템구분코드(syscode) 조회
	 */
	@RequestMapping(value="/syscode", method=RequestMethod.GET)
	public ResponseEntity<List<HashMap<String, Object>>> selectSyscodeList(HttpServletRequest request) throws Exception {
		LOGGER.debug("syscode list");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = trxmngService.selectSyscode();
		LOGGER.debug("res: " + list.toString());
		return  new ResponseEntity<List<HashMap<String, Object>>>(list, HttpStatus.OK);
	}
	
	/** 
	 * 트랜잭션이름-목록
	 */
	@RequestMapping(value="/trxnames", method=RequestMethod.GET)
	public ResponseEntity<List<HashMap<String, Object>>> selectTrxNames(HttpServletRequest request) throws Exception {
		LOGGER.debug("trx name list");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = trxmngService.selectTrxnames();
		LOGGER.debug("res: " + list.toString());
		return  new ResponseEntity<List<HashMap<String, Object>>>(list, HttpStatus.OK);
	}
	
	/** 
	 * trnsc-목록
	 */
	@RequestMapping(value="/trnsc/list", method= {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<List<HashMap<String, Object>>> selectTrnscList(@RequestParam HashMap<String, Object> params) throws Exception {
		LOGGER.debug("trnsc list");
		LOGGER.debug("params: " + params.toString());
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = trxmngService.selectTrnscList(params);
		LOGGER.debug("res: " + list.toString());
		return  new ResponseEntity<List<HashMap<String, Object>>>(list, HttpStatus.OK);
	}
	
	/** 
	 * trnsc-목록
	 */
	@RequestMapping(value="/authrt/list", method= {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<List<HashMap<String, Object>>> selectAuthrtList(@RequestParam HashMap<String, Object> params) throws Exception {
		LOGGER.debug("trnsc list");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = trxmngService.selectAuthrt(params);
		LOGGER.debug("res: " + list.toString());
		return  new ResponseEntity<List<HashMap<String, Object>>>(list, HttpStatus.OK);
	}
	
	/** 
	 * 트랜잭션-목록 검색조회 
	 * search params:  syscode, trxname, trxdesc
	 */
	@RequestMapping(value="list", method={RequestMethod.POST, RequestMethod.GET})
	public ResponseEntity<List<HashMap<String, Object>>> selectTrxList(@RequestParam HashMap<String, Object> params) throws Exception {
		LOGGER.debug("trx list");
		LOGGER.debug("params: " + params.toString());
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = trxmngService.selectTrxList(params);
		LOGGER.debug("res: " + list.toString());
		return new ResponseEntity<List<HashMap<String, Object>>>(list, HttpStatus.OK);
	}
	
	/** 
	 * 트랜잭션-생성 
	 * opmng '101' AS 운영자, insttmng '102' AS 기관관리자, insttusr '103' AS 기관사용자
	 * , otinstusr'104' AS 외부기관사용자, incdntmng '105' AS 사건관리자, incdntusr '106' AS 사건담당자 
	 */
	@RequestMapping(value="/trx", method=RequestMethod.POST)
	public int createTrx(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		LOGGER.debug("trx create");
		LOGGER.debug("params: " + params.toString());
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = trxmngService.selectTrnscId(params);

		if(list==null||list.isEmpty()) {
			LOGGER.debug("insert trnsc with {}", params.get("trnscId"));
			res = trxmngService.insertTrnsc(params);
		}else {
			LOGGER.debug("already exist check your trnscID");
			return res;
		}
		
		//--<< if not exist authrt setup >>
		for(int i=0;i<Const.BASIS_AUTH_ID.length;i++) {
			params.put("authrtId", Const.BASIS_AUTH_ID[i]);
			params.put("authrtNm", Const.BASIS_AUTH_NM[i]);
			params.put("authrtDesc", Const.BASIS_AUTH_DESC[i]);
			list = trxmngService.selectAuthrt(params);
			if(list==null||list.isEmpty()) {
				LOGGER.debug("params: " + params.toString());
				res=trxmngService.insertAuthrt(params);
			}else {
				LOGGER.debug("already exist check your aurtrtID");
				continue;
			}
		}
		
		//--<< initial authrt setup >>
		LOGGER.debug("trx_trnsc insert...");
		for(int i=0;i<Const.BASIS_AUTH_ID.length;i++) {
			params.put("authrtId", Const.BASIS_AUTH_ID[i]);
			LOGGER.debug("params: " + params.toString());
			res = trxmngService.insertTrxAuth(params);
		}
		
		LOGGER.debug("res: " + res);
		return res;
	}
	
	
	@RequestMapping(value="/trx/modify", method=RequestMethod.POST)
	public int modifyTrx(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		
		LOGGER.debug("trx modify");
		LOGGER.debug("params: " + params.toString());
		
		@SuppressWarnings("unchecked")
		ArrayList<String> authrtIdList = (ArrayList<String>) params.get("authrtId");
		LOGGER.debug("authrtIdList: " + authrtIdList.toString());
		for(int i=0;i<authrtIdList.size();i++) {
			params.put("authrtId", authrtIdList.get(i));
			res=trxmngService.updateTrxAuth(params);
			LOGGER.debug("res: " + res);	
		}
		
		return res;
	}
	
	
	/**
	 * @apiNote
	 * 권한 추가
	 * @param
	 * authrtNm : 권한 이름
	 * authrtDesc : 권한 설명
	 * */
	@RequestMapping(value="/authrt", method=RequestMethod.POST)
	public int createAuthrt(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		LOGGER.debug("authrt create");
		LOGGER.debug("params: " + params.toString());
		HashMap<String, String> map = null; 
		map = trxmngService.selectMaxAuthrtId();
		String authrtId = String.valueOf(map.get("authrtid"));
		params.put("authrtId", authrtId);
		LOGGER.debug("params: " + params.toString());
		res=trxmngService.insertAuthrt(params);
		res = trxmngService.insertTrxAuth(params);
		LOGGER.debug("res: " + res);
		return res;
	}
	
	/** 
	 * 트랜잭션-삭제 
	 * params: {trxid,...}
	 */
	@RequestMapping(value="/trx/delete", method=RequestMethod.POST)
	public int deleteTrx(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		LOGGER.debug("trx delete");
		LOGGER.debug("params: " + params.toString());
		res=trxmngService.deleteTrnsc(params);
		res=trxmngService.deleteTrxTrnsc(params);

		return res;
	}
	
	/** 
	 * trnsc-삭제 
	 * params: {trxid,...}
	 */
	@RequestMapping(value="/trnsc/delete2", method=RequestMethod.POST)
	public int deleteTrnsc(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		LOGGER.debug("trnsc delete");
		LOGGER.debug("params: " + params.toString());
		res=trxmngService.deleteTrnsc(params);
		return res;
	}
	
	/** 
	 * authrt-삭제 
	 * params: {trxid,...}
	 */
	@RequestMapping(value="/authrt/delete", method=RequestMethod.POST)
	public int deleteAuthrt(@RequestBody HashMap<String, Object> params) throws Exception {
		int res = 999;
		LOGGER.debug("authrt delete");
		LOGGER.debug("params: " + params.toString());
		res=trxmngService.deleteAuthrt(params);
		return res;
	}
	
	/**
	 * 선택한 트랜잭션에 해당하는 권한목록 및 권한유무 리스트 조회
	 * @param params
	 * @return ResponseEntity<List<HashMap<String, Object>>>
	 * @throws Exception
	 * @author 이루리
	 * @since 2022.11.08
	 */
	@RequestMapping(value="/trnsc/authrt/list", method= RequestMethod.GET)
	public ResponseEntity<List<HashMap<String, Object>>> selectTrnscAuthrtList(@RequestParam String trnscId) throws Exception{
		List<HashMap<String, Object>> list = trxmngService.selectTrnscAuthrtList(trnscId);
		return new ResponseEntity<List<HashMap<String, Object>>>(list, HttpStatus.OK);
	}
	
	/**
	 * 트랙잭션 정보 추가
	 * @param params
	 * @throws Exception
	 * @author 이루리
	 * @since 2022.11.08
	 */
	@RequestMapping(value="/trnsc/save", method=RequestMethod.POST)
	public void saveTrnscInfo(@RequestBody HashMap<String, Object> params) throws Exception{
		trxmngService.saveTrnscInfo(params);
	}
	
	/**
	 * 트랙잭션 정보 삭제
	 * @param params
	 * @throws Exception
	 * @author 이루리
	 * @since 2022.11.08
	 */
	@RequestMapping(value="/trnsc/delete", method=RequestMethod.POST)
	public void deleteTrnscInfo(@RequestBody HashMap<String, Object> params) throws Exception{
		trxmngService.deleteTrnscInfo(params);
	}
	
	/**
	 * 트랙잭션 권한유무 변경
	 * @param params
	 * @throws Exception
	 * @author 이루리
	 * @since 2022.11.08
	 */
	@RequestMapping(value="/trnsc/authrt/modify", method=RequestMethod.POST)
	public void updateAuthrtInfo(@RequestBody HashMap<String, Object> params) throws Exception{
		trxmngService.updateAuthrtInfo(params);
	}
	
}
