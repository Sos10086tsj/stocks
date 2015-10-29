package com.chinesedreamer.stocks.domain.session.constant;

public enum UserSessionClient {
	DEFAULT(-1),STOCKS_WEB(0),STOCKS_ANDROID(1),STOCKS_IOS(2);
	
	private final Integer value;
	
	private UserSessionClient(Integer value){
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
	public static UserSessionClient get(Integer value) {
		for (UserSessionClient usc : UserSessionClient.values()) {
			if (usc.getValue().equals(value)) {
				return usc;
			}
		}
		return UserSessionClient.DEFAULT;
	}
	
}
