package com.chinesedreamer.stocks.business.user.exception;

import com.chinesedreamer.stocks.common.exception.BusinessException;

public class UserLoginException extends BusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8164367568201749879L;
	
	private String code;
	
	private String message;
	
	public UserLoginException(String message){
		super(message);
		this.message = message;
	}

	public UserLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
