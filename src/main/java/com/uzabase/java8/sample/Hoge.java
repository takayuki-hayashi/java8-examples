package com.uzabase.java8.sample;

public class Hoge implements Hoge2,Hoge1{
	public void say() {
		Hoge2.super.say();
		Hoge1.super.say();
	}
}