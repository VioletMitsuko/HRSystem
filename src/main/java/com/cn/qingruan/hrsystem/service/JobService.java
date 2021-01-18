package com.cn.qingruan.hrsystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.qingruan.hrsystem.domain.Job;

public interface JobService {
	
	//��ѯ����ְλ
	public List<Job> findAll();
	
	//��ҳ��ѯ
	public List<Job> findJobsByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);
	
	//��ѯ����ְλ����
	public int countJob();
	
	//ɾ��ְλ
	public int deleteJob(Integer id);
}
