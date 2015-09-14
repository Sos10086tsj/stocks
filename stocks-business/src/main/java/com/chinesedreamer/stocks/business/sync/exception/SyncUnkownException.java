package com.chinesedreamer.stocks.business.sync.exception;

/**
 * 返回结果解析错误
 * @author Paris
 *
 */
public class SyncUnkownException extends SyncException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6128783174245531200L;

	private String code;
	
	private String message;
	
	public SyncUnkownException(String message, Throwable cause){
		super(message, cause);
		this.message = message;
	}
	
	public SyncUnkownException(String message){
		super(message);
		this.message = message;
	}
	
	public SyncUnkownException(String message, String code){
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
