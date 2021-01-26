package com.cn.qingruan.hrsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.qingruan.hrsystem.dao.EmployeeDao;
import com.cn.qingruan.hrsystem.domain.Employee;
import com.cn.qingruan.hrsystem.domain.PageBean;
import com.cn.qingruan.hrsystem.service.EmployeeService;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;	
	
	@Override
	public List<Employee> findAll() {
		List<Employee> list =employeeDao.findAll();
		
		return list;
	}

	@Override
	public PageBean<Employee> findEmployeeAndPaging(String pageNo) {
		
		//查询总记录的条数
		int totalItems =employeeDao.findCount();
		
		//计算出页面数		
		int totalPages = (totalItems%5==0)?(totalItems/5):(totalItems/5+1);
		
		List<Employee> employees = employeeDao.findEmployeeAndPaging((Integer.parseInt(pageNo)-1)*5,5);
		
		PageBean<Employee> pageBean = new PageBean<Employee>(totalItems,Integer.parseInt(pageNo),totalPages,employees);		
		
		return pageBean;
	}

	@Override
	public int findTotalPages() {			
		return (employeeDao.findCount()%5)==0?(employeeDao.findCount()/5):(employeeDao.findCount()/5+1);
	}

	
	@Override
	public void addEmp(Employee employee) {
		employeeDao.addEmp(employee);
	}

	@Override
	public Employee findEmpByEmpID(String empID) {
				
		return employeeDao.findEmpByEmpID(empID);
	}

	@Override
	public void updateEmp(Employee employee) {
		employeeDao.updateEmp(employee);
	}

	@Override
	public void deleteEmpByEmpID(String empID) {
		employeeDao.deleteEmp(empID);
		
	}

}
