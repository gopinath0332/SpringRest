package com.spring.rest.services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.rest.modal.Person;

@Controller
@RequestMapping("/api")

public class RestService {

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
}
