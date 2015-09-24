package com.chinesedreamer.stocks.domain.stock.repository;

import com.chinesedreamer.stocks.domain.base.jpa.BaseRepository;
import com.chinesedreamer.stocks.domain.stock.model.Stock;

/** 
 * Description: 
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午8:14:29 
 * Copyright:   Copyright (c)2015
 */
public interface StockRepository extends BaseRepository<Stock, Long>{
	public Stock findByMarketCodeAndCode(String marketCode, String code);
}
