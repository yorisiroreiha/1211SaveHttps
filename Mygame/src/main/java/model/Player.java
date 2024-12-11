package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	private int id ;
	private String name ;
	private int score ;
	private ArrayList<Card> hands ;
	
	public Player() {}
	public Player(int id,String name) {
		this.id  = id ;
		this.name = name ;
		this.score = 0 ;
		this.hands = new ArrayList<>() ;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ArrayList<Card> getHands() {
		return hands;
	}
	public void setHands(ArrayList<Card> hands) {
		this.hands = hands;
	}
}
