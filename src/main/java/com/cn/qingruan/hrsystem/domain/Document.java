package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable{
	private int id;//表的主键
	private String title;//文件的标题
	private String filename;//文件名字
	private String create_date;//文件的创建日期
	private String user_id;//外键应用user表的主键，对应上传该文件的用户。
	private Date lastModifiled;//文件最后一次修改的时间
	private User user;
	public Document() {
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getLastModifiled() {
		return lastModifiled;
	}
	public void setLastModifiled(Date lastModifiled) {
		this.lastModifiled = lastModifiled;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", filename=" + filename + ", create_date=" + create_date
				+ ", user_id=" + user_id + ", lastModifiled=" + lastModifiled + ", user=" + user + "]";
	}
	

}
