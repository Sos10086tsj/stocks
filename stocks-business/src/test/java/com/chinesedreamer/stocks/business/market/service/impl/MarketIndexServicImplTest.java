package com.chinesedreamer.stocks.business.market.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.chinesedreamer.stocks.business.api.service.ApiService;
import com.chinesedreamer.stocks.business.base.BaseTest;
import com.chinesedreamer.stocks.business.market.service.MarketIndexService;

public class MarketIndexServicImplTest extends BaseTest{
	
	@Resource
	private MarketIndexService marketIndexService;
	@Resource
	private ApiService apiService;

	@Test
	@Rollback(value = false)
	public void testRealTimeSyncMarketIndex() {
		try {
			this.marketIndexService.syncMarketIndex(this.apiService.getMarketIndexApiResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
