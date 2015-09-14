package com.chinesedreamer.stocks.business.sync.service;

/**
 * 股票远程获取服务
 * @author Paris
 *
 */
public interface StockApiService {
	/**
	 * 获取远程调用结果
	 * @param stocks
	 * @return
	 */
	public String getApiResult(String stocks)  throws Exception;
}
