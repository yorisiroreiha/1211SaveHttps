package model;

import java.io.Serializable;

public class Todo implements Serializable{
	private int id;
	private String title;
	private int importance;
	
	public Todo() {}
	public Todo(int id) {
		this.id = id ;
	}
	public Todo(String title) {
		this.title = title ;
	}
	public Todo(int id,String title,int importance) {
		this.id = id ;
		this.title = title ;
		this.importance = importance ;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getImportant() {
		return importance;
	}
	public void setImportant(int important) {
		this.importance= important;
	}
	
	public String getStar() {
		String star = "";
		for( int i = 0 ; i < this.importance ; i++ ) {
			star += "★" ;
		}
		
		return star;
	}
	
}
