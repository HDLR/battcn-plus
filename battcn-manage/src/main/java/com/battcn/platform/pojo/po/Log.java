package com.battcn.platform.pojo.po;

import java.util.Date;
import javax.persistence.*;

import com.battcn.platform.pojo.RecordEntity;

@Table(name = "t_sys_log")
public class Log extends RecordEntity {
	
	private static final long serialVersionUID = 8674280943865600110L;

	/**
     * 自增ID
     */
    @Id
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 标题
     */
    private String title;

    /**
     * 执行的方法
     */
    private String methods;

    /**
     * 消息
     */
    private String message;

    /**
     * IP
     */
    private String ip;

    /**
     * 执行时间
     */
    private Short duration;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取执行的方法
     *
     * @return methods - 执行的方法
     */
    public String getMethods() {
        return methods;
    }

    /**
     * 设置执行的方法
     *
     * @param methods 执行的方法
     */
    public void setMethods(String methods) {
        this.methods = methods == null ? null : methods.trim();
    }

    /**
     * 获取消息
     *
     * @return message - 消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置消息
     *
     * @param message 消息
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * 获取IP
     *
     * @return ip - IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置IP
     *
     * @param ip IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取执行时间
     *
     * @return duration - 执行时间
     */
    public Short getDuration() {
        return duration;
    }

    /**
     * 设置执行时间
     *
     * @param duration 执行时间
     */
    public void setDuration(Short duration) {
        this.duration = duration;
    }

    /**
     * 获取请求地址
     *
     * @return url - 请求地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置请求地址
     *
     * @param url 请求地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取最后修改时间
     *
     * @return gmt_modified - 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置最后修改时间
     *
     * @param gmtModified 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取请求参数
     *
     * @return params - 请求参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置请求参数
     *
     * @param params 请求参数
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
    public Log(){}
	public Log(String title, String methods, String message) {
		super();
		this.title = title;
		this.methods = methods;
		this.message = message;
	}
    
    
}