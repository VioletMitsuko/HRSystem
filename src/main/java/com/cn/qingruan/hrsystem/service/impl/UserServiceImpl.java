package com.cn.qingruan.hrsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.qingruan.hrsystem.dao.UserDao;
import com.cn.qingruan.hrsystem.domain.User;
import com.cn.qingruan.hrsystem.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Override
	public User findUser(String username, String password) {
		return userDao.findUser(username, password);
	}

}
