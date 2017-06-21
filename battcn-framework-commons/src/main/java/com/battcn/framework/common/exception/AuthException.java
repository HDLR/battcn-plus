package com.battcn.framework.common.exception;

import com.battcn.framework.common.exception.enums.CustomResponseCode;

public class AuthException extends BaseException {

	private static final long serialVersionUID = -8994969925213820584L;

	public static final int BAD_REQUEST = 1400;
	public static final int FORBIDDEN = 1403;
	public static final int NOT_FOUND = 1404;
	public static final int RESOURCE_REPLICATION = 1409;
	public static final int COMMON_CUSTOM_CODE = 1400;
	/**
	 * 规范的HTTP状态响应码,如400/403/503等
	 */
	private transient int code;
	/**
	 * 自定义返回码
	 */
	private int customCode;

	public static AuthException badRequest(String message) {
		return new AuthException(BAD_REQUEST, message);
	}

	public static AuthException badRequest(CustomResponseCode responseCode) {
		return new AuthException(BAD_REQUEST, responseCode.code(), responseCode.message());
	}

	public static AuthException badRequest(Integer customCode, String message) {
		return new AuthException(BAD_REQUEST, customCode, message);
	}

	public static AuthException notFound(String message) {
		return new AuthException(NOT_FOUND, message);
	}

	public static AuthException notFound(CustomResponseCode responseCode) {
		return new AuthException(NOT_FOUND, responseCode.code(), responseCode.message());
	}

	public static AuthException notFound(Integer customCode, String message) {
		return new AuthException(NOT_FOUND, customCode, message);
	}

	public static AuthException resourceReplication(String message) {
		return new AuthException(RESOURCE_REPLICATION, message);
	}

	public static AuthException forbidden() {
		return new AuthException(FORBIDDEN, "登录过期,请重新登录");
	}

	public AuthException(String message) {
		super(message);
		this.setCustomCode(BAD_REQUEST);
		this.setCode(BAD_REQUEST);
	}

	public AuthException(String message, Throwable e) {
		super(message, e);
		this.setCustomCode(BAD_REQUEST);
		this.setCode(BAD_REQUEST);
	}

	public AuthException(int code, String message) {
		super(message);
		this.setCustomCode(code);
		this.setCode(code);
	}

	public AuthException(int code, int customcode, String message) {
		super(message);
		this.setCustomCode(customcode);
		this.setCode(code);
	}

	public AuthException(int code, String message, Throwable t) {
		super(message, t);
		this.code = code;
	}

	public ErrorResponseEntity toErrorResponseEntity() {
		return new ErrorResponseEntity(this.customCode, this.getMessage());
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCustomCode() {
		return customCode;
	}

	public void setCustomCode(int customcode) {
		this.customCode = customcode;
	}

}
