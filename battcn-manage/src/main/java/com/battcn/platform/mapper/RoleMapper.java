package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.dto.RoleOperateDto;
import com.battcn.platform.pojo.po.Role;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

	@Select("SELECT * FROM t_sys_role ORDER BY ID")
	List<Role> listRole();

	@Select("select t1.*,t2.op,t2.menu_id from t_sys_role_operate t1 JOIN t_sys_operate t2 ON t1.operate_id = t2.id  where t1.role_id = #{roleId}")
	List<RoleOperateDto> listRoleOperateById(@Param("roleId")Integer roleId);
	
}