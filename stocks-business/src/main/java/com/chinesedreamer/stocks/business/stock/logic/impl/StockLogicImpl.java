package com.chinesedreamer.stocks.business.stock.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.stock.logic.StockLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.stock.model.Stock;
import com.chinesedreamer.stocks.domain.stock.repository.StockRepository;

@Service
public class StockLogicImpl extends BaseLogicImpl<Stock, Long> implements StockLogic{
	
	@Resource
	private StockRepository repository;

	@Override
	public Stock findByMarketCodeAndCode(String marketCode, String stockCode) {
		return this.repository.findByMarketCodeAndCode(marketCode, stockCode);
	}

}
