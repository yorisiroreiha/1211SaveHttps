package model;

import java.io.Serializable;

public class Human implements Serializable {
	/* java.io.Serializable;はマーカーインターフェイスなのでオーバーライドするものはない*/
	private String name;
	private int age;
	
	public Human() {}
	public Human(String name,int age) {
		this.name = name ;
		this.age = age ;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public void setName(String name) {
		this.name = name ;
	}
	public void setAge(int age) {
		this.age = age ;
	}
}
