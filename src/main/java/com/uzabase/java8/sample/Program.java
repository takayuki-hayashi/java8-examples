package com.uzabase.java8.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Program {

	public int calc1(List<Integer> list) {
		int sum = 0;
		for(int i:list) {
			sum = sum + i;
		}
		return sum;
	}

	public int calc2(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		int sum = 0;
		while (iterator.hasNext()) {
			sum = sum + iterator.next();
		}
		return sum;
	}

	public int calc3(List<Integer> list) {
		return calc3_impl(0, list);
	}
	
	private int calc3_impl(int total,List<Integer> list){
		if(list.isEmpty()) {
			return total;
		}
		total = total + list.get(0);
		return calc3_impl(total, list.subList(1, list.size()));
	}

	public List<String> join(List<String> list1, List<String> list2) {
		List<String> result = new ArrayList<>();
		//list1.stream().
		return null;
	}

}
