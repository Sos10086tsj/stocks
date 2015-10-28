package com.chinesedreamer.stocks.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesedreamer.stocks.business.user.service.UserService;
import com.chinesedreamer.stocks.message.ResponseVo;

@Controller
public class IndexController {
	
	@Resource
	private UserService userService;
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
	
	/**
	 * 打开注册页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model, HttpServletRequest request){
		return "register/register";
	}
	
	/**
	 * 用户注册
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ResponseVo registerUser(Model model, HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String invitationCode = request.getParameter("invitationCode");
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		System.out.println("confirmPassword:" + confirmPassword);
		System.out.println("invitationCode:" + invitationCode);
		return new ResponseVo();
	}
	
	/**
	 * 检查用户名是否已经存在
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "register/checkUsernameExist")
	public ResponseVo checkUsernameExist(Model model, HttpServletRequest request){
		String username = request.getParameter("username");
		System.out.println("username:" + username);
		return new ResponseVo();
	}
}
