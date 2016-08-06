package com.spring.rest.modal;

import java.util.List;

public class PersonList<T> {
	List<T> persons;

	public List<T> getPersons() {
		return persons;
	}

	public void setPersons(List<T> persons) {
		this.persons = persons;
	}

}
