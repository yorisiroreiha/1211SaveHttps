package model;

import java.io.Serializable;

public class Comment implements Serializable{
private String userName;
private String title;
private String text;

public Comment() {}
public Comment(String name,String title,String text) {
	this.userName = name;
	this.title = title;
	this.text = text;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

}
