package com.battcn.platform.config;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.battcn.framework.common.exception.AuthException;
import com.battcn.framework.common.exception.BattcnException;
import com.battcn.framework.common.exception.ErrorResponseEntity;

/**
 * ClassName:GrobalExceptionHandler <br/>
 *
 * @author Levin
 * @version 1.0
 * @see
 * @since 2017年06月15日
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ErrorResponseEntity jsonErrorHandler(Exception e, HttpServletResponse rep) throws Exception {
		logger.error("出错啦", e);
		if (e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
			rep.setStatus(400);
			return new ErrorResponseEntity(400, exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		} else if (e instanceof BattcnException) {
			BattcnException exception = (BattcnException) e;
			rep.setStatus(exception.getCode());
			return exception.toErrorResponseEntity();
		} else if (e instanceof AuthException) {
			AuthException exception = (AuthException) e;
			rep.setStatus(exception.getCode());
			return exception.toErrorResponseEntity();
		} else if (e instanceof IllegalArgumentException) {
			IllegalArgumentException exception = (IllegalArgumentException) e;
			rep.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ErrorResponseEntity(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
		} else if (e instanceof MultipartException) {
			rep.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ErrorResponseEntity(HttpStatus.BAD_REQUEST.value(), "图片大小不能超过3M");
		}
		rep.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ErrorResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器未知异常");
	}

	/**
	 * 通用的接口映射异常处理方法
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.error("出错啦", ex);
		if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
			return new ResponseEntity<>(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(), status);
		}
		if (ex instanceof MethodArgumentTypeMismatchException) {
			MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
			logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
					+ ",信息：" + exception.getLocalizedMessage());
			return new ResponseEntity<>("参数转换失败", status);
		}
		return new ResponseEntity<>("参数转换失败", status);
	}
}
