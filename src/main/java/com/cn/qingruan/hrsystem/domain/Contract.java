package com.cn.qingruan.hrsystem.domain;

import java.util.Date;

public class Contract {
	private int id;
	private Date contract_date;
	private Date start_date;
	private Date end_date;
	private String comment;
	private int emp_id;
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
	@Override
	public String toString() {
		return "Contract [id=" + id + ", contract_date=" + contract_date + ", start_date=" + start_date + ", end_date="
				+ end_date + ", comment=" + comment + ", emp_id=" + emp_id + "]";
	}
	
	
}
