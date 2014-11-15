package org.test.service;

import java.util.List;

import org.test.vo.StudentVo;

public interface IStudentService {
	public List<StudentVo> findall(String claid) throws Exception;
	public StudentVo findById(String stuid) throws Exception;
}
