package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserNeed implements Serializable{
	private List<Collections> list = new ArrayList<>();
	private List<Collections> limitList = new ArrayList<>();
	private String title;
	private int choice;
	private int page;
	private int limit = 12 ;
	
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public List<Collections> getLimitList() {
		return limitList;
	}
	public void setLimitList(List<Collections> limitList) {
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
	public List<Collections> getList() {
		return list;
	}
	public void setList(List<Collections> list) {
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
