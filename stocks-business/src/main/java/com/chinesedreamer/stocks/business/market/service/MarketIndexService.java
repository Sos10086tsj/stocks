package com.chinesedreamer.stocks.business.market.service;

/**
 * 市场指数统计
 * @author Paris
 *
 */
public interface MarketIndexService {
	/**
	 * 实时同步市场指数信息
	 * @throws Exception
	 */
	public void realTimeSyncMarketIndex(String jsonResult) throws Exception;
}
