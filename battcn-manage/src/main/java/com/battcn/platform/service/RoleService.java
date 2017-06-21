package com.battcn.platform.service;

import java.util.List;

import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.dto.RoleOperateDto;
import com.battcn.platform.pojo.po.Role;

public interface RoleService extends BaseService<Role> {

	List<Role> listRole();
	void deleteRoleAndOperate(Integer ids[]);
	List<RoleOperateDto> listRoleOperateById(Integer id);

}
