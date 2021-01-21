package com.cn.qingruan.hrsystem.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.User;

@Repository("userDao")
public interface UserDao {
	//��ѯ�û�
	@Select("select * from user where username=#{username} and password=#{password}")
	public User findUser(@Param("username") String username,@Param("password") String password);
	//����id��ѯ�û�
	@Select("select * from user where id=#{id}")
	public User findUserById(int id);
}
