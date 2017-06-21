package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.Manager;

@Mapper
public interface ManagerMapper extends BaseMapper<Manager> {

	List<Manager> listManagerByName(@Param("name") String name, @Param("account") String account);

}