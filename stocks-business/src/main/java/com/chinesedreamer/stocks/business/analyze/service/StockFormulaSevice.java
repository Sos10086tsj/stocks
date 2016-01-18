package com.chinesedreamer.stocks.business.analyze.service;

import java.util.Date;

import com.chinesedreamer.stocks.domain.line.constant.KDJType;
import com.chinesedreamer.stocks.domain.line.model.KDJ;
import com.chinesedreamer.stocks.domain.line.model.MA;
import com.chinesedreamer.stocks.domain.line.model.MACD;

public interface StockFormulaSevice {
	/**
	 * 生成KDJ指标
	 * 
	 * KDJ的计算比较复杂，首先要计算周期（n日、n周等）的RSV值，即未成熟随机指标值，然后再计算K值、D值、J值等。以n日KDJ数值的计算为例，其计算公式为
	 * n日RSV=（Cn－Ln）/（Hn－Ln）×100
	 * 公式中，Cn为第n日收盘价；Ln为n日内的最低价；Hn为n日内的最高价。
	 * 其次，计算K值与D值：
	 * 当日K值=2/3×前一日K值+1/3×当日RSV
	 * 当日D值=2/3×前一日D值+1/3×当日K值
	 * 若无前一日K 值与D值，则可分别用50来代替。
	 * J值=3*当日K值-2*当日D值
	 * 以9日为周期的KD线为例，即未成熟随机值，计算公式为
	 * 9日RSV=（C－L9）÷（H9－L9）×100
	 * 公式中，C为第9日的收盘价；L9为9日内的最低价；H9为9日内的最高价。
	 * K值=2/3×第8日K值+1/3×第9日RSV
	 * D值=2/3×第8日D值+1/3×第9日K值
	 * J值=3*第9日K值-2*第9日D值
	 * 若无前一日K值与D值，则可以分别用50代替。
	 * @param stockCode	股票代码
	 * @param type	类型：日线、周线、月线、季度线、年线
	 * @param date	日期
	 * @return
	 */
	public KDJ generateKdj(String stockCode,KDJType type, Date date);
	
	/**
	 * 生成MA均线指标
	 * 
	 * N日MA=N日收市价的总和/N(即算术平均数)
	 * 要设置多条移动平均线，一般参数设置为N1=5,N2=10,N3=20,N4=60,N5=120,N6=250
	 * @param stockCode
	 * @param date
	 * @return
	 */
	public MA generateMa(String stockCode,Date date);
	
	/**
	 * 指数平滑移动平均线
	 * 
	 * 12日EMA的计算：EMA12 = 前一日EMA12 X 11/13 + 今日收盘 X 2/13
	 * 26日EMA的计算：EMA26 = 前一日EMA26 X 25/27 + 今日收盘 X 2/27
	 * 差离值（DIF）的计算： DIF = EMA12 - EMA26 。
	 * 根据差离值计算其9日的EMA，即离差平均值，是所求的DEA值。为了不与指标原名相混淆，此值又名DEA或DEM。
	   * 　　今日DEA = （前一日DEA X 8/10 + 今日DIF X 2/10）
	 * 用（DIF-DEA）*2即为MACD柱状图。
	 * 
	 * EMAtoday=α * ( Pricetoday - EMAyesterday ) + EMAyesterday;
	 * 
	 * @param stockCode
	 * @param date
	 * @return
	 */
	public MACD generateMacd(String stockCode,Date date);
}
