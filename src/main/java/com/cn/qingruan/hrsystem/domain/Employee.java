package com.cn.qingruan.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Employee implements Serializable{
	private int id;//表的主键
	private String empname;//员工的姓名
	private String empID;//员工的身份证号
	private String jobnum;//员工的工号
	private Date birth;//员工的生日
	private int gender;//员工性别
	private int dept_id;//外键对应dept表中该员工所在部门主键
	private int job_id;//外键对应job表中该员工的职位主键
	private int work_status;//员工的状态 0表示在职 1表示离职
	private int work_message;//员工的用工形式 0表示试用期员工 1表示正式员工
	private Date hiredate;//员工的入职时间或日期
	private String introducer;//员工的介绍人
	private String comment;//关于该员工的一些备注
	private Date leavedate;//该员工的离职日期
	private int leavereason;//该员工的离职原因 0-8对应九种原因,自己看文档。
	private int leavetype;//该员工离职类型 0表示离职 1表示劝退 2表示辞退 3表示自离
	private String leavecomment;//离职备注，比如具体什么原因
	private int changetype;//该员工的转正类型
	private Date changedate;//该员工转正日期
	private String changecomment;//转正备注
	private int recorder;//注意，这个表示外键引用user表的主键 记录人(可以根据这个字段查到员工的职位，职位名字等）(谁把这条员工入职记录输入到系统中的）
	private int deletestatus;//删除状态 1表示删除状态 (文档中的需求：删除操作：弹出确定取消框，确定后修改记录的删除状态=1（不是删除数据）
	private int changerecorder;//外键引用user表的主键（转正信息记录人，谁把这条转正记录录入到系统中）
	private List<Contract> contracts;//对应一个员工可能有的多份合同
	private Contract contract;//万一分页没分好，就把需求改成一个员工只有一份合同。
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
