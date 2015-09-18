package com.chinesedreamer.stocks.business.sync.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.stock.service.StockService;
import com.chinesedreamer.stocks.business.sync.constant.StockApiType;
import com.chinesedreamer.stocks.business.sync.service.StockApiFactory;
import com.chinesedreamer.stocks.business.sync.service.StockSyncService;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;
import com.chinesedreamer.stocks.domain.stock.repository.StockIndexRepository;
import com.chinesedreamer.stocks.domain.user.model.UserFocus;
import com.chinesedreamer.stocks.domain.user.repository.UserFocusRepository;

@Service
public class StockSyncServiceImpl implements StockSyncService{
	
	@Resource
	private UserFocusRepository userFocusRepository;
	@Resource
	private StockIndexRepository stockIndexRepository;
	@Resource
	private StockService stockService;

	@Override
	public void syncFocus(Long userId) throws Exception  {
		//1. 获取用户关注的股票
		List<UserFocus> userFocuss = this.userFocusRepository.findByUserId(userId);
		//2. 获取股票信息
		String jsonResult = StockApiFactory.getInstance().getApiService(StockApiType.SHOWAPI).getApiResult(this.generateStocks(userFocuss));
		//3. 保存
		List<String> marketCodes = new ArrayList<String>();
		for (UserFocus userFocus : userFocuss) {
			marketCodes.add(userFocus.getMarketCode());
		}
		List<StockIndex> sis = stockService.parseJsonResult(jsonResult,marketCodes);
		for (StockIndex stockIndex : sis) {
			this.stockIndexRepository.save(stockIndex);
		}
	}

	private String generateStocks(List<UserFocus> userFocus) {
		StringBuffer stocksAppender = new StringBuffer("");
		for (int i = 0; i < userFocus.size(); i++) {
			stocksAppender.append(userFocus.get(i).getMarketCode())
			.append(userFocus.get(i).getStockCode());
			if (i < userFocus.size() - 1) {
				stocksAppender.append(",");
			}
		}
		return stocksAppender.toString();
	}

}
