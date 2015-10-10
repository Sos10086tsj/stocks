package com.chinesedreamer.stocks.business.analyze.service;

import java.util.Date;

import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;

public interface StockFormulaSevice {
	/**
	 * 生成指定的kdj
	 * @param stockCode	股票代码
	 * @param type	类型：日线、周线、月线、季度线、年线
	 * @param date	日期
	 * @return
	 */
	public KDJ generateKdj(String stockCode,KDJType type, Date date);
}
