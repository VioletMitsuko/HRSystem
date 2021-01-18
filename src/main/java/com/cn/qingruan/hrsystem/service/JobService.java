package com.cn.qingruan.hrsystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.qingruan.hrsystem.domain.Job;

public interface JobService {
	
	//查询所有职位
	public List<Job> findAll();
	
	//分页查询
	public List<Job> findJobsByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);
	
	//查询所有职位总数
	public int countJob();
	
	//删除职位
	public int deleteJob(Integer id);
}
