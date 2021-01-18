package com.cn.qingruan.hrsystem.domain;

import java.util.Date;

public class Employee {
	private int id;
	private String empname;
	private String empID;
	private int jobnum;
	private Date birth;
	private String gender;
	private int dept_id;
	private int job_id;
	private String phone;
	private String work_status;
	private String work_message;
	private Date hiredate;
	private Date leavedate;
	private String leavereason;
	private String leavetype;
	private String introducer;
	private String comment;
	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public int getJobnum() {
		return jobnum;
	}
	public void setJobnum(int jobnum) {
		this.jobnum = jobnum;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWork_status() {
		return work_status;
	}
	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}
	public String getWork_message() {
		return work_message;
	}
	public void setWork_message(String work_message) {
		this.work_message = work_message;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
	public String getLeavereason() {
		return leavereason;
	}
	public void setLeavereason(String leavereason) {
		this.leavereason = leavereason;
	}
	public String getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	public String getIntroducer() {
		return introducer;
	}
	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", empID=" + empID + ", jobnum=" + jobnum + ", birth="
				+ birth + ", gender=" + gender + ", dept_id=" + dept_id + ", job_id=" + job_id + ", phone=" + phone
				+ ", work_status=" + work_status + ", work_message=" + work_message + ", hiredate=" + hiredate
				+ ", leavedate=" + leavedate + ", leavereason=" + leavereason + ", leavetype=" + leavetype
				+ ", introducer=" + introducer + ", comment=" + comment + "]";
	}
	
}
