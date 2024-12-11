package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserNeed implements Serializable{
	private List<Word> list = new ArrayList<Word>();
	private List<Word> limitList = new ArrayList<Word>();
	private String title;
	private int choice;
	private int page;
	private int limit = 20 ;
	
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public List<Word> getLimitList() {
		return limitList;
	}
	public void setLimitList(List<Word> limitList) {
		this.limitList = limitList;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public UserNeed() {}
	public UserNeed(String title,int choice) {
		this.title = title ;
		this.choice = choice ;
	}
	public List<Word> getList() {
		return list;
	}
	public void setList(List<Word> list) {
		this.list = list;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
}
