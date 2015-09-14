package com.chinesedreamer.stocks.domain.stock.model;

import java.math.BigDecimal;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

/** 
 * Description: 股票行情
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午6:47:20 
 * Copyright:   Copyright (c)2015
 */
public class StockIndex extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -989477347242698561L;

	//基本信息
	private Integer date;					//日期
	private String marketCode;			//市场		sz		@link com.chinesedreamer.stocks.domain.market.model.Market.code
	private String stockCode;			//股票编码		000002	@link com.chinesedreamer.stocks.domain.stock.model.Stock.code
	private String stockName;			//股票名称		@link com.chinesedreamer.stocks.domain.stock.model.Stock.name
	
	//价格信息
	private BigDecimal openPrice;		//今日开盘价
	private BigDecimal closePrice;		//昨日收盘价
	private BigDecimal nowPrice;		//当前价格
	private BigDecimal todayMax;		//今日最高价
	private BigDecimal todayMin;		//今日最低价
	private BigDecimal competBuyPrice;	//竞买价
	private BigDecimal competSellPrice;	//竞卖价
	
	//成交信息
	private BigDecimal tradeNum;		//成交量
	private BigDecimal tradeAmount;		//成交金额
	
	//购买信息
	private BigDecimal buy1Num;			//买一数量
	private BigDecimal buy1Price;		//买一报价
	private BigDecimal buy2Num;			//买二数量
	private BigDecimal buy2Price;		//买二报价
	private BigDecimal buy3Num;			//买三数量
	private BigDecimal buy3Price;		//买三报价
	private BigDecimal buy4Num;			//买四数量
	private BigDecimal buy4Price;		//买四报价
	private BigDecimal buy5Num;			//买五数量
	private BigDecimal buy5Price;		//买五报价
	private BigDecimal sell1Num;		//卖一数量
	private BigDecimal sell1Price;		//卖一报价
	private BigDecimal sell2Num;		//卖二数量
	private BigDecimal sell2Price;		//卖二报价
	private BigDecimal sell3Num;		//卖三数量
	private BigDecimal sell3Price;		//卖三报价
	private BigDecimal sell4Num;		//卖四数量
	private BigDecimal sell4Price;		//卖四报价
	private BigDecimal sell5Num;		//卖五数量
	private BigDecimal sell5Price;		//卖五报价
	
	public String getMarketCode() {
		return marketCode;
	}
	public String getStockCode() {
		return stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public BigDecimal getOpenPrice() {
		return openPrice;
	}
	public BigDecimal getClosePrice() {
		return closePrice;
	}
	public BigDecimal getNowPrice() {
		return nowPrice;
	}
	public BigDecimal getTodayMax() {
		return todayMax;
	}
	public BigDecimal getTodayMin() {
		return todayMin;
	}
	public BigDecimal getCompetBuyPrice() {
		return competBuyPrice;
	}
	public BigDecimal getCompetSellPrice() {
		return competSellPrice;
	}
	public BigDecimal getTradeNum() {
		return tradeNum;
	}
	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}
	public BigDecimal getBuy1Num() {
		return buy1Num;
	}
	public BigDecimal getBuy1Price() {
		return buy1Price;
	}
	public BigDecimal getBuy2Num() {
		return buy2Num;
	}
	public BigDecimal getBuy2Price() {
		return buy2Price;
	}
	public BigDecimal getBuy3Num() {
		return buy3Num;
	}
	public BigDecimal getBuy3Price() {
		return buy3Price;
	}
	public BigDecimal getBuy4Num() {
		return buy4Num;
	}
	public BigDecimal getBuy4Price() {
		return buy4Price;
	}
	public BigDecimal getBuy5Num() {
		return buy5Num;
	}
	public BigDecimal getBuy5Price() {
		return buy5Price;
	}
	public BigDecimal getSell1Num() {
		return sell1Num;
	}
	public BigDecimal getSell1Price() {
		return sell1Price;
	}
	public BigDecimal getSell2Num() {
		return sell2Num;
	}
	public BigDecimal getSell2Price() {
		return sell2Price;
	}
	public BigDecimal getSell3Num() {
		return sell3Num;
	}
	public BigDecimal getSell3Price() {
		return sell3Price;
	}
	public BigDecimal getSell4Num() {
		return sell4Num;
	}
	public BigDecimal getSell4Price() {
		return sell4Price;
	}
	public BigDecimal getSell5Num() {
		return sell5Num;
	}
	public BigDecimal getSell5Price() {
		return sell5Price;
	}
	
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}
	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}
	public void setNowPrice(BigDecimal nowPrice) {
		this.nowPrice = nowPrice;
	}
	public void setTodayMax(BigDecimal todayMax) {
		this.todayMax = todayMax;
	}
	public void setTodayMin(BigDecimal todayMin) {
		this.todayMin = todayMin;
	}
	public void setCompetBuyPrice(BigDecimal competBuyPrice) {
		this.competBuyPrice = competBuyPrice;
	}
	public void setCompetSellPrice(BigDecimal competSellPrice) {
		this.competSellPrice = competSellPrice;
	}
	public void setTradeNum(BigDecimal tradeNum) {
		this.tradeNum = tradeNum;
	}
	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public void setBuy1Num(BigDecimal buy1Num) {
		this.buy1Num = buy1Num;
	}
	public void setBuy1Price(BigDecimal buy1Price) {
		this.buy1Price = buy1Price;
	}
	public void setBuy2Num(BigDecimal buy2Num) {
		this.buy2Num = buy2Num;
	}
	public void setBuy2Price(BigDecimal buy2Price) {
		this.buy2Price = buy2Price;
	}
	public void setBuy3Num(BigDecimal buy3Num) {
		this.buy3Num = buy3Num;
	}
	public void setBuy3Price(BigDecimal buy3Price) {
		this.buy3Price = buy3Price;
	}
	public void setBuy4Num(BigDecimal buy4Num) {
		this.buy4Num = buy4Num;
	}
	public void setBuy4Price(BigDecimal buy4Price) {
		this.buy4Price = buy4Price;
	}
	public void setBuy5Num(BigDecimal buy5Num) {
		this.buy5Num = buy5Num;
	}
	public void setBuy5Price(BigDecimal buy5Price) {
		this.buy5Price = buy5Price;
	}
	public void setSell1Num(BigDecimal sell1Num) {
		this.sell1Num = sell1Num;
	}
	public void setSell1Price(BigDecimal sell1Price) {
		this.sell1Price = sell1Price;
	}
	public void setSell2Num(BigDecimal sell2Num) {
		this.sell2Num = sell2Num;
	}
	public void setSell2Price(BigDecimal sell2Price) {
		this.sell2Price = sell2Price;
	}
	public void setSell3Num(BigDecimal sell3Num) {
		this.sell3Num = sell3Num;
	}
	public void setSell3Price(BigDecimal sell3Price) {
		this.sell3Price = sell3Price;
	}
	public void setSell4Num(BigDecimal sell4Num) {
		this.sell4Num = sell4Num;
	}
	public void setSell4Price(BigDecimal sell4Price) {
		this.sell4Price = sell4Price;
	}
	public void setSell5Num(BigDecimal sell5Num) {
		this.sell5Num = sell5Num;
	}
	public void setSell5Price(BigDecimal sell5Price) {
		this.sell5Price = sell5Price;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	
}
