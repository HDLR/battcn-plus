/**
 * File Name: com.battcn.platform.service.impl.ProductsServiceImpl.java

 * @Date:2017年11月17日上午11:46:15
 */
package com.battcn.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.ProductsMapper;
import com.battcn.platform.pojo.dto.ProductsDto;
import com.battcn.platform.pojo.po.Products;
import com.battcn.platform.service.ProductsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * File Name: com.battcn.platform.service.impl.ProductsServiceImpl.java
 * 
 * @Date:2017年11月17日上午11:46:15
 */
@Service
public class ProductsServiceImpl extends BaseServiceImpl<Products> implements ProductsService{

	@Autowired
	ProductsMapper productsMapper;
	
	@Override
	public PageInfo<ProductsDto> listForDataGridExchange(DataGrid grid,String name) {
		// grid.getOrderBy();
		return PageHelper.startPage(grid.getPageNum(), grid.getPageSize()).doSelectPageInfo(() -> productsMapper.selectByParam(name));
		  
	}
}
