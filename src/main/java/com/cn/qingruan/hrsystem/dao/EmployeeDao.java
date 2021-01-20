package com.cn.qingruan.hrsystem.dao;

import org.apache.ibatis.annotations.Select;

import com.cn.qingruan.hrsystem.domain.Employee;

public interface EmployeeDao {

	//根据ID查询员工
	@Select("select * from employee where id=#{id}")
	public Employee findEmployeeById(int id);
}
