package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Employee implements Serializable{
	private int id;//�������
	private String empname;//Ա��������
	private String empID;//Ա�������֤��
	private String jobnum;//Ա���Ĺ���
	private Date birth;//Ա��������
	private int gender;//Ա���Ա�
	private int dept_id;//�����Ӧdept���и�Ա�����ڲ�������
	private int job_id;//�����Ӧjob���и�Ա����ְλ����
	private int work_status;//Ա����״̬ 0��ʾ��ְ 1��ʾ��ְ
	private int work_message;//Ա�����ù���ʽ 0��ʾ������Ա�� 1��ʾ��ʽԱ��
	private Date hiredate;//Ա������ְʱ�������
	private String introducer;//Ա���Ľ�����
	private String comment;//���ڸ�Ա����һЩ��ע
	private Date leavedate;//��Ա������ְ����
	private int leavereason;//��Ա������ְԭ�� 0-8��Ӧ����ԭ��,�Լ����ĵ���
	private int leavetype;//��Ա����ְ���� 0��ʾ��ְ 1��ʾȰ�� 2��ʾ���� 3��ʾ����
	private String leavecomment;//��ְ��ע���������ʲôԭ��
	private int changetype;//��Ա����ת������
	private Date changedate;//��Ա��ת������
	private String changecomment;//ת����ע
	private int recorder;//ע�⣬�����ʾ�������user������� ��¼��(���Ը�������ֶβ鵽Ա����ְλ��ְλ���ֵȣ�(˭������Ա����ְ��¼���뵽ϵͳ�еģ�
	private int deletestatus;//ɾ��״̬ 1��ʾɾ��״̬ (�ĵ��е�����ɾ������������ȷ��ȡ����ȷ�����޸ļ�¼��ɾ��״̬=1������ɾ�����ݣ�
	private int changerecorder;//�������user���������ת����Ϣ��¼�ˣ�˭������ת����¼¼�뵽ϵͳ�У�
	private List<Contract> contracts;//��Ӧһ��Ա�������еĶ�ݺ�ͬ
	private Contract contract;//��һ��ҳû�ֺã��Ͱ�����ĳ�һ��Ա��ֻ��һ�ݺ�ͬ��
	private User user;
	private Job job;
	private Dept dept;
	public Employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getJobnum() {
		return jobnum;
	}
	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getWork_status() {
		return work_status;
	}
	public void setWork_status(int work_status) {
		this.work_status = work_status;
	}
	public int getWork_message() {
		return work_message;
	}
	public void setWork_message(int work_message) {
		this.work_message = work_message;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getIntroducer() {
		return introducer;
	}
	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
	public int getLeavereason() {
		return leavereason;
	}
	public void setLeavereason(int leavereason) {
		this.leavereason = leavereason;
	}
	public int getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(int leavetype) {
		this.leavetype = leavetype;
	}
	public String getLeavecomment() {
		return leavecomment;
	}
	public void setLeavecomment(String leavecomment) {
		this.leavecomment = leavecomment;
	}
	public int getChangetype() {
		return changetype;
	}
	public void setChangetype(int changetype) {
		this.changetype = changetype;
	}
	public Date getChangedate() {
		return changedate;
	}
	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}
	public String getChangecomment() {
		return changecomment;
	}
	public void setChangecomment(String changecomment) {
		this.changecomment = changecomment;
	}
	public int getRecorder() {
		return recorder;
	}
	public void setRecorder(int recorder) {
		this.recorder = recorder;
	}
	public int getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}
	public int getChangerecorder() {
		return changerecorder;
	}
	public void setChangerecorder(int changerecorder) {
		this.changerecorder = changerecorder;
	}
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", empID=" + empID + ", jobnum=" + jobnum + ", birth="
				+ birth + ", gender=" + gender + ", dept_id=" + dept_id + ", job_id=" + job_id + ", work_status="
				+ work_status + ", work_message=" + work_message + ", hiredate=" + hiredate + ", introducer="
				+ introducer + ", comment=" + comment + ", leavedate=" + leavedate + ", leavereason=" + leavereason
				+ ", leavetype=" + leavetype + ", leavecomment=" + leavecomment + ", changetype=" + changetype
				+ ", changedate=" + changedate + ", changecomment=" + changecomment + ", recorder=" + recorder
				+ ", deletestatus=" + deletestatus + ", changerecorder=" + changerecorder + ", contracts=" + contracts
				+ ", contract=" + contract + ", user=" + user + ", job=" + job + ", dept=" + dept + "]";
	}
	
	
	
	
	
	
	

}
