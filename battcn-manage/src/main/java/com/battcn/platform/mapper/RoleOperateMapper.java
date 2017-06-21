package com.battcn.platform.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.RoleOperate;

@Mapper
public interface RoleOperateMapper extends BaseMapper<RoleOperate> {
	
	
	@Select("SELECT * FROM	t_sys_role_operate WHERE role_id = #{roleId} ")
	List<RoleOperate> listRoleOperateByRoleId(Integer roleId);
	
	int batchInsertRoleOperate(List<RoleOperate> ops);
	
	@Delete("DELETE FROM t_sys_role_operate WHERE role_id = #{roleId}")
	int deleteRoleOperateByRoleId(Integer roleId);
	
	
}