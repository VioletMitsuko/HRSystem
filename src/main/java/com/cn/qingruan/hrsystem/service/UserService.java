package com.cn.qingruan.hrsystem.service;

import com.cn.qingruan.hrsystem.domain.User;

public interface UserService {
	//查询用户
	public User findUser(String username,String password);
	//根据id查询用户
	public User findUserById(int id);
}
