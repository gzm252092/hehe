package org.test.po;

import java.util.HashSet;
import java.util.Set;

public class Clazz {
	String claid;
	String name;
	Set<Student> students = new HashSet<Student>(0);
	public String getClaid() {
		return claid;
	}
	public void setClaid(String claid) {
		this.claid = claid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
