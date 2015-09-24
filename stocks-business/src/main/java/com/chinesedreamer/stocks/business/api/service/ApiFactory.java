package com.chinesedreamer.stocks.business.api.service;

import javax.annotation.Resource;

import com.chinesedreamer.stocks.business.api.constant.ApiType;

public class ApiFactory {
	
	@Resource(name = "stockApiServiceShowApi")
	private ApiService stockApiServiceShowApiService;
	
	public ApiService getApiService(ApiType apiType) {
		ApiService apiService = null;
		switch (apiType) {
		case SHOWAPI:
			apiService = stockApiServiceShowApiService;
			break;
		default:
			break;
		}
		return apiService;
	}
}
