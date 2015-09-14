package com.chinesedreamer.stocks.business.sync.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.sync.service.StockApiService;
import com.chinesedreamer.stocks.common.util.EncryptionUtil;
import com.chinesedreamer.stocks.common.util.HttpClientUtil;
import com.chinesedreamer.stocks.domain.sysconfig.constant.SysconfigConstant;
import com.chinesedreamer.stocks.domain.sysconfig.repository.SysConfigRepository;

@Service("stockApiServiceShowApi")
public class StockApiServiceShowApiImpl implements StockApiService{
	private Logger logger = LoggerFactory.getLogger(StockApiServiceShowApiImpl.class);
	
	@Resource
	private SysConfigRepository sysConfigRepository;
	

	@Override
	public String getApiResult(String stocks) throws Exception{
		String url = this.generateShowApiUrl(stocks);
		return HttpClientUtil.sendPost(url, "uttf-8");
	}

	private String generateShowApiUrl(String stocks) {
		String baseUrl = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_BASE_URL).getPropertyValue();
		String showapiId = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_ID).getPropertyValue();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String showApiTimestamp = format.format(date);
		String needIndex = sysConfigRepository.findByProperty(SysconfigConstant.PROPERTY_SHOW_API_NEED_INDEX).getPropertyValue();
		String sign = needIndex.toLowerCase() + showapiId.toLowerCase() + showApiTimestamp.toLowerCase() + stocks.toLowerCase();
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
}
