package com.chinesedreamer.stocks.business.task;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chinesedreamer.stocks.business.api.service.ApiService;
import com.chinesedreamer.stocks.business.market.service.MarketIndexService;
import com.chinesedreamer.stocks.business.stock.service.StockIndexService;
import com.chinesedreamer.stocks.business.user.service.UserFocusService;
import com.chinesedreamer.stocks.domain.user.model.UserFocus;

/**
 * 每日股票信息同步
 * @author Paris
 *
 */
@Component
public class StockAnalyzeTask {
	private Logger logger = LoggerFactory.getLogger(StockAnalyzeTask.class);
	
	@Resource
	private ApiService apiService;
	@Resource
	private MarketIndexService marketIndexService;
	@Resource
	private StockIndexService stockIndexService;
	@Resource
	private UserFocusService userFocusService;
	
	
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
	 * 同步关注的股票指数信息
	 */
	@Scheduled(cron = "0 5 16 * * ?")
	public void syncStocksIndex() {
		List<UserFocus> ufs = this.userFocusService.findAll();
		StringBuffer buffer = new StringBuffer();
		for (UserFocus uf : ufs) {
			buffer.append(uf.getMarketCode().toLowerCase())
			.append(",")
			.append(uf.getStockCode())
			.append(",");
		}
		String stocks = buffer.toString();
		if (stocks.endsWith(",")) {
			stocks = stocks.substring(0, stocks.length() - 1);
		}
		try {
			this.stockIndexService.syncStockIndex(this.apiService.getStocksApiResult(stocks));
		} catch (Exception e) {
			logger.error("", e);
		}
	}

}
