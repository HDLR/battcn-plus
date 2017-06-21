package com.battcn.platform.pojo.message;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 定义Api返回结果实体类
 * </p>
 * 
 * @author Levin
 * @date 2017-06-06
 */
@ApiModel(value = "ApiResult", description = "接口返回结果")
public class ApiResult<T> implements Serializable {

	private static final long serialVersionUID = 5657829410109424730L;
	private static final String OPERATION_SUCCESS = "操作成功!";
	private static final String OPERATION_FAILURE = "操作失败!";

	/**
	 * 消息id
	 */
	@ApiModelProperty(value = "消息id")
	private int messageId;
	/**
	 * 消息状态：-1-会话失效、1-成功、其他-失败
	 */
	@ApiModelProperty(value = "响应状态：-1-会话失效、1-成功、其他-失败")
	private int status;
	/**
	 * 消息内容
	 */
	@ApiModelProperty(value = "消息内容")
	private String message;
	/**
	 * 时间戳：Date 类型
	 */
	@ApiModelProperty(value = "时间戳")
	private Date timestamp;
	/**
	 * 返回数据
	 */
	@ApiModelProperty(value = "返回数据")
	private T data;

	private ApiResult(Builder<T> builder) {
		this.messageId = builder.messageId;
		this.status = builder.status;
		this.message = builder.message;
		this.timestamp = builder.timestamp;
		this.data = builder.data;
	}

	public static <T> ApiResult<T> getSuccess(String message,T data) {
		return getResponse(MessageId.GENERAL_SUCCESS, Status.FAILURE, message, null);
	}
	
	public static <T> ApiResult<T> getSuccess(String message) {
		return getSuccess(message, null);
	}
	
	public static ApiResult<String> getSuccess(MessageId messageId) {
		return getSuccess(messageId, null);
	}

	public static ApiResult<String> getSuccess(MessageId messageId, String message) {
		return getSuccess(messageId, message, null);
	}

	public static <T> ApiResult<T> getSuccess(MessageId messageId, T data) {
		return getResponse(messageId, Status.SUCCESS, null, data);
	}

	public static <T> ApiResult<T> getSuccess(MessageId messageId, String message, T data) {
		return getResponse(messageId, Status.SUCCESS, message, data);
	}
	
	public static <T> ApiResult<T> getFailure(String message,T data) {
		return getResponse(MessageId.GENERAL_SUCCESS, Status.FAILURE, message, null);
	}
	
	public static <T> ApiResult<T> getFailure(String message) {
		return getFailure(message, null);
	}

	public static ApiResult<?> getFailure(MessageId messageId, String message) {
		return getResponse(messageId, Status.FAILURE, message, null);
	}

	public static <T> ApiResult<T> getFailure(MessageId messageId, String message, T data) {
		return getResponse(messageId, Status.FAILURE, message, data);
	}
	public static <T> ApiResult<T> getResponse(Boolean flag){
		return flag ? getSuccess(OPERATION_SUCCESS) : getFailure(OPERATION_FAILURE);
	}
	public static <T> ApiResult<T> getResponse(Boolean flag,String message){
		return flag ? getSuccess(message) : getFailure(message);
	}
	public static <T> ApiResult<T> getResponse(MessageId messageId, Status status, String message, T data) {
		return new Builder<T>(messageId.getCode(), status.getValue(), new Date()).message(message).data(data).build();
	}

	public static class Builder<T> {
		private int messageId;
		private int status;
		private Date timestamp;
		private String message;
		private T data;

		public Builder(int messageId, int status, Date timestamp) {
			this.messageId = messageId;
			this.status = status;
			this.timestamp = timestamp;
		}

		public Builder<T> message(String message) {
			this.message = message;
			return this;
		}

		@SuppressWarnings("unchecked")
		public Builder<T> data(T data) {
			this.data = data == null ? (T) new JSONObject() : data;
			return this;
		}

		public ApiResult<T> build() {
			return new ApiResult<>(this);
		}
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}

enum Status {
	/**
	 * session失效
	 */
	EXPIRE(-1, "user.session_is_expired"),
	/**
	 * 成功
	 */
	SUCCESS(1, "operation.success"),
	/**
	 * 出错
	 */
	FAILURE(0, "operation.failure"),
	/**
	 * 请求错误
	 */
	BAD_REQUEST(400, "bad.request");

	private int value;
	private String name;

	Status(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
