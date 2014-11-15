package org.test.dao;

import java.util.List;

import org.test.po.Student;

public interface IStudentDao {
	public Student findById(String stuid) throws Exception;
	public List<Student> findall(String claid) throws Exception;
}
