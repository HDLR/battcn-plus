package com.battcn.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.OperateMapper;
import com.battcn.platform.pojo.dto.OperateDto;
import com.battcn.platform.pojo.po.Operate;
import com.battcn.platform.service.OperateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OperateServiceImpl extends BaseServiceImpl<Operate> implements OperateService {

	@Autowired
	OperateMapper operateMapper;

	@Override
	public List<Operate> listOperateByRoleIdAndMenuId(Integer roleId, Integer menuId) {
		return this.operateMapper.listOperateByRoleIdAndMenuId(roleId, menuId);

	}

	@Override
	public PageInfo<OperateDto> listOperateByPage(DataGrid grid) {
		grid.getOrderBy();
		return PageHelper.startPage(grid.getPageNum(), grid.getPageSize())
				.doSelectPageInfo(() -> this.operateMapper.listOperateByPage());
	}

}
