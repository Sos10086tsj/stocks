package com.chinesedreamer.stocks.common.exception;

public abstract class AbstractException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 18856454846675215L;
	
	private String code;
	
	private String message;
	
	public AbstractException(String message, Throwable cause){
		super(message, cause);
		this.message = message;
	}
	
	public AbstractException(String message){
		super(message);
		this.message = message;
	}
	
	public AbstractException(String message, String code){
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

}
