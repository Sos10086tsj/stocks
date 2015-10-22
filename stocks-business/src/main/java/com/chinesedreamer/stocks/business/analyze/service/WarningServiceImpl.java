package com.chinesedreamer.stocks.business.analyze.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.analyze.constant.WarningConstant;
import com.chinesedreamer.stocks.business.tools.message.mail.config.EmailRecipient;
import com.chinesedreamer.stocks.business.tools.message.mail.service.EmailSender;
import com.chinesedreamer.stocks.domain.line.model.KDJ;
import com.chinesedreamer.stocks.domain.stock.model.Stock;
import com.chinesedreamer.stocks.domain.stock.repository.StockRepository;

@Service
public class WarningServiceImpl implements WarningService{
	private Logger logger = LoggerFactory.getLogger(WarningServiceImpl.class);
	
	@Resource
	private EmailSender emailSender;
	
	@Resource
	private StockRepository stockRepository;

	@Override
	public void kdjWarning(KDJ kdj) {
		if (kdj.getK().floatValue() >= WarningConstant.KDJ_WARNING_K_UPPER_LIMIT 
				|| kdj.getD().floatValue() >= WarningConstant.KDJ_WARNING_D_UPPER_LIMIT) {
			logger.info("stock:{} dkj warning. k:{}, d:{}, j:{}",kdj.getStockCode(),kdj.getK(),kdj.getD(),kdj.getJ());
			
			Stock stock = this.stockRepository.findByCode(kdj.getStockCode());
			String stockName = "";
			if (null != stock) {
				stockName = stock.getName();
			}
			String[] to = new String[]{"paristao1989@163.com}"};
			String[] cc = new String[]{"paristao1989@163.com}"};
			String[] bcc = new String[]{"paristao1989@163.com}"};
			EmailRecipient recipient = new EmailRecipient(to, cc, bcc);
			emailSender.sendEmail("Stock系统", recipient, "股票KDJ提醒", 
					stockName + "(" + kdj.getStockCode() + ")达到KDJ预警条件。K:" + kdj.getK() + "	d:" + kdj.getK() + "	j:" + kdj.getJ());
		}
	}

}