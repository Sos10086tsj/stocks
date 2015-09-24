package com.chinesedreamer.stocks.business.api.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.chinesedreamer.stocks.business.api.service.ApiService;
import com.chinesedreamer.stocks.common.util.DateUtil;
import com.chinesedreamer.stocks.common.util.EncryptionUtil;
import com.chinesedreamer.stocks.common.util.HttpClientUtil;
import com.chinesedreamer.stocks.domain.sysconfig.constant.SysconfigConstant;
import com.chinesedreamer.stocks.domain.sysconfig.repository.SysConfigRepository;

@Service("stockApiServiceShowApi")
public class ApiServiceShowApiImpl implements ApiService{
	private Logger logger = LoggerFactory.getLogger(ApiServiceShowApiImpl.class);
	
	@Resource
	private SysConfigRepository sysConfigRepository;
	

	@Override
	public String getStocksApiResult(String stocks) throws Exception{
		String url = this.generateStocksShowApiUrl(stocks);
		return HttpClientUtil.sendPost(url, "utf-8");
	}

	/**
	 * 股票查询url封装器
	 * @param stocks
	 * @return
	 */
	private String generateStocksShowApiUrl(String stocks) {
		String baseUrl = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_STOCKS_BASE_URL).getPropertyValue();
		String showapiId = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_ID).getPropertyValue();
		String showApiTimestamp = DateUtil.getFormatTime("yyyyMMddHHmmss");
		String needIndex = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_STOCKS_NEED_INDEX).getPropertyValue();
		String sign = "needIndex" +needIndex.toLowerCase() 
					+ "showapi_appid" + showapiId.toLowerCase() 
					+ "showapi_timestamp" + showApiTimestamp.toLowerCase() 
					+ "stocks" + stocks.toLowerCase()
					+ sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_SIGN).getPropertyValue();
		String showapiSign = EncryptionUtil.md5L32(sign);
		String url = baseUrl + "?" 
				+ "showapi_appid=" + showapiId 
				+ "&showapi_timestamp=" + showApiTimestamp
				+ "&stocks=" + stocks
				+ "&needIndex=" + needIndex
				+ "&showapi_sign=" + showapiSign;
		logger.info("showapi access url:{}", url);
		return url;
	}

	@Override
	public String getMarketIndexApiResult() throws Exception {
		String url = this.generateMarketIndexShowApiUrl();
		return HttpClientUtil.sendPost(url, "utf-8");
	}
	
	/**
	 * 市场指数查询url封装器
	 * @return
	 */
	private String generateMarketIndexShowApiUrl() {
		String baseUrl = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_MARKET_INDEX_BASE_URL).getPropertyValue();
		String showapiId = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_ID).getPropertyValue();
		String showApiTimestamp = DateUtil.getFormatTime("yyyyMMddHHmmss");
		String sign = "showapi_appid" + showapiId.toLowerCase() 
					+ "showapi_timestamp" + showApiTimestamp.toLowerCase()
					+ sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_SIGN).getPropertyValue();
		String showapiSign = EncryptionUtil.md5L32(sign);
		String url = baseUrl + "?" 
				+ "showapi_appid=" + showapiId 
				+ "&showapi_timestamp=" + showApiTimestamp
				+ "&showapi_sign=" + showapiSign;
		logger.info("showapi access url:{}", url);
		return url;
	}

	@Override
	public String getStockApiResult(String code, String name) throws Exception {
		String url = this.generateStockShowApiUrl(code,name);
		return HttpClientUtil.sendPost(url, "utf-8");
	}
	
	/**
	 * 股票基本信息查询url封装期
	 * @param code
	 * @param name
	 * @return
	 */
	private String generateStockShowApiUrl(String code, String name) {
		String baseUrl = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_STOCK_BASE_URL).getPropertyValue();
		String showapiId = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_ID).getPropertyValue();
		String showApiTimestamp = DateUtil.getFormatTime("yyyyMMddHHmmss");
		StringBuffer sign = new StringBuffer();
		StringBuffer paramBuffer = new StringBuffer();
		if (!StringUtils.isEmpty(code)) {
			sign.append("code")
			.append(code.toLowerCase());
			paramBuffer.append("&code=")
			.append(code);
		}
		if (!StringUtils.isEmpty(name)) {
			sign.append("name")
			.append(name.toLowerCase());
			paramBuffer.append("&name=")
			.append(name);
		}
		sign.append("showapi_appid")
		.append(showapiId.toLowerCase())
		.append("showapi_timestamp")
		.append(showApiTimestamp.toLowerCase())
		.append(sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_SIGN).getPropertyValue());
		String showapiSign = EncryptionUtil.md5L32(sign.toString());
		
		String url = baseUrl + "?" 
				+ "showapi_appid=" + showapiId 
				+ "&showapi_timestamp=" + showApiTimestamp
				+ "&showapi_sign=" + showapiSign
				+ paramBuffer.toString();
		logger.info("showapi access url:{}", url);
		return url;
	}
}
