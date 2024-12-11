package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Deck implements Serializable{
	private ArrayList<Card> deck;
	
	public Deck() {}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
}
