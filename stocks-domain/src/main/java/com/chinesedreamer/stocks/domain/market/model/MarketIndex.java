package com.chinesedreamer.stocks.domain.market.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/** 
 * Description: 股票指数
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年9月12日 下午1:20:04 
 * Copyright:   Copyright (c)2015
 */
@Entity
@Table(name = "market_index")
public @Getter @Setter class MarketIndex extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9026195079275303820L;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;						//日期
	@Column(name = "market_code")
	private String marketCode;				//市场		sz		@link com.chinesedreamer.stocks.domain.market.model.Market.code
	@Column
	private String code;					//指数编码		sh000001
	@Column
	private String name;					//指数名称		上证指数
	@Column(name = "today_open_price")
	private BigDecimal todayOpenPrice;		//今日开盘价	5101.44
	@Column(name = "yestoday_close_price")
	private BigDecimal yestodayClosePrice;	//昨日收盘价	5106.036
	@Column(name = "now_price")
	private BigDecimal nowPrice;			//当前价		5121.593
	@Column(name = "max_price")
	private BigDecimal maxPrice;			//最高价		5122.457
	@Column(name = "min_price")
	private BigDecimal minPrice;			//最低价		5050.765
	@Column(name = "trade_num")
	private BigDecimal tradeNum;			//成交量		563990522.0
	@Column(name = "trade_amount")
	private BigDecimal tradeAmount;			//成交金额		974670611914.0
}
