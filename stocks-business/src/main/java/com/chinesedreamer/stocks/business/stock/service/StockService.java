package com.chinesedreamer.stocks.business.stock.service;

import java.util.List;

import com.chinesedreamer.stocks.domain.stock.model.StockIndex;

public interface StockService {
	/**
	 * 解析json
	 * @param jsonResult
	 * @param marketCodes
	 * @return
	 */
	public List<StockIndex> parseJsonResult(String jsonResult, List<String> marketCodes);
}
