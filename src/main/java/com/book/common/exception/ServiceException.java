package com.book.common.exception;

/**
 * 自定义异常是对异常信息
 * @author LiYuanbin
 * @since 2018年3月30日
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -4181072079763562413L;
	public ServiceException() {
		super();
	}
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
