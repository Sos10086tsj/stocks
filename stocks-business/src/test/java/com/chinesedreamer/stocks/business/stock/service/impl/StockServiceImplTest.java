package com.chinesedreamer.stocks.business.stock.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.chinesedreamer.stocks.business.api.service.ApiService;
import com.chinesedreamer.stocks.business.base.BaseTest;
import com.chinesedreamer.stocks.business.stock.service.StockService;
import com.chinesedreamer.stocks.domain.stock.model.Stock;

public class StockServiceImplTest extends BaseTest{
	
	@Resource
	private StockService stockService;
	@Resource
	private ApiService apiService;

	@Test
	@Rollback(value = false)
	public void testSyncStockIndex() {
		Stock stock = this.stockService.findByMarketCodeAndCode("sz", "002024");
		assertNull(stock);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>pass");
		try {
			this.stockService.syncStockIndex(this.apiService.getStockApiResult("", "苏宁云商"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Stock stock2 = this.stockService.findByMarketCodeAndCode("sz", "002024");
		assertNotNull(stock2);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>pass stock:" + stock2.getName());
	}

}
