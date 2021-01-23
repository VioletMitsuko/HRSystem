package com.cn.qingruan.hrsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.domain.User;

@Repository("userDao")
public interface UserDao {
	//查询用户
	@Select("select * from user where username=#{username} and password=#{password}")
	public User findUserByUsernameAndPassword(User user);
	//根据id查询用户
	@Select("select * from user where id=#{id}")
	public User findUserById(int id);
	//查询所有公告
	@Select("select * from notice")
	public List<Notice> findAllNotice();
	//根据ID查询公告
	@Select("select * from notice where id=#{id}")
	public Notice findNoticeById(int id);
}
