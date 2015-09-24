package com.chinesedreamer.stocks.business.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 每日股票信息同步
 * @author Paris
 *
 */
@Component
public class DailySyncTask {
	/**
	 * 同步上证指数等
	 */
	@Scheduled(cron = "0 0 16 * * ?")
	public void syncMarketIndex(){
		
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
