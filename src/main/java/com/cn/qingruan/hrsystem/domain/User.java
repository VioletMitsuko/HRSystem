package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int id;//�������
	private String username;//���˻��ĵ�¼��
	private String password;//���˻���¼����
	private Date create_date;//���˻����˺ŵĴ�������
	private Date last_login;//���˻����ϴε�¼ʱ��
	private String name;//���˻�����ʵ����
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
