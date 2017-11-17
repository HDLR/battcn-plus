/**
 * File Name: com.battcn.platform.pojo.dto.ProductsDto.java

 * @Date:2017年11月17日下午1:54:45
 */
package com.battcn.platform.pojo.dto;

import com.battcn.platform.pojo.po.Products;

/**
 * File Name: com.battcn.platform.pojo.dto.ProductsDto.java
 * 
 * @Date:2017年11月17日下午1:54:45
 */
public class ProductsDto extends Products {

	private static final long serialVersionUID = 1L;

	private String parentName;
	
	private String subName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	
	
	
}
