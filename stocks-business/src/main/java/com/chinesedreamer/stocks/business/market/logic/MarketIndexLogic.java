package com.chinesedreamer.stocks.business.market.logic;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.market.model.MarketIndex;

public interface MarketIndexLogic extends BaseLogic<MarketIndex, Long>{
	/**
	 * 查询某市场某日指数信息
	 * @param date
	 * @param code
	 * @return
	 */
	public MarketIndex findByDateAndCode(Integer date, String code);
}
