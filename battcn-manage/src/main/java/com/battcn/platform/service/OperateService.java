package com.battcn.platform.service;

import java.util.List;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.dto.OperateDto;
import com.battcn.platform.pojo.po.Operate;
import com.github.pagehelper.PageInfo;

public interface OperateService extends BaseService<Operate> {

	List<Operate> listOperateByRoleIdAndMenuId(Integer roleId,Integer menuId);
	
	PageInfo<OperateDto> listOperateByPage(DataGrid grid);
	
}
