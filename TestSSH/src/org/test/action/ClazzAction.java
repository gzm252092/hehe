package org.test.action;

import java.util.List;

import org.test.service.IClazzService;
import org.test.vo.ClazzVo;

import com.opensymphony.xwork2.ActionSupport;

public class ClazzAction extends ActionSupport {
	private IClazzService clazzservice;
	private List<ClazzVo> cvs;
	public List<ClazzVo> getCv() {
		return cvs;
	}
	public void setClazzservice(IClazzService clazzservice) {
		this.clazzservice = clazzservice;
	}
	
	public String load() throws Exception{
		cvs = clazzservice.findall();
		return "json";
	}
	
}
