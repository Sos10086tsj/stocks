package com.chinesedreamer.stocks.business.api.service;

/**
 * 股票远程获取服务
 * @author Paris
 *
 */
public interface ApiService {
	/**
	 * api获取股票指数信息
	 * 若在开盘
	 * @param stocks
	 * @return
	 */
	public String getStocksApiResult(String stocks)  throws Exception;
	
	/**
	 * 获取版块指数
	 * @return
	 * @throws Exception
	 */
	public String getMarketIndexApiResult() throws Exception;
	
	/**
	 * api获取股票基本信息
	 * @param code
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getStockApiResult(String code, String name) throws Exception;
}
