package com.chinesedreamer.stocks.domain.line.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "line_ma")
public class MA extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8471467997022842611L;
	
	@Column(name = "stock_code")
	private String stockCode;
	
	@Column(name = "date")
	private Integer date;
	
	@Column(name = "ma")
	private BigDecimal ma;//默认9日均线
	
	@Column(name = "ma_5")
	private BigDecimal ma5;
	
	@Column(name = "ma_10")
	private BigDecimal ma10;
	
	@Column(name = "ma_20")
	private BigDecimal ma20;
	
	@Column(name = "ma_30")
	private BigDecimal ma30;
	
	@Column(name = "ma_60")
	private BigDecimal ma60;
	
	public BigDecimal getMa() {
		return ma;
	}
	public BigDecimal getMa5() {
		return ma5;
	}
	public BigDecimal getMa10() {
		return ma10;
	}
	public BigDecimal getMa20() {
		return ma20;
	}
	public BigDecimal getMa30() {
		return ma30;
	}
	public BigDecimal getMa60() {
		return ma60;
	}
	public void setMa(BigDecimal ma) {
		this.ma = ma;
	}
	public void setMa5(BigDecimal ma5) {
		this.ma5 = ma5;
	}
	public void setMa10(BigDecimal ma10) {
		this.ma10 = ma10;
	}
	public void setMa20(BigDecimal ma20) {
		this.ma20 = ma20;
	}
	public void setMa30(BigDecimal ma30) {
		this.ma30 = ma30;
	}
	public void setMa60(BigDecimal ma60) {
		this.ma60 = ma60;
	}
	public String getStockCode() {
		return stockCode;
	}
	public Integer getDate() {
		return date;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MA [stockCode=" + stockCode + ", date=" + date + ", ma=" + ma + ", ma5=" + ma5 + ", ma10=" + ma10
				+ ", ma20=" + ma20 + ", ma30=" + ma30 + ", ma60=" + ma60 + "]";
	}
	
	
}
