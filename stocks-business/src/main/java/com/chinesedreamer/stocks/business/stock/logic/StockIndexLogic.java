package com.chinesedreamer.stocks.business.stock.logic;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;

public interface StockIndexLogic extends BaseLogic<StockIndex, Long>{
	/**
	 * 查找某日的股指信息
	 * @param date
	 * @param stockCode
	 * @return
	 */
	public StockIndex findByDateAndStockCode(Integer date, String stockCode);
}
