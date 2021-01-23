package com.cn.qingruan.hrsystem.service;

import java.util.Date;
import java.util.List;

import com.cn.qingruan.hrsystem.domain.Contract;

public interface ContractService {
	// ��ѯ���к�ͬ
	public List<Contract> findAll();

	// ����id��ѯ��ͬ
	public Contract findContractById(String id);
	// ��ҳ��ѯ

	public List<Contract> findContractsByLimitAndOffset(Integer offset, Integer limit);

	// ��ѯ���к�ͬ����
	public int countContract();

	// ɾ����ͬ
	public int deleteContract(Integer id);

	// ��Ӻ�ͬ
	public int addContract(Date contract_date,Date start_date,Date end_date,String comment,int emp_id);

	// �޸ĺ�ͬ
	public int updateContract(Date end_date, String comment, int emp_id,int id);
}
