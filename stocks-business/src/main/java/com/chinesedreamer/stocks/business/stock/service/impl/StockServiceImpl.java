package com.chinesedreamer.stocks.business.stock.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinesedreamer.stocks.business.api.exception.JsonParseException;
import com.chinesedreamer.stocks.business.stock.logic.StockLogic;
import com.chinesedreamer.stocks.business.stock.service.StockService;
import com.chinesedreamer.stocks.domain.stock.model.Stock;

@Service
public class StockServiceImpl implements StockService{
	
	@Resource
	private StockLogic logic;

	@Override
	public void syncStockIndex(String jsonResult) {
		JSONObject jsonObject = JSON.parseObject(jsonResult);
		String showapiResCode = jsonObject.getString("showapi_res_code");
		if (!showapiResCode.equals("0")) {
			throw new JsonParseException(jsonObject.getString("showapi_res_error"), jsonObject.getString("showapi_res_code"));
		}
		JSONArray stocks = jsonObject.getJSONObject("showapi_res_body").getJSONArray("list");
		for (int i = 0; i < stocks.size(); i++) {
			JSONObject stock = (JSONObject)stocks.get(i);
			String stockCode = stock.getString("code");
			String marketCode = stock.getString("market");
			Stock s = this.logic.findByMarketCodeAndCode(marketCode, stockCode);
			if (null == s) {
				s = new Stock();
			}
			s.setCode(stockCode);
			s.setMarketCode(marketCode);
			s.setName(stock.getString("name"));
			s.setPinyin(stock.getString("pinyin"));
			this.logic.save(s);
		}
	}

	@Override
	public Stock findByMarketCodeAndCode(String marketCode, String code) {
		return this.logic.findByMarketCodeAndCode(marketCode, code);
	}

}
