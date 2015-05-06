package com.uzabase.java8.sample;

public interface Hoge2 extends IHoge{
	default void say() {
		System.out.println("say2");
	}
}
