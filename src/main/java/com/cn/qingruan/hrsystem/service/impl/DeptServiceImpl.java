package com.cn.qingruan.hrsystem.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.qingruan.hrsystem.dao.DeptDao;
import com.cn.qingruan.hrsystem.domain.Dept;
import com.cn.qingruan.hrsystem.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}
	//查询所有部门
	@Override
	public Dept findDeptById(String id) {
		return deptDao.findDeptById(id);
	}
	@Override
	public int countDepts() {
		return deptDao.countDepts();
	}
	@Override
	public int addDept(int deptno, String deptname, Date create_date, int deptManager) {
		return deptDao.addDept(deptno, deptname, create_date, deptManager);
	}
	@Override
	public int updateDept(int deptno, String deptname, Date create_date, int deptManager, int id) {
		return deptDao.updateDept(deptno, deptname, create_date, deptManager, id);
	}
	@Override
	public int deleteDept(int id) {
		return deptDao.deleteDept(id);
	}
	@Override
	public List<Dept> findDeptsByLimitAndOffset(Integer offset, Integer limit) {
		return deptDao.findDeptsByLimitAndOffset(offset, limit);
	}

}
