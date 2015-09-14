package com.chinesedreamer.stocks.business.sync.service;

import javax.annotation.Resource;

import com.chinesedreamer.stocks.business.sync.constant.StockApiType;

public class StockApiFactory {
	
	private StockApiFactory(){}
	
	@Resource(name = "stockApiServiceShowApi")
	private StockApiService stockApiServiceShowApiService;
	
	public StockApiService getApiService(StockApiType apiType) {
		StockApiService apiService = null;
		switch (apiType) {
		case SHOWAPI:
			apiService = stockApiServiceShowApiService;
			break;
		default:
			break;
		}
		return apiService;
	}
	
	public static final StockApiFactory getInstance() {
		return LazyInstace.INSTANCE;
	}
	
	private static class LazyInstace{
		 private static final StockApiFactory INSTANCE = new StockApiFactory();
	}
}
