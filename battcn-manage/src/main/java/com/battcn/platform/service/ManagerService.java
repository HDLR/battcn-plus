package com.battcn.platform.service;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.dto.ManagerDto;
import com.battcn.platform.pojo.po.Manager;
import com.github.pagehelper.PageInfo;

public interface ManagerService extends BaseService<Manager>{
	
	PageInfo<ManagerDto> listManagerByName(DataGrid grid, String name,String account);

}
