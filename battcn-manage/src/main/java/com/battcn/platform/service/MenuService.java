package com.battcn.platform.service;

import java.util.List;

import com.battcn.framework.common.model.TreeNode;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.dto.PermissionDto;
import com.battcn.platform.pojo.po.Menu;
import com.github.pagehelper.PageInfo;

public interface MenuService extends BaseService<Menu> {

	PageInfo<Menu> listMenuForDataGrid(DataGrid grid);
	List<TreeNode> listTree(Integer roleId);
	List<PermissionDto> listPermissions();
	List<Menu> listMenu();
	void saveOrUpdate(Menu menu);
	
}
