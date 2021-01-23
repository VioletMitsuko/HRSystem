package com.cn.qingruan.hrsystem.service;

import java.util.Date;
import java.util.List;

import com.cn.qingruan.hrsystem.domain.Contract;

public interface ContractService {
	// 查询所有合同
	public List<Contract> findAll();

	// 根据id查询合同
	public Contract findContractById(String id);
	// 分页查询

	public List<Contract> findContractsByLimitAndOffset(Integer offset, Integer limit);

	// 查询所有合同总数
	public int countContract();

	// 删除合同
	public int deleteContract(Integer id);

	// 添加合同
	public int addContract(Date contract_date,Date start_date,Date end_date,String comment,int emp_id);

	// 修改合同
	public int updateContract(Date end_date, String comment, int emp_id,int id);
}
