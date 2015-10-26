package com.chinesedreamer.stocks.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StockExceptionHandler implements HandlerExceptionResolver{
	
	private Logger logger = LoggerFactory.getLogger(StockExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView view = new ModelAndView("exception");
		String errorMessage = "";
		logger.error("{}",ex);
		view.addObject("errorMessage", errorMessage);
		return view;
	}

}
