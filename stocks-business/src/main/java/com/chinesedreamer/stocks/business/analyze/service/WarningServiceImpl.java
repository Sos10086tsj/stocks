package com.chinesedreamer.stocks.business.analyze.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.analyze.constant.WarningConstant;
import com.chinesedreamer.stocks.domain.line.model.KDJ;

@Service
public class WarningServiceImpl implements WarningService{
	private Logger logger = LoggerFactory.getLogger(WarningServiceImpl.class);
	
	@Resource
	private 

	@Override
	public void kdjWarning(KDJ kdj) {
		if (kdj.getK().floatValue() >= WarningConstant.KDJ_WARNING_K_UPPER_LIMIT 
				|| kdj.getD().floatValue() >= WarningConstant.KDJ_WARNING_D_UPPER_LIMIT) {
			logger.info("stock:{} dkj warning. k:{}, d:{}, j:{}",kdj.getStockCode(),kdj.getK(),kdj.getD(),kdj.getJ());
		}
	}

}
