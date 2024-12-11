package com.sample;

public class Cat extends Animal{
	public Cat(String name) {
		super(name);
	}
	public void makeNoise() {
		System.out.println("にゃん");
		try {
			Thread.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("にゃー");
	}
}
