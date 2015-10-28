package com.chinesedreamer.stocks.domain.session.constant;

public enum UserSessionClient {
	STOCKS_WEB(0),STOCKS_ANDROID(1),STOCKS_IOS(2);
	
	private final Integer value;
	
	private UserSessionClient(Integer value){
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
	
}
