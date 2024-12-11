package model;

import java.io.Serializable;

public class Lunch implements Serializable{
	private int id;
	private String shop;
	private String menu;
	
	public Lunch() {}
	public Lunch(int id,String shop,String menu) {
		this.id = id;
		this.shop = shop ;
		this.menu = menu ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
}
