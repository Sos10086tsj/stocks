package com.chinesedreamer.stocks.business.market.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.market.logic.MarketIndexLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.market.model.MarketIndex;
import com.chinesedreamer.stocks.domain.market.repository.MarketIndexRepository;

@Service
public class MarketIndexLogicImpl extends BaseLogicImpl<MarketIndex, Long> implements MarketIndexLogic{
	
	@Resource
	private MarketIndexRepository repository;

	@Override
	public MarketIndex findByDateAndCode(Integer date, String code) {
		return this.repository.findByDateAndCode(date, code);
	}

}
