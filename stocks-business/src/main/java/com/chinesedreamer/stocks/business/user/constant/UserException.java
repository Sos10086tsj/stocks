package com.chinesedreamer.stocks.business.user.constant;

public enum UserException {
	USER_NOT_EXIST("ERR_USER_001","user not exist."),
	USER_PASS_NOT_MATCH("ERR_USER_002","username and password not match."),
	USER_PASS_ILLEGAL("ERR_USER_003","user or password is illegal."),
	USER_EXIST("ERR_USER_004","user is already exist.");
	
	private final String code;
	private final String message;
	
	private UserException(String code, String message){
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
