package com.cn.qingruan.hrsystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.Notice;

@Repository
public interface NoticeDao {

	//查询所有公告
	@Select("select * from notice")
	public List<Notice> findAll();
	
	// 根据id查询合同
	@Select("select * from notice where id=#{id}")
	public Notice findNoticeById(@Param("id") int id);
	
	//分页查询
	@Select("select * from contract limit #{offset},#{limit}")
	@Results(id = "noticeMap",value = {
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "title", property = "title"),
			@Result(column = "context", property = "context"),
			@Result(column = "create_date", property = "create_date"),
			@Result(column = "lastModifiled", property = "lastModifiled"),
			@Result(column = "user_id", property = "user",one=@One(select = "com.cn.qingruan.hrsystem.dao.UserDao.findUserById"))
	})
	public List<Notice> findNoticeByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);
	
	// 查询所有公告总数
	@Select("select count(*) from notice")
	public int countNotice();
	
	//删除公告
	@Delete("delete from notice where id=#{id}")
	public int deleteNotice(Integer id);
	
	//添加公告
	@Insert("insert into notice(title,context,create_date,lastModifiled,user_id) values(#{title},#{context},#{create_date},#{lastModifiled},#{user_id})")
	public int addNotice(@Param("title") String title,@Param("context") String context,@Param("create_date") Date create_date,@Param("lastModifiled") Date lastModifiled,@Param("user_id") int user_id);
	
	//修改公告
	@Update("update notice set title=#{title},context=#{context},create_date=#{create_date},lastModifiled=#{lastModifiled},user_id=#{user_id} where id=#{id}")
	public int updateNotice(@Param("title") String title,@Param("context") String context,@Param("create_date") Date create_date,@Param("lastModifiled") Date lastModifiled,@Param("user_id") int user_id,@Param("id") int id);
}
