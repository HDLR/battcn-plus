/**
 * File Name: com.battcn.platform.controller.pro.ProductController.java

 * @Date:2017年11月17日上午11:47:19
 */
package com.battcn.platform.controller.pro;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.battcn.framework.common.exception.BattcnException;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.pojo.dto.ProductsDto;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.ProductType;
import com.battcn.platform.pojo.po.Products;
import com.battcn.platform.service.ProductsService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * File Name: com.battcn.platform.controller.pro.ProductController.java
 * 
 * @Date:2017年11月17日上午11:47:19
 */
@Controller
@RequestMapping("/pro/data")
public class ProductController extends BaseController{

	@Value("${img.path}")
	protected String imgPath;
	@Value("${db.img.path}")
	protected String dbImgPath;
	@Autowired
	ProductsService productsService;
	
	@GetMapping("/list")
	public String list() throws BattcnException {
		return "pro/data/list";
	}
	@ApiIgnore
	@GetMapping("/edit")
	public String edit(Integer id)  {
		
		if (id != null) {
			// 获取子类 TODO
			Products products = productsService.selectById(id).get();
			List<ProductType> subList = productsService.listTypeByParentIds(new int[]{products.getParentId()});
			request.setAttribute("subDtos", subList);
			request.setAttribute("dto",products);
		}
		
		// 获取分类 TODO
		List<ProductType> parentTypeDto = productsService.listTypeByParentIds(new int[]{-1,-2});
		request.setAttribute("parentDtos",parentTypeDto);
		
		return "/pro/data/edit";
	}
	
	@RequestMapping(value = "/query")
	@ResponseBody
	@ApiOperation(value = "根据分页条件查询分页的结果集", httpMethod = "GET", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 404, message = "地址错误"),
			@ApiResponse(code = 500, message = "系统错误,请联系管理人员") })
	public PageInfo<ProductsDto> query(DataGrid grid,String productName,String typeName){
		return productsService.listForDataGridExchange(grid,productName);
	}
	
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public ApiResult<Products> save(Products products,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		products.setGmtModified(new Date());
		// 图片 TODO
		if (!file.isEmpty()) {
			String uuid = UUID.randomUUID().toString();
			String imgType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
			
			String imgName = uuid + imgType;
			file.transferTo(new File(imgPath + imgName)); // 存盘地址
			
			products.setImgUrl( dbImgPath + imgName ); // 数据库地址
			
		}		
		
		
		if (products.getProId() != null) {
			return ApiResult.getResponse( this.productsService.updateSelectiveById(products));
		}else {
			products.setGmtCreate(new Date());
			return ApiResult.getResponse( this.productsService.insertSelective(products) );
			
		}
	}
	
	
	@RequestMapping(value = "/listSub")
	@ResponseBody
	public ApiResult<List<ProductType>> listSub(Integer parentId){
		
		return ApiResult.getResponse(200, "success", productsService.listTypeByParentIds(new int[]{parentId}));
	}
}
