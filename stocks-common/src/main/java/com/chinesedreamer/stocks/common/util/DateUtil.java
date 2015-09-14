package com.chinesedreamer.stocks.common.util;

import java.util.Calendar;

public class DateUtil {
	public static int getTodayIntValue(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		
		String ymd = "" + year + (month > 9 ? month : "0" + month) + (day > 9 ? day : "0" + day);
		return Integer.valueOf(ymd);
	}
}
