package model;

import java.io.Serializable;

public class Product implements Serializable{
	private String name ;
	private int price ;
	private String dateTime ;
	
	/*引数(0)，3*/
	public Product(){}//←必須項目だったはず
	public Product(String name,int price){
		this.name = name ;
		this.price = price ;
	}
	
	/*get,set*/
	public String getName(){ return this.name ;}
	public void setName(String name){ this.name = name ;}
	
	public int getPrice(){ return this.price ;}
	public void setPrice(int price){ this.price = price ;}
	
	public String getDateTime(){ return this.dateTime ;}
	public void setDateTime(String dateTime){ this.dateTime = dateTime ;}
}