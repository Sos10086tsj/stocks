package com.chinesedreamer.stocks.business.analyze.service;

import com.chinesedreamer.stocks.domain.line.model.KDJ;
import com.chinesedreamer.stocks.domain.line.model.MA;

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
}
