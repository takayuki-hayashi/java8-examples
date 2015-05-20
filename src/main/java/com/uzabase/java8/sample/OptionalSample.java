package com.uzabase.java8.sample;

import static java.util.Arrays.*;

import java.util.Optional;

public class OptionalSample {

	public void exec(String inputString){
		Optional<String> input = Optional.ofNullable(inputString);
		
	}
	
	public void format(Optional<String> input){
		input.map(String::toLowerCase);
	}
	
	public void validate(Optional<String> input){
		input.filter(e -> e.length() > 5);
	}
	
	
	@FunctionalInterface
	public interface Hoge {
		public abstract void exec();
	}
}
