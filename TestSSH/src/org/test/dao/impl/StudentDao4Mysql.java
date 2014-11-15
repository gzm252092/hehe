package org.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.test.dao.IStudentDao;
import org.test.po.Clazz;
import org.test.po.Student;

public class StudentDao4Mysql implements
		IStudentDao {

	private SessionFactory sessionFactory;
	@Override
	public Student findById(String stuid) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Student s = null;
		 try {
		     tx = session.beginTransaction();
		    
		     s = (Student) session.get(Student.class, stuid);
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw e;
		 }
		 finally {
			 session.close();
		 }
		return s;
	}

	@Override
	public List<Student> findall(String claid) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Student s where s.clazz = ? ";
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Student> lss = null;
		 try {
		     tx = session.beginTransaction();
		     Query query = session.createQuery(hql);
		     query.setEntity(0, session.get(Clazz.class, claid));
		     lss = query.list();
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw e;
		 }
		 finally {
			 session.close();
		 }
		return lss;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
