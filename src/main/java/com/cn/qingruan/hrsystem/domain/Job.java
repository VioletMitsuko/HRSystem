package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.List;

public class Job implements Serializable{
	private int id;//表的主键
	private int jobno;//职位的编号
	private String jobname;//职位的名称
	private String des;//关于该职位的一些描述
	private int dept_id;//对应哪个部门的主键，我不知道有没有用。你们按照自己的展示数据就可以。
	private User user;
	private Dept dept;
	public Job() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJobno() {
		return jobno;
	}
	public void setJobno(int jobno) {
		this.jobno = jobno;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDepts(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", jobno=" + jobno + ", jobname=" + jobname + ", des=" + des + ", dept_id=" + dept_id
				+ ", user=" + user + ", dept=" + dept + "]";
	}
	
	
	

}
