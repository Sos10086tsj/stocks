package com.chinesedreamer.stocks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesedreamer.stocks.message.ResponseVo;

@Controller
public class IndexController {
	/**
	 * 打开首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model){
		return "login";
	}
	
	/**
	 * 用户登陆
	 * @param model
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseVo login(Model model, HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		return new ResponseVo();
	}
}
