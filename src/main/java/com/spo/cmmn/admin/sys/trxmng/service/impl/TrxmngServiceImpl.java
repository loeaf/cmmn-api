package com.spo.cmmn.admin.sys.trxmng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spo.cmmn.admin.sys.trxmng.mapper.mysql.TrxmngMapper;
import com.spo.cmmn.admin.sys.trxmng.service.TrxmngService;

@Service
public class TrxmngServiceImpl implements TrxmngService {

	@Autowired
    private TrxmngMapper trxmngMapper;
    
	@Override
	public List<HashMap<String, Object>> selectTrxList(HashMap<String, Object> params) throws Exception {
		List<HashMap<String, Object>> list = trxmngMapper.selectTrxList(params);
		return list;
	}

	@Override
	public List<HashMap<String, Object>> selectTrxnames() throws Exception {
		List<HashMap<String, Object>> list = trxmngMapper.selectTrxnames();
		return list;
	}

	@Override
	public List<HashMap<String, Object>> selectSyscode() throws Exception {
		List<HashMap<String, Object>> list = trxmngMapper.selectSyscode();
		return list;
	}
	
	@Override
	public List<HashMap<String, Object>> selectTrnscList(HashMap<String, Object> params) throws Exception {
		List<HashMap<String, Object>> list = trxmngMapper.selectTrnscList(params);
		return list;
	}
	
	@Override
	public int insertTrnsc(HashMap<String, Object> params) throws Exception {
		int res = trxmngMapper.insertTrnsc(params);
		return res;
	}

	@Override
	public int insertAuthrt(HashMap<String, Object> params) throws Exception {
		int res = trxmngMapper.insertAuthrt(params);
		return res;
	}
	
	@Override
	public int insertTrxAuth(HashMap<String, Object> params) throws Exception {
		int res = trxmngMapper.insertTrxAuth(params);
		return res;
	}

	@Override
	public List<HashMap<String, Object>> selectTrnscId(HashMap<String, Object> params) throws Exception {
		List<HashMap<String, Object>> list = trxmngMapper.selectTrnscId();
		return list;
	}

	@Override
	public int updateTrxAuth(HashMap<String, Object> params) throws Exception {
		int res = trxmngMapper.updateTrxAuth(params);
		return res;
	}

	@Override
	public List<HashMap<String, Object>> selectIsAuthrtTrnsc(HashMap<String, Object> params) throws Exception {
		List<HashMap<String, Object>> list = trxmngMapper.selectIsAuthrtTrnsc(params);
		return list;
	}

	@Override
	public int deleteTrxTrnsc(HashMap<String, Object> params) throws Exception {
		int res = trxmngMapper.deleteTrxTrnsc(params);
		return res;
	}

	@Override
	public int deleteTrnsc(HashMap<String, Object> params) throws Exception {
		int res = trxmngMapper.deleteTrnsc(params);
		return res;
	}
	
	@Override
	public int deleteAuthrt(HashMap<String, Object> params) throws Exception {
		int res = trxmngMapper.deleteAuthrt(params);
		return res;
	}
	
	@Override
	public List<HashMap<String, Object>> selectAuthrt(HashMap<String, Object> params) throws Exception {
		List<HashMap<String, Object>> list = trxmngMapper.selectAuthrt(params);
		return list;
	}

	@Override
	public HashMap<String, String> selectMaxAuthrtId() throws Exception {
		HashMap<String, String> map = trxmngMapper.selectMaxAuthrtId();
		return map;
	}
	
	public List<HashMap<String, Object>> selectTrnscAuthrtList(String trnscId) throws Exception{
		return trxmngMapper.selectTrnscAuthrtList(trnscId);
	}
	
	public void saveTrnscInfo(HashMap<String, Object> params) throws Exception{
		// 트랜잭션 ID가 없을 경우(추가)
		if("".equals(params.get("trnscId"))) {
			UUID uid = UUID.randomUUID();
			String trnsc = String.valueOf(uid);
			params.put("trnscId", trnsc);
			
			// 추가된 트랙잭션에 대한 권한목록 추가
			//trxmngMapper.insertDefaultAuthrtList(params);
		}
		
		// 트랙잭션 정보 추가/변경
		trxmngMapper.saveTrnscInfo(params);			
	}
	
	public void deleteTrnscInfo(HashMap<String, Object> params) throws Exception{
		trxmngMapper.deleteTrnscInfo(params);
	}
	
	public void updateAuthrtInfo(HashMap<String, Object> params) throws Exception{
		trxmngMapper.updateAuthrtInfo(params);
	}
}
