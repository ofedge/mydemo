package com.vicitf.bootcss.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.bootcss.Application;
import com.vicitf.bootcss.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTest {
	@Autowired
	private PersonService ps;
	
	@Test
	public void findAllTest() {
		Page<Person> page = ps.findAll(new PageRequest(0, 10));
		System.out.println(">>> number: " + page.getNumber());
		System.out.println(">>> size: " + page.getSize());
		System.out.println(">>> number of elements: " + page.getNumberOfElements());
		System.out.println(">>> total pages: " + page.getTotalPages());
		System.out.println(">>> total elements: " + page.getTotalElements());
		List<Person> list = page.getContent();
		for (Person person : list) {
			System.out.println(person);
		}
	}
}
