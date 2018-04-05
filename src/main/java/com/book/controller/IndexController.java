package com.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.vo.SysResult;
import com.book.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("loginUI")
	public String loginUI() {
		return "login";
	}
	@RequestMapping("registUI")
	public String registUI() {
		return "register";
	}
	@RequestMapping("indexUI")
	public String indexUI(HttpSession session){
		return "index";
	}
	@RequestMapping("pageUI")
	public String pageUI(){
		return "common/page";
	}
	@RequestMapping("doLogin")
	@ResponseBody
	public SysResult userLogin(final String username,final String password) {
		try {
			userService.login(username, password);
			return SysResult.oK();
		} catch (Exception e) {
			return SysResult.build(201,"用户名或密码错误");
		}
	}
}
