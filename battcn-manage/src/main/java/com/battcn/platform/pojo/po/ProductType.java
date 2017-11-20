/**
 * File Name: com.battcn.platform.pojo.po.ProductType.java

 * @Date:2017年11月20日上午11:59:53
 */
package com.battcn.platform.pojo.po;

/**
 * File Name: com.battcn.platform.pojo.po.ProductType.java
 * 
 * @Date:2017年11月20日上午11:59:53
 */
public class ProductType {

    private Integer typeId;

    private String typeName;

    private Integer parentId;

    private String url;

    private Integer sort;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
