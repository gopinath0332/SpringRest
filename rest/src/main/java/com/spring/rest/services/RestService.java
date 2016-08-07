package com.spring.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.rest.impl.ContactImpl;
import com.spring.rest.modal.ContactList;
import com.spring.rest.modal.Person;

@Controller
@RequestMapping("/api")

public class RestService {

	private ContactImpl impl;

	public RestService() {
		this.impl = new ContactImpl();
	}

	@RequestMapping(value = "/str", method = RequestMethod.GET)
	@ResponseBody
	public String getDummy(ModelMap map) {

		return "Rest Controller is working!!!!";
	}

	@RequestMapping(value = "/obj", method = RequestMethod.GET)
	@ResponseBody
	public Person getObj() {
		Person person = new Person();
		person.setAge(10);
		person.setFname("GGG");
		person.setLname("FFF");
		return person;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ContactList<Person> getList() {
		ContactList<Person> personList = new ContactList<Person>();
		List<Person> list = new ArrayList<Person>();
		Person person = new Person();
		person.setAge(10);
		person.setFname("GGG");
		person.setLname("FFF");
		list.add(person);
		personList.setPersons(list);
		return personList;
	}

	@RequestMapping(value = "/list-obj", method = RequestMethod.GET)
	@ResponseBody
	public Object getListObj() {
		List<Person> list = new ArrayList<Person>();
		Person person = new Person();
		person.setAge(10);
		person.setFname("GGG");
		person.setLname("FFF");
		list.add(person);
		return list;
	}

	@RequestMapping(value = "/list-db", method = RequestMethod.GET)
	@ResponseBody
	public Object getDbList() {
		return this.impl.getList();
	}
}
