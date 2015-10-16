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
	public void testFindOne() {
		
		StockIndex stock = this.stockIndexService.findOne(1l);
		assertNotNull(stock);
		System.out.println(stock.getStockName());
	}

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
			Date startDate = new Date(115, 8, 1);
			Date endDate = new Date(115,8,30);
			String jsonResult = this.stockApiServiceShowApiService.getStockIndexScopeApiReust("600655", startDate, endDate);
			this.stockIndexService.syncStockIndexScope(jsonResult);
			
			String jsonResult2 = this.stockApiServiceShowApiService.getStockIndexScopeApiReust("600169", startDate, endDate);
			this.stockIndexService.syncStockIndexScope(jsonResult2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
