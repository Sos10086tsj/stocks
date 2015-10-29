package com.chinesedreamer.stocks.business.stock.service;

import com.chinesedreamer.stocks.domain.stock.model.Stock;

public interface StockService{
	/**
	 * 同步上市公司信息
	 * @param jsonResult
	 */
	public void syncStockIndex(String jsonResult);
	
	/**
	 * 根据市场和股票代码查询上市公司信息
	 * @param marketCode
	 * @param code
	 * @return
	 */
	public Stock findByMarketCodeAndCode(String marketCode, String code);
}
