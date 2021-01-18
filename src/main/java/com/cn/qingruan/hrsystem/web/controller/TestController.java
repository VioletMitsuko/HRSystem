package com.cn.qingruan.hrsystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/t")
public class TestController {

	@RequestMapping("/test1")
	public String test01() {
		System.out.println("O");
		return "success";
	}
	@RequestMapping("/test2")
	public String test02() {
		System.out.println("OOOOOOo");
		//return "forward:/pages/employee/add.jsp";
		return "forward:/pages/contract/contractEdit.jsp";
	}
	
	@RequestMapping("/test3")
	public String test03() {
		System.out.println("O");
		return "forward:/1.jsp";
	}
}
