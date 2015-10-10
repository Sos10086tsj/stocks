package com.chinesedreamer.stocks.business.analyze.service;

import com.chinesedreamer.stocks.domain.line.model.KDJ;

public interface WarningService {
	/**
	 * kdj提醒
	 * @param kdj
	 */
	public void kdjWarning(KDJ kdj);
}
