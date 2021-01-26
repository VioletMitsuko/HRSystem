package com.cn.qingruan.hrsystem.service;

import java.util.Date;
import java.util.List;

import com.cn.qingruan.hrsystem.domain.Dept;

public interface DeptService {
	// 查询所有部门
	public List<Dept> findAll();

	// 根据id查询部门
	public Dept findDeptById(String id);

	// 查询部门总数
	public int countDepts();

	// 添加部门
	public int addDept(int deptno, String deptname, Date create_date, int deptManager);

	// 修改部门信息
	public int updateDept(int deptno, String deptname, Date create_date, int deptManager, int id);

	// 删除部门信息
	public int deleteDept(int id);

	// 查询所有部门信息
	public List<Dept> findDeptsByLimitAndOffset(Integer offset, Integer limit);
}
