package com.cn.qingruan.hrsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.Dept;

@Repository("deptDao")
public interface DeptDao {

	//查询所有部门
	@Select("select * from dept")
	public List<Dept> findAll();
	
	//查询部门总数
    @Select({"SELECT COUNT(*) FROM"})
    public int countDepts();
}
