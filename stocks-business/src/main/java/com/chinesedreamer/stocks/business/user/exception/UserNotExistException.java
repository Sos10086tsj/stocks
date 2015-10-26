package com.chinesedreamer.stocks.business.user.exception;

public class UserNotExistException extends UserLoginException{
	
	private String code;
	
	private String message;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3064968016970249576L;

	public UserNotExistException(String message){
		super(message);
		this.message = message;
	}
	
	public UserNotExistException(String message, Throwable cause) {
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
