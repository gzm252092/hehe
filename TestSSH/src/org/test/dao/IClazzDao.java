package org.test.dao;

import java.util.List;

import org.test.po.Clazz;

public interface IClazzDao {
	public List<Clazz> findall() throws Exception;
}
