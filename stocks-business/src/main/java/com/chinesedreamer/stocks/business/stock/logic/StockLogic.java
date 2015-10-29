package com.chinesedreamer.stocks.business.stock.logic;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.stock.model.Stock;

public interface StockLogic extends BaseLogic<Stock, Long>{
	/**
	 * 根据市场和股票号码查询股票基本信息
	 * @param marketCode
	 * @param stockCode
	 * @return
	 */
	public Stock findByMarketCodeAndCode(String marketCode, String stockCode);
}
