package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.Menu;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

	@Select("SELECT * FROM t_sys_menu WHERE locked = 1 ORDER BY scort ASC")
	List<Menu> listMenu();

	@Select("CALL refreshTreeNodes();")
	void refreshTreeNodes();
	
	
}