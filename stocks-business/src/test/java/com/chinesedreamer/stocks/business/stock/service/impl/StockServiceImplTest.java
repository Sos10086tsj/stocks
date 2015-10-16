package com.chinesedreamer.stocks.business.stock.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.chinesedreamer.stocks.business.api.service.ApiService;
import com.chinesedreamer.stocks.business.base.BaseTest;
import com.chinesedreamer.stocks.business.stock.service.StockService;

public class StockServiceImplTest extends BaseTest{
	
	@Resource
	private StockService stockService;
	@Resource
	private ApiService apiService;

	@Test
	@Rollback(value = false)
	public void testSyncStockIndex() {
		try {
			this.stockService.syncStockIndex(this.apiService.getStockApiResult("", "豫园商城"));
			this.stockService.syncStockIndex(this.apiService.getStockApiResult("", "太原重工"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
