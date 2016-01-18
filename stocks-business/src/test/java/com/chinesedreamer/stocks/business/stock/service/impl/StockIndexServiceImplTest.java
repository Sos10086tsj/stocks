package com.chinesedreamer.stocks.business.stock.service.impl;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

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
	@Rollback(value = false)
	public void testRealTimeSyncStockIndex(){
		try {
			String jsonResult = this.stockApiServiceShowApiService.getStocksApiResult("sz000930,sz000616,sh600811");
			this.stockIndexService.syncStockIndex(jsonResult);
			StockIndex stockIndex = this.stockIndexService.findByDateAndStockCode(20151008, "000930");
			assertNotNull(stockIndex);
			System.out.println(stockIndex.getCompetBuyPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Rollback(value = false)
	public void testSyncStockIndexScope(){
		try {
			Date startDate = new Date(115, 10, 23);
			Date endDate = new Date(115, 11, 1);
			String jsonResult = this.stockApiServiceShowApiService.getStockIndexScopeApiReust("002024", startDate, endDate);
			this.stockIndexService.syncStockIndexScope(jsonResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
