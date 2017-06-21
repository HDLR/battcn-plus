package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.battcn.platform.pojo.po.Menu;

@Mapper
public interface AuthMapper {
	
	List<Menu> listMenuByRoleId(@Param("roleId")Integer roleId);
}
