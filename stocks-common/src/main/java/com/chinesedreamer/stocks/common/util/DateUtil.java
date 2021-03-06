package com.chinesedreamer.stocks.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateUtil {
	public static int getTodayIntValue(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		
		String ymd = "" + year + (month > 9 ? month : "0" + month) + (day > 9 ? day : "0" + day);
		return Integer.valueOf(ymd);
	}
	
	public static String getFormatTime(String formatStr) {
		Date date = new Date();
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = "yyyyMMddHHmmss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(date);
	}
	
	public static String getFormatTime(String formatStr,Date date) {
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = "yyyyMMddHHmmss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(date);
	}
	
	/**
	 * 日期格式转整型
	 * @param date 
	 * @param interval(day of month)
	 * @return 20150101
	 */
	public static Integer date2Int(Date date, Integer interval, String format) {
		if (StringUtils.isEmpty(format)) {
			format = "yyyyMMdd";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (null != interval && interval != 0) {
			calendar.add(Calendar.DAY_OF_MONTH, interval);
		}
		return Integer.valueOf(DateUtil.getFormatTime(format,calendar.getTime()));
	}
}
