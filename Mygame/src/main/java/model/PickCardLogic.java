package model;

import java.util.ArrayList;

public class PickCardLogic{
	public ArrayList<Card> execute(ArrayList<Card> deck,int pick){
		ArrayList<Card> hands = new ArrayList<>();
		for( int i = 0 ; i < pick ; i++ ) {
			hands.add(deck.get(0));
			deck.remove(0);
		}
		
		return hands;
	}
}
