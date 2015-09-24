package com.chinesedreamer.stocks.business.api.exception;

/**
 * 访问达到上限
 * @author Paris
 *
 */
public class AccessLimitException extends ApiException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6128783174245531200L;

	private String code;
	
	private String message;
	
	public AccessLimitException(String message, Throwable cause){
		super(message, cause);
		this.message = message;
	}
	
	public AccessLimitException(String message){
		super(message);
		this.message = message;
	}
	
	public AccessLimitException(String message, String code){
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
