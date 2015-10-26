package com.chinesedreamer.stocks.business.user.constant;

public enum UserLoginSource {
	STOCKS_WEB(0);
	
	private final Integer value;
	
	private UserLoginSource(Integer value){
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
}
