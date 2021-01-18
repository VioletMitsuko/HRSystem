package com.cn.qingruan.hrsystem.domain;

public class Job {
	private int id;
	private String jobno;
	private String jobname;
	private String des;
	public Job() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobno() {
		return jobno;
	}
	public void setJobno(String jobno) {
		this.jobno = jobno;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getdes() {
		return des;
	}
	public void setdes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", jobno=" + jobno + ", jobname=" + jobname + ", des=" + des + "]";
	}
	
	

}
