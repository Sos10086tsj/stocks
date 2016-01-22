package com.chinesedreamer.stocks.domain.line.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinesedreamer.stocks.domain.base.jpa.BaseEntity;

@Entity
@Table(name = "lien_macd")
public class MACD extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4526042075997270268L;
	
	@Column(name = "stock_code")
	private String stockCode;
	
	@Column(name = "date")
	private Integer date;

	@Column(name = "ema_12")
	private BigDecimal ema12;
	
	@Column(name = "ema_26")
	private BigDecimal ema26;
	
	@Column
	private BigDecimal diff;
	
	@Column
	private BigDecimal dea;
	
	@Column
	private BigDecimal macd;

	public String getStockCode() {
		return stockCode;
	}

	public Integer getDate() {
		return date;
	}

	public BigDecimal getEma12() {
		return ema12;
	}

	public BigDecimal getEma26() {
		return ema26;
	}

	public BigDecimal getDiff() {
		return diff;
	}

	public BigDecimal getDea() {
		return dea;
	}

	public BigDecimal getMacd() {
		return macd;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public void setEma12(BigDecimal ema12) {
		this.ema12 = ema12;
	}

	public void setEma26(BigDecimal ema26) {
		this.ema26 = ema26;
	}

	public void setDiff(BigDecimal diff) {
		this.diff = diff;
	}

	public void setDea(BigDecimal dea) {
		this.dea = dea;
	}

	public void setMacd(BigDecimal macd) {
		this.macd = macd;
	}

	@Override
	public String toString() {
		return "MACD [stockCode=" + stockCode + ", date=" + date + ", ema12=" + ema12 + ", ema26=" + ema26 + ", diff="
				+ diff + ", dea=" + dea + ", macd=" + macd + "]";
	}

	
}
