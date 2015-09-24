package com.chinesedreamer.stocks.business.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chinesedreamer.stocks.business.api.service.ApiService;
import com.chinesedreamer.stocks.business.market.service.MarketIndexService;

/**
 * 每日股票信息同步
 * @author Paris
 *
 */
@Component
public class DailySyncTask {
	private Logger logger = LoggerFactory.getLogger(DailySyncTask.class);
	
	@Resource
	private ApiService apiService;
	@Resource
	private MarketIndexService marketIndexService;
	
	
	/**
	 * 同步上证指数等
	 */
	@Scheduled(cron = "0 0 16 * * ?")
	public void syncMarketIndex(){
		try {
			this.marketIndexService.syncMarketIndex(this.apiService.getMarketIndexApiResult());
		} catch (Exception e) {
			logger.error("", e);
		}
	}
	
	/**
	 * 同步所有股票信息
	 */
	@Scheduled(cron = "0 15 16 * * ?")
	public void syncStocks() {
		
	}
	
	/**
	 * 同步锁有股指数信息
	 */
	@Scheduled(cron = "0 0 17 * * ?")
	public void syncStocksIndex(){
		
	}
}
