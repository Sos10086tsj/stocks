package com.chinesedreamer.stocks.domain.stock.model;

import java.math.BigDecimal;
import java.util.Date;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/** 
 * Description: 股票行情
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午6:47:20 
 * Copyright:   Copyright (c)2015
 */
public @Getter @Setter class StockIndex extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -989477347242698561L;

	//基本信息
	private Date date;					//日期
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
}
