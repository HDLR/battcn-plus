/**
 * File Name: com.battcn.platform.service.ProductsService.java

 * @Date:2017年11月17日上午11:45:27
 */
package com.battcn.platform.service;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.dto.ProductsDto;
import com.battcn.platform.pojo.po.Products;
import com.github.pagehelper.PageInfo;

/**
 * File Name: com.battcn.platform.service.ProductsService.java
 * 
 * @Date:2017年11月17日上午11:45:27
 */
public interface ProductsService extends BaseService<Products>{

	/**
	 * listForDataGridExchange:<br>
	 * 
	 * @CreateTime 2017年11月17日 下午1:58:18
	 * @param grid
	 * @return
	 * @author zzwen6
	 * @修改记录: <br/>
	 */
	PageInfo<ProductsDto> listForDataGridExchange(DataGrid grid,String name);

}
