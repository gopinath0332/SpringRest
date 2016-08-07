package com.spring.rest.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.spring.rest.interfaces.ContactDAO;

public class ContactImpl implements ContactDAO {

	public static SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List getList() {
		Session session = this.sessionFactory.openSession();
		List list = session.createQuery("from person").list();
		session.close();
		return list;
	}

}
