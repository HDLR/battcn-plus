package com.battcn.platform.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.RoleOperateMapper;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.RoleOperate;
import com.battcn.platform.service.RoleOperateService;
import com.google.common.collect.Lists;

@Service
public class RoleOperateServiceImpl extends BaseServiceImpl<RoleOperate> implements RoleOperateService {

    @Autowired
    RoleOperateMapper roleOperateMapper;

    @Override
    public List<RoleOperate> listRoleOperateByRoleId(Integer roleId) {

        return this.roleOperateMapper.listRoleOperateByRoleId(roleId);
    }

    @Transactional
    @Override
    public ApiResult<String> batchInsertRoleOperate(Integer[] operateIds, Integer roleId) {
        this.roleOperateMapper.delete(new RoleOperate(roleId));
        List<RoleOperate> ops = Lists.newArrayList(operateIds).stream().map(id -> new RoleOperate(roleId, id, new Date())).collect(toList());
        int result = this.roleOperateMapper.batchInsertRoleOperate(ops);
        return ApiResult.getResponse(result > 0);
    }

}
