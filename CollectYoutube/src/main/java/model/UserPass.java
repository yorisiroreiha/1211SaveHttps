package model;

import java.io.Serializable;

public class UserPass implements Serializable{
	private String pass ;
	
	public UserPass() {}
	public UserPass(String pass) {
		this.pass = pass ;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String  pass) {
		this.pass = pass;
	}
	
	
}
