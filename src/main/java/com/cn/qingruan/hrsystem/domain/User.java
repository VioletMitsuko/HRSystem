package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int id;//表的主键
	private String username;//该账户的登录名
	private String password;//该账户登录密码
	private Date create_date;//该账户的账号的创建日期
	private Date last_login;//该账户的上次登录时间
	private String name;//该账户的真实姓名
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", create_date=" + create_date
				+ ", last_login=" + last_login + ", name=" + name + "]";
	}
	

}
