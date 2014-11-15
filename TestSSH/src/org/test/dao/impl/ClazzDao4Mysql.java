package org.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.test.dao.IClazzDao;
import org.test.po.Clazz;

public class ClazzDao4Mysql implements IClazzDao {
	private SessionFactory sessionFactory;
	@Override
	public List<Clazz> findall() throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Clazz as c order by c.claid ";
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Clazz> lcs = null;
		 try {
		     tx = session.beginTransaction();
		     Query query = session.createQuery(hql);
		     lcs = query.list();
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw e;
		 }
		 finally {
			 session.close();
		 }
		return lcs;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
