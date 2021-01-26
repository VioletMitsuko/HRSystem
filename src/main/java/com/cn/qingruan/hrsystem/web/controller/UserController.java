package com.cn.qingruan.hrsystem.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.domain.User;
import com.cn.qingruan.hrsystem.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("result")
public class UserController {
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/login")
//	public String login(String username,String password,HttpSession session) {
//		User user = userService.find(username, password);
//		List<Notice> notices = userService.findAllNotice();
//		int id = notices.get(notices.size() - 1).getId();
//		session.setAttribute("notice",userService.findNoticeById(id));
//		return "main";
//	}
	
	@RequestMapping("/login")
	public @ResponseBody User login(User user,Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session){
		User result = userService.findUserByUsernameAndPassword(user);
		List<Notice> notices = userService.findAllNotice();
		if(result !=null) {
			model.addAttribute("result",result);
			session.setAttribute("notice",userService.findNoticeById(notices.get(notices.size() - 1).getId()));
			return result;
		}
		return result;		
	}
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        return "login";
    }
    
    @RequestMapping(value = "/main")
    public String main(HttpSession session){
        return "main";
    }
    
    @RequestMapping(value = "/showNotice/{id}", method = RequestMethod.GET)
    public String showNotice(int id,HttpSession session){
    	session.setAttribute("notice",userService.findNoticeById(id));
        return "main";
    }
}
