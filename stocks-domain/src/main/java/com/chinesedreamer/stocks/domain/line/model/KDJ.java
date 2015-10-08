package com.chinesedreamer.stocks.domain.line.model;

import java.math.BigDecimal;

import com.chinesedreamer.stocks.domain.line.constant.KDJType;

/**
 * kdj类，日以上可以保存到数据库。分钟线实时计算
 * @author Paris
 *
 */
public class KDJ {
	private BigDecimal k;
	private BigDecimal d;
	private BigDecimal j;
	
	private Integer date;
	private KDJType type;
	
	public BigDecimal getK() {
		return k;
	}
	public BigDecimal getD() {
		return d;
	}
	public BigDecimal getJ() {
		return j;
	}
	public void setK(BigDecimal k) {
		this.k = k;
	}
	public void setD(BigDecimal d) {
		this.d = d;
	}
	public void setJ(BigDecimal j) {
		this.j = j;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public KDJType getType() {
		return type;
	}
	public void setType(KDJType type) {
		this.type = type;
	}
	
	
}
