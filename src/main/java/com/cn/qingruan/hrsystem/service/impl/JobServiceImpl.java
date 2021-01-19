package com.cn.qingruan.hrsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.qingruan.hrsystem.dao.JobDao;
import com.cn.qingruan.hrsystem.domain.Job;
import com.cn.qingruan.hrsystem.service.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService {
	@Autowired
	private JobDao jobDao;

	@Override
	public List<Job> findAll() {
		return jobDao.findAll();
	}

	@Override
	public int countJob() {
		return jobDao.countJob();
	}

	@Override
	public List<Job> findJobsByLimitAndOffset(Integer offset, Integer limit) {

		return jobDao.findJobsByLimitAndOffset(offset, limit);
	}

	@Override
	public int deleteJob(Integer id) {
		
		return jobDao.deleteJob(id);
	}

	@Override
	public int addJod(int jobno, String jobname, int dept_id) {
		
		return jobDao.addJod(jobno, jobname, dept_id);
	}

	@Override
	public int updateJob(int jobno, String jobname, int dept_id,int id) {
		return jobDao.updateJob(jobno, jobname, dept_id,id);
	}

	@Override
	public Job findJobById(int id) {
		return jobDao.findJobById(id);
	}

}
