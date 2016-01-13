package com.chinesedreamer.stocks.business.stock.logic;

import com.chinesedreamer.stocks.domain.base.jpa.BaseLogic;
import com.chinesedreamer.stocks.domain.market.model.MarketStop;

public interface MarketStopLogic extends BaseLogic<MarketStop, Long>{
	public MarketStop findByDate(Integer date);
}
