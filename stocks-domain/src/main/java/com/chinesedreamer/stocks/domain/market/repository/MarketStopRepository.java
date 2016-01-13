package com.chinesedreamer.stocks.domain.market.repository;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.market.model.MarketStop;

public interface MarketStopRepository extends BaseRepository<MarketStop, Long>{
	public MarketStop findByDate(Integer date);
}
