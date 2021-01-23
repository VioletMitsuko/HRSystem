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

import com.cn.qingruan.hrsystem.domain.Employee;

public interface EmployeeDao {

	//根据ID查询员工
	@Select("select * from employee where id=#{id}")
	public Employee findEmployeeById(int id);
	
	@Select("select * from employee")
	@Results(id="employeeMap",value= {
			@Result(id=true,column="id",property="id"),
			@Result(property="empname",column="empname"),
			@Result(property="empID",column="empID"),
			@Result(property="jobnum",column="jobnum"),
			@Result(property="gender",column="gender"),
			@Result(property="dept",column="dept_id",
				one=@One(select="com.cn.qingruan.hrsystem.dao.DeptDao.findDeptById"))				
			
		})
	public List<Employee> findAll();
	
	/**
	 * 查询总记录条数
	 * @return
	 */
	@Select("select count(*) from employee")
	public int findCount();
	
	@Select("select * from employee limit #{start},#{count}")
	@Results(id="empMap",value= {
			@Result(id=true,column="id",property="id"),
			@Result(property="empname",column="empname"),
			@Result(property="empID",column="empID"),
			@Result(property="jobnum",column="jobnum"),
			@Result(property="gender",column="gender"),
			@Result(property="dept",column="dept_id",
				one=@One(select="com.cn.qingruan.hrsystem.dao.DeptDao.findDeptById")),
			@Result(property="job",column="job_id",one=@One(select="com.cn.qingruan.hrsystem.dao.JobDao.findJobById"))
		})
	public List<Employee> findEmployeeAndPaging(@Param("start") int start,@Param("count") int count);
	
	
	@Insert("insert into employee(id,empname,empID,jobnum,gender,dept_id,job_id) values(null,#{empname},#{empID},#{jobnum},#{gender},#{dept_id},#{job_id})")
	public void addEmp(Employee employee);
	
	@Select("select * from employee where empID =#{empID}")
	public Employee findEmpByEmpID(String empID);
	
	
	@Update("update employee set empname=#{empname},jobnum=#{jobnum},gender=#{gender},dept_id=#{dept_id},job_id=#{job_id} where empID=#{empID}")
	public void updateEmp(Employee employee);
	
	@Delete("delete from employee where empID=#{empID}")
	public void deleteEmp(String empID);
}
