package com.uzabase.java8.sample;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;
import static com.google.common.collect.FluentIterable.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

public class Java8_StreamTest {
	@Test
	public void java7() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = new ArrayList<>();
		for(String each:list) {
			result.add(each.replaceAll("o", "z"));
		}
		System.out.println(result);
	}
	
	@Test
	public void java7andGuava() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = FluentIterable.from(list).transform(new Function<String, String>() {
			@Override
			public String apply(String input) {
				return input.replaceAll("o", "z");
			}
		}).toList();
		System.out.println(result);
	}
	
	@Test
	public void java8() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = 
				
				list.stream().map(e -> e.replaceAll("o","z")).collect(toList());
		
		List<String> result1 = 
				
				list.stream().map(
						(String e) -> {
							return e.replaceAll("o","z");
						}
				).collect(toList());
		
		System.out.println(result);
	}
	
	@Test
	public void java8andGuava() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = from(list).transform(e -> e.replaceAll("o","z")).toList();
		System.out.println(result);
	}
	
	@Test
	public void java7_filter() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = new ArrayList<>();
		for(String each:list) {
			if(each.length() > 3) {
				result.add(each);
			}
		}
		System.out.println(result);
	}
	
	@Test
	public void java7andGuava_filter() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = FluentIterable.from(list).filter(new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return input.length() > 3;
			}
		}).toList();
		System.out.println(result);
	}
	
	@Test
	public void java8_filter() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = list.stream().filter(e -> e.length() > 3).collect(toList());
		System.out.println(result);
	}
	
	@Test
	public void java8andGuava_filter() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		List<String> result = from(list).filter(e -> e.length() > 3).toList();
		System.out.println(result);
	}
	
	@Test
	public void java7_ListToMap() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		Map<Integer, List<String>> map = new HashMap<>();
		for(String each:list) {
			if(!map.containsKey(each.length())){
				map.put(each.length(), new ArrayList<>());
			}
			map.get(each.length()).add(each);
		}
		System.out.println(map);
	}
	
	@Test
	public void java8_ListToMap() throws Exception {
		List<String> list = Arrays.asList("foo","bar","hoge");
		Map<Integer, List<String>> map = list.stream().collect(groupingBy(e -> e.length()));
		System.out.println(map);
	}
	
	@Test
	public void testName() throws Exception {
		Runnable s = (Runnable & Serializable & Foo & Bar)()-> System.out.println("test");
		System.out.println(s);
	}
}
