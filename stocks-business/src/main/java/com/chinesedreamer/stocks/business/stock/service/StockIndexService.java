package com.chinesedreamer.stocks.business.stock.service;

import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseService;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;

public interface StockIndexService extends BaseService<StockIndex, Long>{
	/**
	 * 解析json
	 * @param jsonResult
	 * @param marketCodes
	 * @return
	 */
	public void syncStockIndex(String jsonResult, List<String> marketCodes);
	
	
	/**
	 * 查询某日股票信息
	 * @param date
	 * @param stockCode
	 * @param marketCode
	 * @return
	 */
	public StockIndex findByDateAndStockCodeAndMarketCode(Integer date, String stockCode, String marketCode);
}
