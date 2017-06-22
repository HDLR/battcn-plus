package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.dto.OperateDto;
import com.battcn.platform.pojo.dto.PermissionDto;
import com.battcn.platform.pojo.dto.ShiroPermission;
import com.battcn.platform.pojo.po.Operate;

@Mapper
public interface OperateMapper extends BaseMapper<Operate> {
	
	@Select("SELECT t2.* FROM t_sys_role_operate t1 JOIN t_sys_operate t2 ON t1.operate_id = t2.id AND t1.role_id = #{roleId} AND t2.menu_id = #{menuId}")
	List<Operate> listOperateByRoleIdAndMenuId(@Param("roleId")Integer roleId,@Param("menuId")Integer menuId);
	
	@Select("SELECT t.*,m.name AS menuName FROM t_sys_operate t JOIN t_sys_menu m ON m.id = t.menu_id")
	List<OperateDto> listOperateByPage();
	
	@Select("SELECT t1.id,t2.id AS menuId,t1.name,t2.name AS menuName,t2.pater_id,t1.op FROM t_sys_operate t1 JOIN t_sys_menu t2 ON t1.menu_id = t2.id ")
	List<PermissionDto> listPermissions();
	
	List<ShiroPermission> listShiroPermissionByRoleId(@Param("roleId")Integer roleId);
	
}