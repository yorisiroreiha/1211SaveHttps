package com.sample;

public abstract class Animal {
int age;
String name;

	public Animal(String name) {
		this.name = name ;
	}
	public String greeting() {
		return String.format("こんにちは、私は%sという動物です",this.name);
	}
	public abstract void makeNoise() ;
}