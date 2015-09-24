package com.chinesedreamer.stocks.business.market.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinesedreamer.stocks.business.api.exception.JsonParseException;
import com.chinesedreamer.stocks.business.market.service.MarketIndexService;
import com.chinesedreamer.stocks.common.util.DateUtil;
import com.chinesedreamer.stocks.domain.market.model.MarketIndex;
import com.chinesedreamer.stocks.domain.market.repository.MarketIndexRepository;

@Service
public class MarketIndexServicImpl implements MarketIndexService{
	
	@Resource
	private MarketIndexRepository marketIndexRepository;

	@Override
	public void realTimeSyncMarketIndex(String jsonResult) throws Exception {
		JSONObject jsonObject = JSON.parseObject(jsonResult);
		String showapiResCode = jsonObject.getString("showapi_res_code");
		if (!showapiResCode.equals("0")) {
			throw new JsonParseException(jsonObject.getString("showapi_res_error"), jsonObject.getString("showapi_res_code"));
		}
		JSONArray indexList = jsonObject.getJSONObject("showapi_res_body").getJSONArray("indexList");
		for (Object object : indexList) {
			JSONObject index = (JSONObject)object;
			String code = index.getString("code");
			String marketCode = code.substring(0, 1);
			BigDecimal maxPrice = index.getBigDecimal("maxPrice");
			BigDecimal minPrice = index.getBigDecimal("minPrice");
			String name = index.getString("name");
			BigDecimal nowPrice = index.getBigDecimal("nowPrice");
			Integer date = DateUtil.getTodayIntValue();
			BigDecimal todayOpenPrice = index.getBigDecimal("todayOpenPrice");
			BigDecimal tradeAmount = index.getBigDecimal("tradeAmount");
			BigDecimal tradeNum = index.getBigDecimal("tradeNum");
			BigDecimal yestodayClosePrice = index.getBigDecimal("yestodayClosePrice");
			MarketIndex mi = this.marketIndexRepository.findByDateAndCode(date, marketCode);
			if (null == mi) {
				mi = new MarketIndex();
				mi.setDate(date);
				mi.setMarketCode(marketCode);
				mi.setCode(code);
			}
			mi.setMaxPrice(maxPrice);
			mi.setMinPrice(minPrice);
			mi.setName(name);
			mi.setNowPrice(nowPrice);
			mi.setTodayOpenPrice(todayOpenPrice);
			mi.setTradeAmount(tradeAmount);
			mi.setTradeNum(tradeNum);
			mi.setYestodayClosePrice(yestodayClosePrice);
			this.marketIndexRepository.save(mi);
		}
	}

}
