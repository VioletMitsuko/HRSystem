package com.cn.qingruan.hrsystem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.qingruan.hrsystem.domain.User;
import com.cn.qingruan.hrsystem.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(String username,String password) {
		User user = userService.findUser(username, password);
		return "main";
	}
}
