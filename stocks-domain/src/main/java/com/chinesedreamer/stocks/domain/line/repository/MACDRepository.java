package com.chinesedreamer.stocks.domain.line.repository;

import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.line.model.MACD;

public interface MACDRepository extends BaseRepository<MACD, Long>{
	public MACD findByStockCodeAndDate(String stockCode, Integer date);
	
	public List<MACD> findByStockCodeOrderByDateAsc(String stockCode);
	
	public List<MACD> findByStockCodeAndDateBetweenOrderByDateDesc(String stockCode,Integer startDate,Integer endDate);
}
