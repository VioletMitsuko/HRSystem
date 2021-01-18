package com.cn.qingruan.hrsystem.service.impl;

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

}
