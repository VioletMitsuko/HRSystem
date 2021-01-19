package com.cn.qingruan.hrsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.Job;

@Repository
public interface JobDao {

	// 查询所有职位
	@Select("select * from job")
	public List<Job> findAll();
	
	//根据id查询职位
	@Select("select * from job where id=#{id}")
	public Job findJobById(@Param("id") int id);
	//分页查询
	@Select("select * from job limit #{offset},#{limit}")
	@Results(id = "jobMap",value = {
			@Result(id = true,column = "id" ,property = "id"),
			@Result(column = "jobno",property = "jobno"),
			@Result(column = "jobname",property = "jobname"),
			@Result(column = "dept_id",property = "depts",one=@One(select="com.cn.qingruan.hrsystem.dao.DeptDao.findDeptById"))
	} )
	public List<Job> findJobsByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);
	
	// 查询所有职位总数
	@Select("select count(*) from job")
	public int countJob();
	
	//删除职位
	@Delete("delete from job where id=#{id}")
	public int deleteJob(Integer id);
	
	//添加职位
	@Insert("insert into job(jobno,jobname,dept_id) values(#{jobno},#{jobname},#{dept_id})")
	public int addJod(@Param("jobno") int jobno,@Param("jobname") String jobname,@Param("dept_id") int dept_id);
	
	//修改职位
	@Update("update job set jobno=#{jobno},jobname=#{jobname},dept_id=#{dept_id} where id=#{id}")
	public int updateJob(@Param("jobno") int jobno,@Param("jobname") String jobname,@Param("dept_id") int dept_id,@Param("id") int id);
}
