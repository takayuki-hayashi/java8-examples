package com.uzabase.java8.sample;

import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ProgramTest {

	@Test
	public void リスト内の数字の合計を計算_1() throws Exception {
		Program target = new Program();
		List<Integer> list = asList(1,2,3,4,5);
		assertThat(target.calc1(list), is(15));
	}
	
	@Test
	public void リスト内の数字の合計を計算_2() throws Exception {
		Program target = new Program();
		List<Integer> list = asList(1,2,3,4,5);
		assertThat(target.calc2(list), is(15));
	}
	
	@Test
	public void リスト内の数字の合計を計算_3() throws Exception {
		Program target = new Program();
		List<Integer> list = asList(1,2,3,4,5);
		assertThat(target.calc3(list), is(15));
	}
	
	@Test
	public void 結合() throws Exception {
		List<String> list = asList("1",null,null,"2");
		/*Program target = new Program();
		List<String> list1 = asList("a","b","c");
		List<String> list2 = asList("1","2");
		assertThat(target.join(list1,list2), is(asList("a","1","b","2","c")));*/
		//list.stream().forEach(System.out::println);
		list.stream().map(e -> Integer.valueOf(e)).forEach(System.out::println);
	}
}
