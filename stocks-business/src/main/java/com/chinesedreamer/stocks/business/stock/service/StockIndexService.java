package com.chinesedreamer.stocks.business.stock.service;

import com.chinesedreamer.stocks.domain.base.jpa.BaseService;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;

public interface StockIndexService extends BaseService<StockIndex, Long>{
	/**
	 * 解析json
	 * @param jsonResult
	 * @return
	 */
	public void syncStockIndex(String jsonResult);
	
	/**
	 * 同步时间段内股票指数信息
	 * @param jsonResult
	 */
	public void syncStockIndexScope(String jsonResult);
	
	
	/**
	 * 查询某日股票信息
	 * @param date
	 * @param stockCode
	 * @return
	 */
	public StockIndex findByDateAndStockCode(Integer date, String stockCode);
	
	
}
