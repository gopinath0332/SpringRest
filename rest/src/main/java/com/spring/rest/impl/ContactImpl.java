package com.spring.rest.impl;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.rest.interfaces.ContactDAO;
import com.spring.rest.modal.Person;

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

	public String updateContact( String body) {
		String status ="";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Person person = mapper.readValue(body, Person.class);
			System.out.println("person mapper:::"+person.toString());
			
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(person);
			tx.commit();
			session.close();
			status = "success";
		}  catch (IOException e) {
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}

}
