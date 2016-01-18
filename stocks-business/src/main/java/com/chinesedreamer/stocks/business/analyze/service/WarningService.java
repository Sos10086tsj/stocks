package com.chinesedreamer.stocks.business.analyze.service;

import com.chinesedreamer.stocks.domain.line.model.KDJ;
import com.chinesedreamer.stocks.domain.line.model.MA;
import com.chinesedreamer.stocks.domain.line.model.MACD;

public interface WarningService {
	/**
	 * kdj提醒
	 * @param kdj
	 */
	public void kdjWarning(KDJ kdj);
	
	/**
	 * ma均线提醒
	 * @param ma
	 */
	public void maWarning(MA ma);
	
	/**
	 * macd提醒
	 * @param macd
	 */
	public void macdWarning(MACD macd);
}
