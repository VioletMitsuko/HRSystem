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

import com.cn.qingruan.hrsystem.domain.Contract;

@Repository
public interface ContractDao {
	// ��ѯ���к�ͬ
	@Select("select * from contract")
	public List<Contract> findAll();

	// ����id��ѯ��ͬ
	@Select("select * from contract where id=#{id}")
	public Contract findContractById(@Param("id") String id);

	// ��ҳ��ѯ
	@Select("select * from contract limit #{offset},#{limit}")
	@Results(id = "contractMap", value = { 
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "contract_date", property = "contract_date"),
			@Result(column = "start_date", property = "start_date"),
			@Result(column = "end_date", property = "end_date"), 
			@Result(column = "comment", property = "comment"),
			@Result(column = "emp_id", property = "emp", one = @One(select = "com.cn.qingruan.hrsystem.dao.EmployeeDao.findEmployeeById"))
	})
	public List<Contract> findContractsByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

	// ��ѯ���к�ͬ����
	@Select("select count(*) from contract")
	public int countContract();

	// ɾ����ͬ
	@Delete("delete from contract where id=#{id}")
	public int deleteContract(Integer id);

	// ��Ӻ�ͬ
	@Insert("insert into contract(contract_date,start_date,end_date,comment,emp_id) values(#{contract_date},#{start_date},#{end_date},#{comment},#{emp_id})")
	public int addContract(@Param("contract_date") Date contract_date, @Param("start_date") Date start_date,
			@Param("end_date") Date end_date, @Param("comment") String comment, @Param("emp_id") int emp_id);

	// �޸ĺ�ͬ
	@Update("update contract set end_date=#{end_date},comment=#{comment},emp_id=#{emp_id} where id=#{id}")
	public int updateContract(@Param("end_date") Date end_date, @Param("comment") String comment,
			@Param("emp_id") int emp_id, @Param("id") int id);
}
