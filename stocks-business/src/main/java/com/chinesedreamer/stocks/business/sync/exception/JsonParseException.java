package com.chinesedreamer.stocks.business.sync.exception;

/**
 * 位置错误 
 * @author Paris
 *
 */
public class JsonParseException extends SyncException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6128783174245531200L;

	private String code;
	
	private String message;
	
	public JsonParseException(String message, Throwable cause){
		super(message, cause);
		this.message = message;
	}
	
	public JsonParseException(String message){
		super(message);
		this.message = message;
	}
	
	public JsonParseException(String message, String code){
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
