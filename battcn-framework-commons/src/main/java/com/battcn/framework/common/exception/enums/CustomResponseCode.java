package com.battcn.framework.common.exception.enums;

public enum CustomResponseCode {
	/**
	 * 通用错误
	 */
	COMMON_ERROR_CODE(400, "未知错误"),
	INVALID(1001, "该记录不存在"),
	UNAUTHORIZED(1051, "未授权");
	private Integer code;
	private String message;

	public Integer code() {
		return code;
	}

	public String message() {
		return message;
	}

	private CustomResponseCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}