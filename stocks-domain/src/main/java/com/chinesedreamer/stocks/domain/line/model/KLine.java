package com.chinesedreamer.stocks.domain.line.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

/** 
 * Description: k线
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午7:27:01 
 * Copyright:   Copyright (c)2015
 */
@Entity
@Table(name = "k_line")
public class KLine extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6286941119445308634L;

	@Column(name = "stock_id")
	private Long stockId;	//股票指数ID	@link com.chinesedreamer.stocks.domain.stock.model.StockIndex.id
	
	//url
	@Column(name = "minute_url")
	private String minuteUrl;	//分时线查询
	@Column(name = "day_url")
	private String dayUrl;		//日K线查询
	@Column(name = "week_url")
	private String weekUrl;		//周K线查询
	@Column(name = "month_url")
	private String monthUrl;	//月K线查询
	
	public Long getStockId() {
		return stockId;
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
	public void setStockId(Long stockId) {
		this.stockId = stockId;
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
