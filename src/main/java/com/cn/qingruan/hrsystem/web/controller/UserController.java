package com.cn.qingruan.hrsystem.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.qingruan.hrsystem.domain.Notice;
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
		List<Notice> notices = userService.findAllNotice();
		int id = notices.get(notices.size() - 1).getId();
		session.setAttribute("notice",userService.findNoticeById(id));
		return "main";
	}
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
    
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(HttpSession session){
		List<Notice> notices = userService.findAllNotice();
		int id = notices.get(notices.size() - 1).getId();
		session.setAttribute("notice",userService.findNoticeById(id));
        return "main";
    }
    
    @RequestMapping(value = "/showNotice/{id}", method = RequestMethod.GET)
    public String showNotice(@PathVariable("id") int id,HttpSession session){
    	session.setAttribute("notice",userService.findNoticeById(id));
        return "main";
    }
}
