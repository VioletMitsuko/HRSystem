package com.cn.qingruan.hrsystem.dao;

import java.util.Date;
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

import com.cn.qingruan.hrsystem.domain.Dept;

@Repository("deptDao")
public interface DeptDao {

	//查询所有部门
	@Select("select * from dept")
	public List<Dept> findAll();
	
	//根据id查询部门
	@Select("select * from dept where id=#{id}")
	public Dept findDeptById(@Param("id") String id);
	
	//查询部门总数
    @Select({"select count(*) from dept"})
    public int countDepts();
    
	
	//添加部门
	@Insert("insert into dept(deptno,deptname,create_date,deptManager) values(#{deptno},#{deptname},#{create_date},#{deptManager})")
	public int addDept(@Param("deptno") int deptno,@Param("deptname") String deptname,@Param("create_date") Date create_date,@Param("deptManager") int deptManager);

	//修改部门信息
	@Update("update dept set deptno=#{deptno},deptname=#{deptname},create_date=#{create_date},deptManager=#{deptManager} where id=#{id}")
	public int updateDept(@Param("deptno") int deptno,@Param("deptname") String deptname,@Param("create_date") Date create_date,@Param("deptManager") int deptManager,@Param("id") int id);
	
	
	//删除部门信息
	@Delete("delete from dept where id=#{id}")
	public int deleteDept(int id);
	
	//查询所有部门信息
	@Select("select * from dept limit #{offset},#{limit}")
	@Results(id="deptMap",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="deptno",property="deptno"),
			@Result(column="deptname",property="deptname"),
			@Result(column="create_date",property="create_date"),
			@Result(column="deptManager",property="emp",one=@One(select="com.cn.qingruan.hrsystem.dao.EmployeeDao.findEmployeeById")),
	})
	public List<Dept> findDeptsByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
