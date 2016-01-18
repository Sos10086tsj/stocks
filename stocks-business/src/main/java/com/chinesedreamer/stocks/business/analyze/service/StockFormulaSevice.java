package com.chinesedreamer.stocks.business.analyze.service;

import java.util.Date;

import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;
import com.chinesedreamer.stocks.domain.line.model.MA;

public interface StockFormulaSevice {
	/**
	 * 生成KDJ指标
	 * @param stockCode	股票代码
	 * @param type	类型：日线、周线、月线、季度线、年线
	 * @param date	日期
	 * @return
	 */
	public KDJ generateKdj(String stockCode,KDJType type, Date date);
	
	/**
	 * 生成MA均线指标
	 * @param stockCode
	 * @param date
	 * @return
	 */
	public MA generateMa(String stockCode,Date date);
}
