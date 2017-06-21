package com.battcn.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battcn.platform.mapper.OperateMapper;
import com.battcn.platform.service.IdentityService;

@Service
public class IdentityServiceImpl implements IdentityService {

	@Autowired
	OperateMapper operateMapper;
	
	
	@Override
	public void auth() {
		
		
		//Optional.ofNullable(this.operateMapper.listOperateByRoleIdAndMenuId(roleId, menuId)).orElseThrow(()->new RuntimeException("无权限"));
		
	}
	
	
	
	

}
