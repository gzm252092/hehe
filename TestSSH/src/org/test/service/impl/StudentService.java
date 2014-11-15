package org.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.test.dao.IStudentDao;
import org.test.po.Student;
import org.test.service.IStudentService;
import org.test.vo.StudentVo;

public class StudentService implements IStudentService {
	private IStudentDao studentdao;
	
	@Override
	public List<StudentVo> findall(String claid) throws Exception {
		// TODO Auto-generated method stub
		List<Student> lss = studentdao.findall(claid);
		List<StudentVo> lsvs = p2v(lss);
		return lsvs;
	}

	private List<StudentVo> p2v(List<Student> lss) {
		// TODO Auto-generated method stub
		if(lss==null || lss.size()==0)
			return null;
		List<StudentVo> lsvs = new ArrayList<StudentVo>();
		for(Student s:lss){
			StudentVo sv = p2v(s);
			lsvs.add(sv);
		}
		return lsvs;
	}

	private StudentVo p2v(Student s) {
		// TODO Auto-generated method stub
		StudentVo sv =new StudentVo(s.getStuid(),s.getName());
		return sv;
	}

	@Override
	public StudentVo findById(String stuid) throws Exception {
		// TODO Auto-generated method stub
		Student s = studentdao.findById(stuid);
		return p2v(s);
	}

	public void setStudentdao(IStudentDao studentdao) {
		this.studentdao = studentdao;
	}
	
	

}
