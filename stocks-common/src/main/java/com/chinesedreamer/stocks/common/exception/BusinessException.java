package com.chinesedreamer.stocks.common.exception;

public class BusinessException extends AbstractException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7535742999581342648L;

	private String code;
	
	private String message;
	
	public BusinessException(String message, Throwable cause){
		super(message, cause);
		this.message = message;
	}
	
	public BusinessException(String message){
		super(message);
		this.message = message;
	}
	
	public BusinessException(String message, String code){
		super(message);
		this.message = message;
		this.code = code;
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
