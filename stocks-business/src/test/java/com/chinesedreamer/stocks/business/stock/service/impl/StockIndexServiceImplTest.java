package com.chinesedreamer.stocks.business.stock.service.impl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.chinesedreamer.stocks.business.api.service.ApiService;
import com.chinesedreamer.stocks.business.base.BaseTest;
import com.chinesedreamer.stocks.business.stock.service.StockIndexService;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;

public class StockIndexServiceImplTest extends BaseTest{

	@Resource
	private StockIndexService stockIndexService;
	@Resource(name = "stockApiServiceShowApi")
	private ApiService stockApiServiceShowApiService;
	
	@Test
	public void testFindOne() {
		
		StockIndex stock = this.stockIndexService.findOne(1l);
		assertNotNull(stock);
		System.out.println(stock.getStockName());
	}

	@Test
	@Rollback(value = false)
	public void testRealTimeSyncStockIndex(){
		try {
			List<String> marketCodes = new ArrayList<String>();
			marketCodes.add("sz");
			marketCodes.add("sz");
			String jsonResult = this.stockApiServiceShowApiService.getStocksApiResult("sz002024,sz000651");
			this.stockIndexService.syncStockIndex(jsonResult, marketCodes);
			StockIndex stockIndex = this.stockIndexService.findByDateAndStockCodeAndMarketCode(20150924, "002024", "sz");
			assertNotNull(stockIndex);
			System.out.println(stockIndex.getCompetBuyPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
