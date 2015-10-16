package com.chinesedreamer.stocks.business.stock.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinesedreamer.stocks.business.api.exception.JsonParseException;
import com.chinesedreamer.stocks.business.stock.service.StockIndexService;
import com.chinesedreamer.stocks.common.util.DateUtil;
import com.chinesedreamer.stocks.domain.base.jpa.BaseServiceImpl;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;
import com.chinesedreamer.stocks.domain.stock.repository.StockIndexRepository;

@Service
public class StockIndexServiceImpl extends BaseServiceImpl<StockIndex, Long> implements StockIndexService{
	
	@Resource
	private StockIndexRepository stockIndexRepository;

	@Override
	public void syncStockIndex(String jsonResult) {
		
		JSONObject jsonObject = JSON.parseObject(jsonResult);
		
		String showapiResCode = jsonObject.getString("showapi_res_code");
		if (!showapiResCode.equals("0")) {
			throw new JsonParseException(jsonObject.getString("showapi_res_error"), jsonObject.getString("showapi_res_code"));
		}
		JSONArray stockIndexs = jsonObject.getJSONObject("showapi_res_body").getJSONArray("list");
		for (int i = 0; i < stockIndexs.size(); i++) {
			JSONObject stockIndex = (JSONObject)stockIndexs.get(i);
			String stockCode = stockIndex.getString("code");
			
			StockIndex si = this.stockIndexRepository.findByDateAndStockCode(DateUtil.getTodayIntValue(), stockCode);
			if (null == si) {
				si = new StockIndex();
			}
			si.setStockCode(stockCode);
			si.setMarketCode(stockIndex.getString("market"));
			si.setStockName(stockIndex.getString("name"));
			si.setOpenPrice(stockIndex.getBigDecimal("openPrice"));
			si.setClosePrice(stockIndex.getBigDecimal("closePrice"));
			si.setNowPrice(stockIndex.getBigDecimal("nowPrice"));
			si.setTodayMax(stockIndex.getBigDecimal("todayMax"));
			si.setTodayMin(stockIndex.getBigDecimal("todayMin"));
			si.setCompetBuyPrice(stockIndex.getBigDecimal("competBuyPrice"));
			si.setCompetSellPrice(stockIndex.getBigDecimal("competSellPrice"));
			si.setTradeNum(stockIndex.getBigDecimal("tradeNum"));
			si.setTradeAmount(stockIndex.getBigDecimal("tradeAmount"));
			si.setBuy1Num(stockIndex.getBigDecimal("buy1_n"));
			si.setBuy1Price(stockIndex.getBigDecimal("buy1_m"));
			si.setBuy2Num(stockIndex.getBigDecimal("buy2_n"));
			si.setBuy2Price(stockIndex.getBigDecimal("buy2_m"));
			si.setBuy3Num(stockIndex.getBigDecimal("buy3_n"));
			si.setBuy3Price(stockIndex.getBigDecimal("buy3_m"));
			si.setBuy4Num(stockIndex.getBigDecimal("buy4_n"));
			si.setBuy4Price(stockIndex.getBigDecimal("buy4_m"));
			si.setBuy5Num(stockIndex.getBigDecimal("buy5_n"));
			si.setBuy5Price(stockIndex.getBigDecimal("buy5_m"));
			si.setSell1Num(stockIndex.getBigDecimal("sell1_n"));
			si.setSell1Price(stockIndex.getBigDecimal("sell1_m"));
			si.setSell2Num(stockIndex.getBigDecimal("sell2_n"));
			si.setSell2Price(stockIndex.getBigDecimal("sell2_m"));
			si.setSell3Num(stockIndex.getBigDecimal("sell3_n"));
			si.setSell3Price(stockIndex.getBigDecimal("sell3_m"));
			si.setSell4Num(stockIndex.getBigDecimal("sell4_n"));
			si.setSell4Price(stockIndex.getBigDecimal("sell4_m"));
			si.setSell5Num(stockIndex.getBigDecimal("sell5_n"));
			si.setSell5Price(stockIndex.getBigDecimal("sell5_m"));
			String dateStr = stockIndex.getString("date").replace("-", "");
			si.setDate(Integer.valueOf(dateStr));
			this.stockIndexRepository.save(si);
		}
	}

	@Override
	public StockIndex findByDateAndStockCode(Integer date, String stockCode) {
		return this.stockIndexRepository.findByDateAndStockCode(date, stockCode);
	}

	@Override
	public void syncStockIndexScope(String jsonResult) {
		JSONObject jsonObject = JSON.parseObject(jsonResult);
		
		String showapiResCode = jsonObject.getString("showapi_res_code");
		if (!showapiResCode.equals("0")) {
			throw new JsonParseException(jsonObject.getString("showapi_res_error"), jsonObject.getString("showapi_res_code"));
		}
		JSONArray stockIndexs = jsonObject.getJSONObject("showapi_res_body").getJSONArray("list");
		
		for (Object obj : stockIndexs) {
			JSONObject stockIndex = (JSONObject)obj;
			String stockCode = stockIndex.getString("code");
			String dateStr = stockIndex.getString("date").replace("-", "");
			Integer dateInt = Integer.parseInt(dateStr);
			StockIndex si = this.stockIndexRepository.findByDateAndStockCode(dateInt, stockCode);
			if (null == si) {
				si = new StockIndex();
			}
			si.setClosePrice(stockIndex.getBigDecimal("close_price"));
			si.setStockCode(stockCode);
			
			si.setDate(dateInt);
			si.setMarketCode(stockIndex.getString("market"));
			si.setTodayMax(stockIndex.getBigDecimal("max_price"));
			si.setTodayMin(stockIndex.getBigDecimal("min_price"));
			si.setOpenPrice(stockIndex.getBigDecimal("open_price"));
			si.setStockName(stockIndex.getString("stockName"));
			si.setTradeNum(stockIndex.getBigDecimal("trade_num"));
			si.setTradeAmount(stockIndex.getBigDecimal("trade_money"));
			this.stockIndexRepository.save(si);
		}
	}

}
