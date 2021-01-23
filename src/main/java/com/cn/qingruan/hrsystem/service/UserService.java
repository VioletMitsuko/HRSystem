package com.cn.qingruan.hrsystem.service;

import java.util.List;

import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.domain.User;

public interface UserService {
	//查询用户
	public User findUserByUsernameAndPassword(User user);
	//根据id查询用户
	public User findUserById(int id);
	//查询所有公告
	public List<Notice> findAllNotice();
	//根据id查询公告
	public Notice findNoticeById(int id);
}
