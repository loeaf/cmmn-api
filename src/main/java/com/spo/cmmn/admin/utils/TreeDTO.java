package com.spo.cmmn.admin.utils;

import java.util.List;

public class TreeDTO {

	private String menuId;
	private String menuNm;
	private String upMenuId;
	private List<TreeDTO> children;
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getUpMenuId() {
		return upMenuId;
	}
	public void setUpMenuId(String upMenuId) {
		this.upMenuId = upMenuId;
	}
	public List<TreeDTO> getChildren() {
		return children;
	}
	public void setChildren(List<TreeDTO> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		return getMenuId() + " : " + getMenuNm();
	}
}
