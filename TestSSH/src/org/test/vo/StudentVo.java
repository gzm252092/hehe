package org.test.vo;

public class StudentVo {
	String stuid;
	String name;
	public StudentVo(String stuid, String name) {
		this.stuid = stuid;
		this.name = name;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
