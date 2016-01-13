package com.chinesedreamer.stocks.domain.stock.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午8:14:53 
 * Copyright:   Copyright (c)2015
 */
public interface StockIndexRepository extends BaseRepository<StockIndex, Long>{
	public StockIndex findByDateAndStockCode(Integer date, String stockCode);
	
	public List<StockIndex> findByDateLessThanEqualAndStockCodeOrderByDateDesc(Integer date, String stockCode, Pageable pageable);
}
