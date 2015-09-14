package com.chinesedreamer.stocks.business.sync.service;

import com.chinesedreamer.stocks.business.sync.exception.SyncException;

/**
 * 同步股票信息的接口
 * @author Paris
 *
 */
public interface StockSyncService {
	/**
	 * 同步关注的股票信息
	 * @param userId
	 * @throws SyncException
	 */
	public void syncFocus(Long userId) throws Exception;
}
