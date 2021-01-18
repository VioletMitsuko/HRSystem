package com.cn.qingruan.hrsystem.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.User;

@Repository("userDao")
public interface UserDao {
	//≤È—Ø”√ªß
	@Select("select * from user where username=#{arg0} and password=#{arg1}")
	public User findUser(String username,String password);
}
