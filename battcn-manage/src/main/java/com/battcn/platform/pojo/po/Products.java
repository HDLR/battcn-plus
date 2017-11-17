package com.battcn.platform.pojo.po;

import com.battcn.platform.pojo.RecordEntity;
import javax.persistence.*;
@Table(name = "products")
public class Products extends RecordEntity {
    private static final long serialVersionUID = 3025004160237467042L;

	@Id
    @Column(name = "pro_id")
    private String proId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "sub_id")
    private Integer subId;

    private String description;

    /**
     * @return pro_id
     */
    public String getProId() {
        return proId;
    }

    /**
     * @param proId
     */
    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    /**
     * @return product_name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return sub_id
     */
    public Integer getSubId() {
        return subId;
    }

    /**
     * @param subId
     */
    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}