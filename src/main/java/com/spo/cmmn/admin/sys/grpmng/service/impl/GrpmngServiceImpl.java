package com.spo.cmmn.admin.sys.grpmng.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.cmmn.admin.sys.grpmng.mapper.mysql.GrpmngMapper;
import com.spo.cmmn.admin.sys.grpmng.service.GrpmngService;
import com.spo.cmmn.admin.utils.FromListToTree;
import com.spo.cmmn.admin.utils.TreeDTO;


@Service
public class GrpmngServiceImpl implements GrpmngService {

	@Autowired
    private GrpmngMapper grpmngMapper;

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly=true)
	public List<HashMap<String, Object>> selectAuthgrpList(HashMap<String, Object> params) throws Exception {
		List<HashMap<String, Object>> list = grpmngMapper.selectAuthgrpList(params);
		return list;
	}
	
	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly=true)
	public List<TreeDTO> selectMntree(HashMap<String, Object> params) throws Exception {
		List<HashMap<String, Object>> list = grpmngMapper.selectMntree(params);
		
		// 조회된 메뉴 목록을 TreeData 형태로 변경 Start
		FromListToTree fltt = new FromListToTree();
		// 조회된 메뉴 목록을 TreeData 형태로 변경 End
		
		return fltt.ListToTreeDTO(list);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly=true)
	public List<TreeDTO> selectMntreeAuthmenu(HashMap<String, Object> params) throws Exception {
		if(params.get("checkedMenuList") != null) {
			String[] checkedMenuList = params.get("checkedMenuList").toString().split(",");
			params.put("checkedMenuList", checkedMenuList);			
		}
		
		List<HashMap<String, Object>> list = grpmngMapper.selectMntreeAuthmenu(params);
		
		// 조회된 메뉴 목록을 TreeData 형태로 변경 Start
		FromListToTree fltt = new FromListToTree();
		// 조회된 메뉴 목록을 TreeData 형태로 변경 End
		
		return fltt.ListToTreeDTO(list);
	}

	@Override
	@Transactional(transactionManager = "mysqlTxManager", readOnly=true)
	public List<HashMap<String, Object>> selectAuthgrpTrgt(HashMap<String, Object> params) throws Exception {
		List<HashMap<String, Object>> list = grpmngMapper.selectAuthgrpTrgt(params);
		return list;
	}

	@Override
	public int modifyAuthgrp(HashMap<String, Object> params) throws Exception {
		int res = grpmngMapper.updateAuthgrp(params);
		return res;
	}

	@Override
	public int deleteAuthgrp(HashMap<String, Object> params) throws Exception {
		int res = grpmngMapper.deleteAuthgrp(params);
		return res;
	}
	

	@Override
	public void mntreeAuthmenuSave(HashMap<String, Object> params) throws Exception {
		grpmngMapper.mntreeAuthmenuDelete( String.valueOf(params.get("authrtId")));
		
		@SuppressWarnings("unchecked")
		List<String> authrtMenuList = (List<String>) params.get("authrtMenuList");
		for(String menuId : authrtMenuList) {
			params.put("menuId", menuId);
			grpmngMapper.mntreeAuthmenuSave(params);
		}
	}

	@Override
	public int insertAuthgrp(HashMap<String, Object> params) throws Exception {
		int res = grpmngMapper.insertAuthgrp(params);
		return res;
	}
}
