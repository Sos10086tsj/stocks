package com.chinesedreamer.stocks.domain.line.repository;

import java.util.List;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.line.model.MA;

public interface MARepository extends BaseRepository<MA, Long>{
	public MA findByStockCodeAndDate(String stockCode, Integer date);
	public List<MA> findByStockCodeOrderByDateAsc(String stockCode);
	public List<MA> findByStockCodeAndDateBetweenOrderByDateAsc(String stockCode,Integer starDate, Integer endDate);
}
