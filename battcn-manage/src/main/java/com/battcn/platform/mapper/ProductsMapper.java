package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.dto.ProductsDto;
import com.battcn.platform.pojo.po.Products;

@Mapper
public interface ProductsMapper extends BaseMapper<Products> {

	/**
	 * selectByParam:<br>
	 * 
	 * @CreateTime 2017年11月17日 下午2:08:59
	 * @param name
	 * @return
	 * @author zzwen6
	 * @修改记录: <br/>
	 */
	List<ProductsDto> selectByParam(String name);
}