package com.cn.qingruan.hrsystem.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.qingruan.hrsystem.domain.Job;
import com.cn.qingruan.hrsystem.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;

	@RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
	public String getTotalPages(HttpSession session) {
		int limit = 5;
		int totalItems = jobService.countJob();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		session.setAttribute("totalPages", totalPages);
		return "jobPage";
	}

	@RequestMapping(value = "/getJobList", method = RequestMethod.GET)
	public ModelAndView getJobList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
		ModelAndView mv = new ModelAndView("jobPage");
		int limit = 5;
		int totalItems = jobService.countJob();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		int offset = (pageNo - 1) * limit;
		List<Job> jobs = jobService.findJobsByLimitAndOffset(offset, limit);

		mv.addObject("jobs", jobs)
			.addObject("totalItems", totalItems)
			.addObject("totalPages", totalPages)
			.addObject("curPageNo", pageNo);
		return mv;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(HttpSession session) {
		List<Job> jobs = jobService.findAll();
		session.setAttribute("jobs", jobs);
		return "jobPage";
	}
	
	@RequestMapping("/findJobById")
	public @ResponseBody Job findJobById(String id) {

		return jobService.findJobById(id);
	}

	@RequestMapping(value = "/deleteJob/{id}", method = RequestMethod.GET)
	public String deleteJob(@PathVariable("id") int id,HttpSession session) {
		int res = jobService.deleteJob(id);
		if(res>0) {
			session.setAttribute("result", res);
		}
		return "jobPage";
	}
	
	@RequestMapping(value = "/addJob", method = RequestMethod.GET)
	public String addJob(int jobno,String jobname,int dept_id,HttpSession session) {
		int res = 0;
		res = jobService.addJod(jobno, jobname, dept_id);
		if(res>0) {
			session.setAttribute("result", res);
		}
		return "jobPage";
	}
	
	@RequestMapping(value = "/updateJob/{id}", method = RequestMethod.GET)
	public String updateJob(int jobno,String jobname,int dept_id,@PathVariable("id") int id,HttpSession session) {
		int res = 0;
		res = jobService.updateJob(jobno, jobname, dept_id, id);
		if(res>0) {
			session.setAttribute("result", res);
		}
		return "jobPage";
	}
	
}
