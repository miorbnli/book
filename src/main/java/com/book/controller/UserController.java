package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.book.common.vo.SysResult;
import com.book.pojo.User;
import com.book.service.UserService;

/**
 * 用戶操作类
 * 
 * @author LiYuanbin
 * @since 2018年4月1日
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("saveUser")
	@ResponseBody
	public SysResult saveUser(User entity){
		SysResult result=new SysResult();
		User user=new User();
		user.setUsername("哈哈");
		user.setPassword("123456");
		user.setCreateduser("123");
		user.setModifieduser("456");
		String roleids = "1";//默认角色
		try {
			userService.saveUser(user, roleids);
			result.setStatus(200);
			result.setMsg("注册成功");
		} catch (Exception e) {
			result.setStatus(500);
			result.setMsg("注册失败！");
		}
		return result;
	}
}
