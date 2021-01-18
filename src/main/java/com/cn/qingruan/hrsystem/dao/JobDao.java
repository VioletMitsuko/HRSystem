package com.cn.qingruan.hrsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.Job;

@Repository
public interface JobDao {

	// 查询所有职位
	@Select("select * from job")
	public List<Job> findAll();
	
	//根据名称查询职位
	@Select("select * from job where jobname=#{jobname}")
	public Job findJobByName(@Param("jobname") String jobname);
	//分页查询
	@Select("select * from job limit #{offset},#{limit}")
	public List<Job> findJobsByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);
	
	// 查询所有职位总数
	@Select("select count(*) from job")
	public int countJob();
	
	//删除职位
	@Delete("delete from job where id=#{id}")
	public int deleteJob(Integer id);
}
