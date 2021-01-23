package com.cn.qingruan.hrsystem.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cn.qingruan.hrsystem.domain.Employee;
import com.cn.qingruan.hrsystem.domain.PageBean;
import com.cn.qingruan.hrsystem.service.EmployeeService;

@Controller
@RequestMapping("/employee")

@SessionAttributes("pageBean")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/findAll")
	public String findAll(Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees",employees);
		
		//request.getRequestDispatcher("/jsp/employeePage.jsp").forward(request, response);
		
		return "forward:/jsp/employeePage.jsp";
	}
	
	@RequestMapping("/findEmployeeAndPaging")
	public String findEmployeeAndPaging(String pageNo,Model model) {
		if(pageNo==null) {
			pageNo="1";
		}
		PageBean<Employee> pageBean = employeeService.findEmployeeAndPaging(pageNo);
		
		model.addAttribute("pageBean",pageBean);
		
		return "forward:/jsp/employeePage.jsp";
	}
	
	@RequestMapping("/findTotalPages")
	public @ResponseBody int findTotalPages(Model model) {
		
		int totalPages = employeeService.findTotalPages();
		
		return totalPages;
		
	}
	
	@RequestMapping("/addEmp")
	public String addEmployee(Employee employee) {
						
		employeeService.addEmp(employee);
		
		return "employeePage";
	}
	
	@RequestMapping("/findEmpByEmpID")
	public @ResponseBody Employee findEmpByEmpID(String empID) {
		
		return employeeService.findEmpByEmpID(empID);	
	}
	
	
	@RequestMapping("/updateEmp")
	public String updateEmp(Employee employee) {
		
		employeeService.updateEmp(employee);
		
		return "employeePage";
	}
	
	@RequestMapping("/deleteEmp")
	public String deleteEmpByEmpID(String empID) {
		employeeService.deleteEmpByEmpID(empID);
		
		return "employeePage";
	}
	
	
}
