package com.cn.qingruan.hrsystem.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.qingruan.hrsystem.domain.User;
import com.cn.qingruan.hrsystem.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session) {
		User user = userService.findUser(username, password);
		return "main";
	}
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
    
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
