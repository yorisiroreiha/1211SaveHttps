package model;

import java.io.Serializable;

public class Carry implements Serializable{
	private String main;
	private String menu;
	
	public Carry() {}
	public Carry(String main) {
		this.main = main;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
}
