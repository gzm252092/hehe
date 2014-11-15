package org.test.action;

import java.util.List;

import org.test.service.IStudentService;
import org.test.vo.StudentVo;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	private IStudentService studentservice;
	private List<StudentVo> lsvs;
	private String claid;
	
	public List<StudentVo> getLsvs() {
		return lsvs;
	}

	
	public String load() throws Exception{
		lsvs = studentservice.findall(claid);
		return "json";
	}

	public void setClaid(String claid) {
		this.claid = claid;
	}


	public void setStudentservice(IStudentService studentservice) {
		this.studentservice = studentservice;
	}
	
	
}
