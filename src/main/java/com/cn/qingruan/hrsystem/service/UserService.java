package com.cn.qingruan.hrsystem.service;

import com.cn.qingruan.hrsystem.domain.User;

public interface UserService {
	//��ѯ�û�
	public User findUser(String username,String password);
}
