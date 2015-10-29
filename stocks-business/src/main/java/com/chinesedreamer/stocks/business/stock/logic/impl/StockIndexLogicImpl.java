package com.chinesedreamer.stocks.business.stock.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.stock.logic.StockIndexLogic;
import com.chinesedreamer.stocks.domain.base.jpa.BaseLogicImpl;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;
import com.chinesedreamer.stocks.domain.stock.repository.StockIndexRepository;

@Service
public class StockIndexLogicImpl extends BaseLogicImpl<StockIndex, Long> implements StockIndexLogic{
	
	@Resource
	private StockIndexRepository repository;

	@Override
	public StockIndex findByDateAndStockCode(Integer date, String stockCode) {
		return this.repository.findByDateAndStockCode(date, stockCode);
	}

}
