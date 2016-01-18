package com.chinesedreamer.stocks.business.analyze.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chinesedreamer.stocks.business.analyze.constant.StockFormulaConstant;
import com.chinesedreamer.stocks.business.analyze.vo.KdjC;
import com.chinesedreamer.stocks.common.util.DateUtil;
import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;
import com.chinesedreamer.stocks.domain.line.model.MA;
import com.chinesedreamer.stocks.domain.line.model.MACD;
import com.chinesedreamer.stocks.domain.line.repository.KDJRepository;
import com.chinesedreamer.stocks.domain.line.repository.MACDRepository;
import com.chinesedreamer.stocks.domain.line.repository.MARepository;
import com.chinesedreamer.stocks.domain.stock.model.StockIndex;
import com.chinesedreamer.stocks.domain.stock.repository.StockIndexRepository;

@Service
public class StockFormulaServiceImpl implements StockFormulaSevice{
	
	@Resource
	private StockIndexRepository stockIndexRepository;
	@Resource
	private MARepository mARepository;
	@Resource
	private MACDRepository mACDRepository;
	@Resource
	private KDJRepository repostory;
	@Resource
	private WarningService warningService;

	@Override
	public KDJ generateKdj(String stockCode,KDJType type, Date date) {
		//1. 获取股票当日指数信息
		StockIndex si = this.stockIndexRepository.findByDateAndStockCode(Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",date)), stockCode);
		//2. 获取rsv
		Integer dateInt = DateUtil.date2Int(date, 0, null);
		Integer yesterdayDateInt = DateUtil.date2Int(date, -1, null);
		
		KdjC kdjC = this.getKdjC(stockCode, dateInt, StockFormulaConstant.KDJ.DEFAULT_YESTERDAY_SCOPE);
		BigDecimal rsv = (si.getClosePrice().subtract(kdjC.getLn()))
				.multiply(new BigDecimal(100))
				.divide((kdjC.getHn()
						.subtract(kdjC.getLn())),StockFormulaConstant.KDJ.KDJ_CALCULATE_SCALE);
		//3. 获取前一日kdj
		
		KDJ yesterdayKdj = this.repostory.findByDateAndTypeAndStockCode(yesterdayDateInt, type, stockCode);
		BigDecimal yesterdayK = new BigDecimal(50);
		BigDecimal yesterdayD = new BigDecimal(50);
		if (null != yesterdayKdj) {
			yesterdayK = yesterdayKdj.getK();
			yesterdayD = yesterdayKdj.getD();
		}
		
		BigDecimal zero = new BigDecimal("0");
		BigDecimal rate_2 = new BigDecimal("2");
		BigDecimal rate_3 = new BigDecimal("3");
		BigDecimal k = yesterdayK.multiply(rate_2).divide(rate_3, StockFormulaConstant.KDJ.KDJ_CALCULATE_SCALE)
				.add(rsv.divide(rate_3, StockFormulaConstant.KDJ.KDJ_CALCULATE_SCALE))
				.setScale(StockFormulaConstant.KDJ.KDJ_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		k = (k.compareTo(zero) <= 0) ? zero : k;
		BigDecimal d = yesterdayD.multiply(rate_2).divide(rate_3, StockFormulaConstant.KDJ.KDJ_CALCULATE_SCALE)
				.add(k.divide(rate_3, StockFormulaConstant.KDJ.KDJ_CALCULATE_SCALE))
				.setScale(StockFormulaConstant.KDJ.KDJ_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		d = (d.compareTo(zero) <= 0) ? zero : d;
		BigDecimal j = k.multiply(rate_3).subtract(d.multiply(rate_2))
				.setScale(StockFormulaConstant.KDJ.KDJ_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		j = (j.compareTo(zero) <= 0) ? zero : j;
		KDJ kdj = this.repostory.findByDateAndTypeAndStockCode(Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",date)), type, stockCode);
		if (null == kdj) {
			kdj = new KDJ();
		}
		kdj.setD(d);
		kdj.setDate(Integer.valueOf(DateUtil.getFormatTime("yyyyMMdd",date)));
		kdj.setJ(j);
		kdj.setK(k);
		kdj.setRsv(rsv);
		kdj.setStockCode(stockCode);
		kdj.setType(type);
		//4. 交由提醒task处理kdj
		this.warningService.kdjWarning(kdj);
		return this.repostory.save(kdj);
	}

	/**
	 * 获取前一日K值
	 * @param stockCode
	 * @param type
	 * @param date
	 * @return
	 */
	private KdjC getKdjC(String stockCode,Integer date, Integer  yesterdayScop){
		List<StockIndex> stockIndexs = this.stockIndexRepository.findByDateLessThanEqualAndStockCodeOrderByDateDesc(date, stockCode, new PageRequest(0, yesterdayScop));
		
		KdjC kdjC = new KdjC();
		BigDecimal ln = null;
		BigDecimal hn = null;
		for (StockIndex si : stockIndexs) {
			if (null == ln) {
				ln = si.getTodayMin();
			}
			if (null == hn) {
				hn = si.getTodayMax();
			}
			if (si.getTodayMin().compareTo(ln) == -1) {
				ln = si.getTodayMin();
			}
			if (si.getTodayMax().compareTo(hn) == 1) {
				hn = si.getTodayMax();
			}
		}
		kdjC.setHn(hn);
		kdjC.setLn(ln);
		return kdjC;
	}

	@Override
	public MA generateMa(String stockCode, Date date) {
		Integer dateInt = DateUtil.date2Int(date, 0, null);
		List<StockIndex> stockIndexs = this.stockIndexRepository.findByDateLessThanEqualAndStockCodeOrderByDateDesc(
				dateInt, stockCode, new PageRequest(0, StockFormulaConstant.MA.DAY_SCOPE_60));
		
		BigDecimal zero = new BigDecimal(0);
		BigDecimal maDefault = zero;
		BigDecimal ma5 = zero;
		BigDecimal ma10 = zero;
		BigDecimal ma20 = zero;
		BigDecimal ma30 = zero;
		BigDecimal ma60 = zero;
		
		for (int i = 0; i < stockIndexs.size(); i++) {
			StockIndex si = stockIndexs.get(i);
			if (i < StockFormulaConstant.MA.DAY_SCOPE_DEFAULT) {
				maDefault = maDefault.add(si.getClosePrice());
			}
			if (i < StockFormulaConstant.MA.DAY_SCOPE_5) {
				ma5 = ma5.add(si.getClosePrice());
			}
			if (i < StockFormulaConstant.MA.DAY_SCOPE_10) {
				ma10 = ma10.add(si.getClosePrice());
			}
			if (i < StockFormulaConstant.MA.DAY_SCOPE_20) {
				ma20 = ma20.add(si.getClosePrice());
			}
			if (i < StockFormulaConstant.MA.DAY_SCOPE_30) {
				ma30 = ma30.add(si.getClosePrice());
			}
			if (i < StockFormulaConstant.MA.DAY_SCOPE_60) {
				ma60 = ma60.add(si.getClosePrice());
			}
		}
		
		//MA计算
		maDefault = maDefault.divide(new BigDecimal(StockFormulaConstant.MA.DAY_SCOPE_DEFAULT), StockFormulaConstant.MA.MA_CALCULATE_SCALE)
				.setScale(StockFormulaConstant.MA.MA_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		ma5 = ma5.divide(new BigDecimal(StockFormulaConstant.MA.DAY_SCOPE_5), StockFormulaConstant.MA.MA_CALCULATE_SCALE)
				.setScale(StockFormulaConstant.MA.MA_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		ma10 = ma10.divide(new BigDecimal(StockFormulaConstant.MA.DAY_SCOPE_10), StockFormulaConstant.MA.MA_CALCULATE_SCALE)
				.setScale(StockFormulaConstant.MA.MA_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		ma20 = ma20.divide(new BigDecimal(StockFormulaConstant.MA.DAY_SCOPE_20), StockFormulaConstant.MA.MA_CALCULATE_SCALE)
				.setScale(StockFormulaConstant.MA.MA_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		ma30 = ma30.divide(new BigDecimal(StockFormulaConstant.MA.DAY_SCOPE_30), StockFormulaConstant.MA.MA_CALCULATE_SCALE)
				.setScale(StockFormulaConstant.MA.MA_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		ma60 = ma60.divide(new BigDecimal(StockFormulaConstant.MA.DAY_SCOPE_60), StockFormulaConstant.MA.MA_CALCULATE_SCALE)
				.setScale(StockFormulaConstant.MA.MA_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		
		MA ma = this.mARepository.findByStockCodeAndDate(stockCode, dateInt);
		if (null == ma) {
			ma = new MA();
			ma.setDate(dateInt);
			ma.setStockCode(stockCode);
		}
		ma.setMa(maDefault);
		ma.setMa5(ma5);
		ma.setMa10(ma10);
		ma.setMa20(ma20);
		ma.setMa30(ma30);
		ma.setMa60(ma60);
		
		ma = this.mARepository.save(ma);
		
		this.warningService.maWarning(ma);
		
		return ma;
	}

	@Override
	public MACD generateMacd(String stockCode, Date date) {
		Integer dateInt = DateUtil.date2Int(date, 0, null);

		StockIndex si = this.stockIndexRepository.findByDateAndStockCode(dateInt, stockCode);
		
		Integer yesterdayDateInt = DateUtil.date2Int(date, -1, null);
		MACD yesterdayMacd = this.mACDRepository.findByStockCodeAndDate(stockCode, yesterdayDateInt);
		if (null == yesterdayMacd) {
			yesterdayMacd = this.generateYesterDayMacd(stockCode, date);
		}
		
		MACD macd = this.mACDRepository.findByStockCodeAndDate(stockCode, dateInt);
		if (null == macd) {
			macd = new MACD();
			macd.setDate(dateInt);
			macd.setStockCode(stockCode);
		}
		
		BigDecimal ema12 = yesterdayMacd.getEma12().multiply(new BigDecimal(11 / 12))
				.add(si.getClosePrice().multiply(new BigDecimal(2 / 13)))
				.setScale(StockFormulaConstant.MACD.MACD_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		BigDecimal ema26 = yesterdayMacd.getEma26().multiply(new BigDecimal(23/27))
				.add(si.getClosePrice().multiply(new BigDecimal(2 / 27)))
				.setScale(StockFormulaConstant.MACD.MACD_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);

		BigDecimal diff = ema12.subtract(ema26);
		
		BigDecimal dea = yesterdayMacd.getDea().multiply(new BigDecimal(8/10))
				.add(diff.multiply(new BigDecimal(2 / 10)))
				.setScale(StockFormulaConstant.MACD.MACD_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
		
		macd.setEma12(ema12);
		macd.setEma26(ema26);
		macd.setDiff(diff);
		macd.setDea(dea);
		macd = this.mACDRepository.save(macd);
		
		this.warningService.macdWarning(macd);
		
		return macd;
	}
	
	
	/**
	 * 模拟计算 EMA
	 * @param stockCode
	 * @param date
	 * @return
	 */
	private MACD generateYesterDayMacd(String stockCode,Date date) {
		Integer dateInt = DateUtil.date2Int(date, -1, null);
		List<StockIndex> stockIndexs = this.stockIndexRepository.findByDateLessThanEqualAndStockCodeOrderByDateDesc(
				dateInt, stockCode, new PageRequest(0, StockFormulaConstant.MACD.DAY_SCOPE_26));
		
		MACD macd = new MACD();
		
		macd.setEma12(this.calculateEma(stockIndexs, StockFormulaConstant.MACD.DAY_SCOPE_12));
		macd.setEma26(this.calculateEma(stockIndexs, StockFormulaConstant.MACD.DAY_SCOPE_26));
		//TODO 
		macd.setDea(dea);
		
		return macd;
	}
	
	/**
	 * 计算EMA
	 * @param stockIndexs
	 * @param dayScope
	 * @return
	 */
	private BigDecimal calculateEma(List<StockIndex> stockIndexs, Integer dayScope) {
		BigDecimal ALPHA = null;
		if (dayScope.equals(StockFormulaConstant.MACD.DAY_SCOPE_12)) {
			ALPHA = StockFormulaConstant.MACD.ALPHA_12;
		}else if (dayScope.equals(StockFormulaConstant.MACD.DAY_SCOPE_26)) {
			ALPHA = StockFormulaConstant.MACD.ALPHA_26;
		}
		
		BigDecimal zero = new BigDecimal(0);
		BigDecimal divisor = zero;
		BigDecimal dividend = zero;
		
		BigDecimal one = new BigDecimal(1);
		
		for (int i = 0; i < dayScope; i++) {
			StockIndex si = stockIndexs.get(i);
			BigDecimal price = si.getClosePrice();
			
			BigDecimal pow = (one.subtract(ALPHA)).pow(i);
			
			divisor = divisor.add(price.multiply(pow));
			dividend = dividend.add(pow);
		}
		
		//防止被除数为0
		if (dividend.compareTo(zero) == 0) {
			dividend = one;
		}
		
		return divisor.divide(dividend, StockFormulaConstant.MACD.MACD_CALCULATE_SCALE)
				.setScale(StockFormulaConstant.MACD.MACD_RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
	}
}
