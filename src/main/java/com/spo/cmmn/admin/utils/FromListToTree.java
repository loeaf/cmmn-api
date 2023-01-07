package com.spo.cmmn.admin.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FromListToTree {
	public List<TreeDTO> ListToTreeDTO(List<HashMap<String, Object>> resultList){
		List<TreeDTO> resultTreeDTO = new ArrayList<TreeDTO>();
		
		for(HashMap<String, Object> i : resultList) {
			TreeDTO t = new TreeDTO();
			t.setMenuId(String.valueOf(i.get("menuId")));
			t.setMenuNm(String.valueOf(i.get("menuNm")));
			t.setUpMenuId(String.valueOf(i.get("upMenuId")));
			t.setChildren(new ArrayList<TreeDTO>());
			
			boolean isChild = false;
			{
				Queue<TreeDTO> queue = new LinkedList<TreeDTO>(resultTreeDTO);
				TreeDTO j;
				while((j = queue.poll()) != null && !isChild) {
					if(j.getMenuId().equals(t.getUpMenuId())) {
						j.getChildren().add(t);
						isChild = true;
						break;
					}else {
						queue.addAll(j.getChildren());
					}
				}
			}
			
			if(!isChild) {
				for(int j = 0; j < resultTreeDTO.size(); j++) {
					TreeDTO jj = resultTreeDTO.get(j);
					if(jj.getUpMenuId().equals(t.getMenuId())) {
						t.getChildren().add(jj);
						resultTreeDTO.remove(j);
						j--;
					}
				}
				resultTreeDTO.add(t);
			}
		}
		
		return resultTreeDTO;
	}
}
