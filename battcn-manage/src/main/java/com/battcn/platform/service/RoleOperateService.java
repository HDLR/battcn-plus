package com.battcn.platform.service;

import java.util.List;

import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.RoleOperate;

public interface RoleOperateService extends BaseService<RoleOperate> {

	List<RoleOperate> listRoleOperateByRoleId(Integer roleId);
	ApiResult<String> batchInsertRoleOperate(Integer operateId[],Integer roleId);
	
}
