package com.chinesedreamer.stocks.domain.sysconfig.util;

import java.util.HashMap;
import java.util.Map;

public class ShowApiSignUtil {
	public static void main(String[] args){
		Map<String, String> params = new HashMap<String, String>();
		params.put("showapi_appid", "123");
		params.put("showapi_timestamp", "20141114142239");
		params.put("nam", "测试");
		params.put("name", "张三");
		params.put("age", "22");
		generateSign(params);
	}
	
	public static String generateSign(Map<String, String> params) {
		for (String key : params.keySet()) {
			System.out.println(key);
		}
		return "";
	}
}
