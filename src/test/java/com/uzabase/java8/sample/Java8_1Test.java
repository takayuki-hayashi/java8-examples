package com.uzabase.java8.sample;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

@RunWith(Enclosed.class)
public class Java8_1Test {

	public static class StringTest {
		@Test
		public void join() throws Exception {
			assertThat(String.join(",", "java","scala","jruby"), is("java,scala,jruby"));
		}
		
		@Test
		public void join_2() throws Exception {
			List<String> list = asList("java","scala","jruby");
			assertThat(String.join(",", list), is("java,scala,jruby"));
		}
	}
	
	public static class FilesTest {
		
		@Test
		public void read() throws Exception {
			Files.readAllLines(Paths.get("pom.xml"));
		}
		
		@Test
		public void lines() throws Exception {
			Files.lines(Paths.get("pom.xml")).forEach(System.out::println);
		}
		
		@Test
		public void list() throws Exception {
			Files.list(Paths.get(".")).map(Path::toFile).filter(File::isFile).filter(f -> !f.isHidden()).forEach(System.out::println);
		}
	}
	
	public static class BufferedReaderTest {
		@Test
		public void lines() throws Exception {
			try(BufferedReader reader = new BufferedReader(new FileReader("pom.xml"))){
				reader.lines().forEach(System.out::println);
			}
		}
	}
}