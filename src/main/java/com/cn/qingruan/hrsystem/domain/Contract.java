package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Contract implements Serializable{
	private int id;//表的主键
	private Date contract_date;//合同创建的日期
	private Date start_date;//合同的开始日期
	private Date end_date;//合同的结束日期
	private String comment;//合同的相关注释描述信息
	private int emp_id;//对应这份合同主人在emp表中主键
	private Employee emp;
	public Contract() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getContract_date() {
		return contract_date;
	}
	public void setContract_date(Date contract_date) {
		this.contract_date = contract_date;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Contract [id=" + id + ", contract_date=" + contract_date + ", start_date=" + start_date + ", end_date="
				+ end_date + ", comment=" + comment + ", emp_id=" + emp_id + ", emp=" + emp + "]";
	}
	

}
