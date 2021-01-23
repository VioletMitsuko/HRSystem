package com.cn.qingruan.hrsystem.service;

import java.util.List;

import com.cn.qingruan.hrsystem.domain.Job;

public interface JobService {
	
	//��ѯ����ְλ
	public List<Job> findAll();
	//����id��ѯְλ
	public Job findJobById(String id);
	//��ҳ��ѯ
	public List<Job> findJobsByLimitAndOffset(Integer offset,Integer limit);
	
	//��ѯ����ְλ����
	public int countJob();
	
	//ɾ��ְλ
	public int deleteJob(Integer id);
	
	//���ְλ
	public int addJod(int jobno,String jobname,int dept_id);
	
	//�޸�ְλ
	public int updateJob(int jobno,String jobname,int dept_id,int id);
	
}
