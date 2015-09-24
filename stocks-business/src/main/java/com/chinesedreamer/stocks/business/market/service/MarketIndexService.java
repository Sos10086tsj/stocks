package com.chinesedreamer.stocks.business.market.service;

import com.chinesedreamer.stocks.domain.base.jpa.BaseService;
import com.chinesedreamer.stocks.domain.market.model.MarketIndex;

/**
 * 市场指数统计
 * @author Paris
 *
 */
public interface MarketIndexService extends BaseService<MarketIndex, Long>{
	/**
	 * 实时同步市场指数信息
	 * @throws Exception
	 */
	public void syncMarketIndex(String jsonResult) throws Exception;
}
