package com.cn.qingruan.hrsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.Job;

@Repository
public interface JobDao {

	// ��ѯ����ְλ
	@Select("select * from job")
	public List<Job> findAll();
	
	//�������Ʋ�ѯְλ
	@Select("select * from job where jobname=#{jobname}")
	public Job findJobByName(@Param("jobname") String jobname);
	//��ҳ��ѯ
	@Select("select * from job limit #{offset},#{limit}")
	public List<Job> findJobsByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);
	
	// ��ѯ����ְλ����
	@Select("select count(*) from job")
	public int countJob();
	
	//ɾ��ְλ
	@Delete("delete from job where id=#{id}")
	public int deleteJob(Integer id);
}
