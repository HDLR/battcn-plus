/**
 * File Name: com.battcn.platform.controller.pro.ProductController.java

 * @Date:2017年11月17日上午11:47:19
 */
package com.battcn.platform.controller.pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battcn.framework.common.exception.BattcnException;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.pojo.dto.ProductsDto;
import com.battcn.platform.pojo.po.Products;
import com.battcn.platform.service.ProductsService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * File Name: com.battcn.platform.controller.pro.ProductController.java
 * 
 * @Date:2017年11月17日上午11:47:19
 */
@Controller
@RequestMapping("/pro/data")
public class ProductController extends BaseController{

	@Autowired
	ProductsService productsService;
	
	@GetMapping("/list")
	public String list() throws BattcnException {
		return "pro/data/list";
	}
	
	@RequestMapping(value = "/query")
	@ResponseBody
	@ApiOperation(value = "根据分页条件查询分页的结果集", httpMethod = "GET", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 404, message = "地址错误"),
			@ApiResponse(code = 500, message = "系统错误,请联系管理人员") })
	public PageInfo<ProductsDto> query(DataGrid grid,String name){
		return productsService.listForDataGridExchange(grid,name);
	}
	
}
