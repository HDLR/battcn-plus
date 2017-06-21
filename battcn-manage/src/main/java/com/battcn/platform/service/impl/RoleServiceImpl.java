package com.battcn.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.RoleMapper;
import com.battcn.platform.mapper.RoleOperateMapper;
import com.battcn.platform.pojo.dto.RoleOperateDto;
import com.battcn.platform.pojo.po.Role;
import com.battcn.platform.service.RoleService;
import com.google.common.collect.Lists;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Autowired
	RoleMapper roleMapper;
	@Autowired
	RoleOperateMapper roleOperateMapper;

	@Override
	public List<Role> listRole() {

		return roleMapper.listRole();
	}

	@Override
	public List<RoleOperateDto> listRoleOperateById(Integer id) {
		return this.roleMapper.listRoleOperateById(id);
	}

	@Transactional
	@Override
	public void deleteRoleAndOperate(Integer ids[]) {
		Lists.newArrayList(ids).forEach(id -> {
			super.deleteById(id);
			this.roleOperateMapper.deleteRoleOperateByRoleId(id);
		});
	}

}
