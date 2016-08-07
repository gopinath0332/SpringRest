package com.spring.rest.interfaces;

import java.util.List;

public interface ContactDAO {
	public List getList();
	public String updateContact(String body);

}