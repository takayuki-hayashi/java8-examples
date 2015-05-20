package com.uzabase.java8.sample;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Java8_2Test {
	
	@Test
	public void java8() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = list.stream().map(e -> "value is "+e).collect(toList());
		System.out.println(result);
	}

	@Test
	public void testName() throws Exception {
		List<Input> list = Arrays.asList(new Input(1, "takayuki", "hayashi"),new Input(2, "daisuke", "miyashiro"));
		List<Employee> result = new ArrayList<>();
		for(Input each: list){
			result.add(new Employee(each.getId(), each.getLastName() + " " + each.getFirstName()));
		}
		System.out.println(result);
	}
	
	@Test
	public void testName1() throws Exception {
		List<Input> list = Arrays.asList(new Input(1, "takayuki", "hayashi"),new Input(2, "daisuke", "miyashiro"));
		List<Employee> result = list.stream().
										map(e -> new Employee(e.getId(), e.getLastName() + " " + e.getFirstName())).
										collect(toList());
		
	}
	
	class Input {
		private int id;
		private String firstName;
		private String lastName;
		public Input(int id, String name1, String name2) {
			this.id = id;
			this.firstName = name1;
			this.lastName = name2;
		}
		public int getId() {
			return id;
		}
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
	}
	
	class Employee {
		private int id;
		private String name;
		public Employee(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
	}
}
