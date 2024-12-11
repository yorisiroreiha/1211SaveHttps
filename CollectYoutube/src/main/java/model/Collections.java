package model;

import java.io.Serializable;

public class Collections implements Serializable{
	private int id ;
	private String title ;
	private String body ;
	private String comment ;
	
	public Collections() {}
	public Collections(int id) {
		this.id = id ;
	}
	public Collections(int id,String title,String body) {
		this.id = id ;
		this.title = title ;
		this.body = body ;
	}
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
