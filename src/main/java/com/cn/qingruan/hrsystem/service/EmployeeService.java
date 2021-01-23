package com.cn.qingruan.hrsystem.service;

import java.util.List;

import com.cn.qingruan.hrsystem.domain.Employee;
import com.cn.qingruan.hrsystem.domain.PageBean;

public interface EmployeeService {
	/**
	 * 查找所有的员工
	 * @return
	 */
	public List<Employee> findAll();
	
	/**
	 * 根据当前得页号去查询对应得PageBean
	 * @param pageNo
	 * @return
	 */
	public PageBean<Employee> findEmployeeAndPaging(String pageNo);
	
	/**
	 * 查询总页数
	 * @return
	 */
	public int findTotalPages();
	
	/**
	 * 添加员工信息
	 * @param employee
	 */
	public void addEmp(Employee employee);
	
	/**
	 * 根据员工编号去查找对应得员工
	 * @param empID
	 */
	public Employee findEmpByEmpID(String empID);
	
	/**
	 * 更新员工的信息
	 * @param employee
	 */
	public void updateEmp(Employee employee);
	
	/**
	 * 根据员工的empID来删除对应的记录
	 * @param empID
	 */
	public void deleteEmpByEmpID(String empID);
}
