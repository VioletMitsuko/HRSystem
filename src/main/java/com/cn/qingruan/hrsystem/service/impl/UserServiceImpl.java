package com.cn.qingruan.hrsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.qingruan.hrsystem.dao.UserDao;
import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.domain.User;
import com.cn.qingruan.hrsystem.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Override
	public User findUserByUsernameAndPassword(User user) {		
		
		return userDao.findUserByUsernameAndPassword(user);
	}
	@Override
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
	@Override
	public List<Notice> findAllNotice() {
		return userDao.findAllNotice();
	}
	@Override
	public Notice findNoticeById(int id) {
		return userDao.findNoticeById(id);
	}

}
