package com.chinesedreamer.stocks.business.stock.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.stock.logic.MarketStopLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.market.model.MarketStop;
import com.chinesedreamer.stocks.domain.market.repository.MarketStopRepository;

@Service
public class MarketStopLogicImpl extends BaseLogicImpl<MarketStop, Long> implements MarketStopLogic{
	@Resource
	private MarketStopRepository repository;

	@Override
	public MarketStop findByDate(Integer date) {
		return this.repository.findByDate(date);
	}
}
