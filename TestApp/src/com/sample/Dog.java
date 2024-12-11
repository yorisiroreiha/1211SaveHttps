package com.sample;
public class Dog  extends Animal{
	public Dog(String name) {
		super(name);
	}
	public void makeNoise() {
		System.out.println("ワン!");
		try {
		Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("ワン!");
	}
}
