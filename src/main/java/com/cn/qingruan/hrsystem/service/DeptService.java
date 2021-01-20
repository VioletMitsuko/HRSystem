package com.cn.qingruan.hrsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.qingruan.hrsystem.domain.Dept;

public interface DeptService {
	//查询所有部门
	public List<Dept> findAll();
	
	public Dept findDeptById(int id);
}
