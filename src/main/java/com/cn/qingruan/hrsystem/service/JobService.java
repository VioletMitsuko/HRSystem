package com.cn.qingruan.hrsystem.service;

import java.util.List;

import com.cn.qingruan.hrsystem.domain.Job;

public interface JobService {
	
	//查询所有职位
	public List<Job> findAll();
	//根据id查询职位
	public Job findJobById(String id);
	//分页查询
	public List<Job> findJobsByLimitAndOffset(Integer offset,Integer limit);
	
	//查询所有职位总数
	public int countJob();
	
	//删除职位
	public int deleteJob(Integer id);
	
	//添加职位
	public int addJod(int jobno,String jobname,int dept_id);
	
	//修改职位
	public int updateJob(int jobno,String jobname,int dept_id,int id);
	
}
