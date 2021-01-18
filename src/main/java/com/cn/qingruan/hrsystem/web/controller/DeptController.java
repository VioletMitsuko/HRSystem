package com.cn.qingruan.hrsystem.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.qingruan.hrsystem.domain.Dept;
import com.cn.qingruan.hrsystem.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	@RequestMapping("/findAll")
	public String findAll(HttpSession session) {
		List<Dept> departments = deptService.findAll();
		session.setAttribute("departments", departments);
		return "departmentPage";
	}
}
