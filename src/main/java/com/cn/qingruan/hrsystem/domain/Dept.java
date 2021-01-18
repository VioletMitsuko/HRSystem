package com.cn.qingruan.hrsystem.domain;

import java.util.Date;

public class Dept {
	private int id;
	private int deptno;
	private String deptname;
	private Date create_date;
	private String des;
	private int count;
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
	public String getdes() {
		return des;
	}
	public void setdes(String des) {
		this.des = des;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptno=" + deptno + ", deptname=" + deptname + ", create_date=" + create_date
				+ ", des=" + des + "]";
	}
	
	
}
