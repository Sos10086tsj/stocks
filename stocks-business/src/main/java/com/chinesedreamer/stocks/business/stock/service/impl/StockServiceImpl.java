package com.chinesedreamer.stocks.business.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinesedreamer.stocks.business.stock.service.StockService;
import com.chinesedreamer.stocks.business.sync.exception.JsonParseException;
import com.chinesedreamer.stocks.common.util.DateUtil;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;
import com.chinesedreamer.stocks.domain.stock.repository.StockIndexRepository;

@Service
public class StockServiceImpl implements StockService{
	
	@Resource
	private StockIndexRepository stockIndexRepository;

	@Override
	public List<StockIndex> parseJsonResult(String jsonResult, List<String> marketCodes) {
		List<StockIndex> stockIndexs = new ArrayList<StockIndex>();
		
		JSONObject jsonObject = JSON.parseObject(jsonResult);
		
		String showapiResCode = jsonObject.getString("showapi_res_code");
		if (!showapiResCode.equals("0")) {
			throw new JsonParseException(jsonObject.getString("showapi_res_error"), jsonObject.getString("showapi_res_code"));
		}
		JSONArray stocks = jsonObject.getJSONArray("list");
		for (int i = 0; i < stocks.size(); i++) {
			JSONObject stock = (JSONObject)stocks.get(i);
			String stockCode = stock.getString("code");
			
			StockIndex si = this.stockIndexRepository.findByDateAndStockCodeAndMarketCode(DateUtil.getTodayIntValue(), stockCode,marketCodes.get(i));
			if (null == si) {
				si = new StockIndex();
			}
			si.setStockName(stock.getString("name"));
			si.setOpenPrice(stock.getBigDecimal("openPrice"));
			si.setClosePrice(stock.getBigDecimal("closePrice"));
			si.setNowPrice(stock.getBigDecimal("nowPrice"));
			si.setTodayMax(stock.getBigDecimal("todayMax"));
			si.setTodayMin(stock.getBigDecimal("todayMin"));
			si.setCompetBuyPrice(stock.getBigDecimal("competBuyPrice"));
			si.setCompetSellPrice(stock.getBigDecimal("competSellPrice"));
			si.setCompetSellPrice(stock.getBigDecimal("tradeNum"));
			si.setTradeAmount(stock.getBigDecimal("tradeAmount"));
			si.setBuy1Num(stock.getBigDecimal("buy1_n"));
			si.setBuy1Price(stock.getBigDecimal("buy1_m"));
			si.setBuy2Num(stock.getBigDecimal("buy2_n"));
			si.setBuy2Price(stock.getBigDecimal("buy2_m"));
			si.setBuy3Num(stock.getBigDecimal("buy3_n"));
			si.setBuy3Price(stock.getBigDecimal("buy3_m"));
			si.setBuy4Num(stock.getBigDecimal("buy4_n"));
			si.setBuy4Price(stock.getBigDecimal("buy4_m"));
			si.setBuy5Num(stock.getBigDecimal("buy5_n"));
			si.setBuy5Price(stock.getBigDecimal("buy5_m"));
			si.setSell1Num(stock.getBigDecimal("sell1_n"));
			si.setSell1Price(stock.getBigDecimal("sell1_m"));
			si.setSell2Num(stock.getBigDecimal("sell2_n"));
			si.setSell2Price(stock.getBigDecimal("sell2_m"));
			si.setSell3Num(stock.getBigDecimal("sell3_n"));
			si.setSell3Price(stock.getBigDecimal("sell3_m"));
			si.setSell4Num(stock.getBigDecimal("sell4_n"));
			si.setSell4Price(stock.getBigDecimal("sell4_m"));
			si.setBuy5Num(stock.getBigDecimal("sell5_n"));
			si.setSell5Price(stock.getBigDecimal("sell5_m"));
			si.setDate(stock.getInteger("date"));
			stockIndexs.add(si);
		}
		return stockIndexs;
	}

}
