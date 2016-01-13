package com.chinesedreamer.stocks.business.analyze.vo;

import java.math.BigDecimal;

/**
 * n日RSV=（Cn－Ln）/（Hn－Ln）×100
 * 或者n日内的Ln,Hn
 * @author Paris
 *
 */
public class KdjC {
	private BigDecimal ln;
	private BigDecimal hn;
	public BigDecimal getLn() {
		return ln;
	}
	public BigDecimal getHn() {
		return hn;
	}
	public void setLn(BigDecimal ln) {
		this.ln = ln;
	}
	public void setHn(BigDecimal hn) {
		this.hn = hn;
	}
	
	
}
