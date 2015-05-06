package com.uzabase.java8.sample;

public interface Hoge1 extends IHoge{
	default void say() {
		System.out.println("say1");
	}
}
