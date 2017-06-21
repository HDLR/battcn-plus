package com.battcn.platform.pojo.dto;

import com.battcn.platform.pojo.po.Operate;

public class OperateDto extends Operate {

	private static final long serialVersionUID = -3513365887221708852L;
	
	private String menuName;// 菜单名称
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	

	
}
