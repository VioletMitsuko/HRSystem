package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Dept implements Serializable{
	private int id;//表的主键
	private int deptno;//部门的部门编号
	private String deptname;//部门的名称
	private Date create_date;//部门的创建日期
	private String des;//部门的描述信息
	private int deptManager;//部门的主管,外键引用emp表的主键
	private int count;//该部门的总人数
	private int user_id;//创建该部门的用户，外键引用user表的主键
	private User user;
	private Employee emp;
	private List<Employee> emps;
	private Job job;
	private List<Job> jobs;
	public Dept() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getDeptManager() {
		return deptManager;
	}
	public void setDeptManager(int deptManager) {
		this.deptManager = deptManager;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptno=" + deptno + ", deptname=" + deptname + ", create_date=" + create_date
				+ ", des=" + des + ", deptManager=" + deptManager + ", count=" + count + ", user_id=" + user_id
				+ ", user=" + user + ", emp=" + emp + ", emps=" + emps + ", job=" + job + ", jobs=" + jobs + "]";
	}
	
	
}
