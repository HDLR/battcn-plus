package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.dto.ProductsDto;
import com.battcn.platform.pojo.po.ProductType;
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
	List<ProductsDto> selectByParam(@Param("productName")String productName);

	/**
	 * listTypeByParentIds:<br>
	 * 
	 * @CreateTime 2017年11月20日 下午1:38:19
	 * @param ids
	 * @return
	 * @author zzwen6
	 * @修改记录: <br/>
	 */
	List<ProductType> listTypeByParentIds(@Param("ids") int[] ids);
}