package com.chinesedreamer.stocks.domain.line.model;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

/** 
 * Description: k线
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午7:27:01 
 * Copyright:   Copyright (c)2015
 */
public class KLine extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6286941119445308634L;

	private Long stockIndexId;	//股票指数ID	@link com.chinesedreamer.stocks.domain.stock.model.StockIndex.id
	
	//url
	private String minuteUrl;	//分时线查询
	private String dayUrl;		//日K线查询
	private String weekUrl;		//周K线查询
	private String monthUrl;	//月K线查询
	public Long getStockIndexId() {
		return stockIndexId;
	}
	public String getMinuteUrl() {
		return minuteUrl;
	}
	public String getDayUrl() {
		return dayUrl;
	}
	public String getWeekUrl() {
		return weekUrl;
	}
	public String getMonthUrl() {
		return monthUrl;
	}
	public void setStockIndexId(Long stockIndexId) {
		this.stockIndexId = stockIndexId;
	}
	public void setMinuteUrl(String minuteUrl) {
		this.minuteUrl = minuteUrl;
	}
	public void setDayUrl(String dayUrl) {
		this.dayUrl = dayUrl;
	}
	public void setWeekUrl(String weekUrl) {
		this.weekUrl = weekUrl;
	}
	public void setMonthUrl(String monthUrl) {
		this.monthUrl = monthUrl;
	}
	
	
}
