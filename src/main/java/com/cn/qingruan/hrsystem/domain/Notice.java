package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Notice implements Serializable{
	private int id;//�������
	private String title;//����ı���
	private String context;//���������
	private Date create_date;//����Ĵ�������
	private Date lastModifiled;//�������һ���޸ĵ�ʱ��
	private int user_id;//���������������Ӧ����������û�
	private User user;
	public Notice() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getLastModifiled() {
		return lastModifiled;
	}
	public void setLastModifiled(Date lastModifiled) {
		this.lastModifiled = lastModifiled;
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
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", context=" + context + ", create_date=" + create_date
				+ ", lastModifiled=" + lastModifiled + ", user_id=" + user_id + ", user=" + user + "]";
	}
	
	

}
