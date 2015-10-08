package com.chinesedreamer.stocks.business.analyze.service;

import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;

public interface StockFormulaSevice {
	/**
	 * 生成指定的kdj
	 * 日线、周线、月线、季度线、年线
	 * @param type
	 * @return
	 */
	public KDJ generateKdj(KDJType type);
	
	/**
	 * 生成指定的实时kdj
	 * 分钟线
	 * @param type
	 * @return
	 */
	public KDJ generateRealTimeKdj(KDJType type);
}
