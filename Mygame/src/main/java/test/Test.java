package test;

import java.util.ArrayList;

import model.Card;
import model.GiveCardLogic;
import model.MakeCardLogic;
import model.Player;

public class Test{ 
	public static void main(String[] args) {
		GiveCardLogic gcl = new GiveCardLogic();
		MakeCardLogic mcl = new MakeCardLogic();
		Player test = new Player(1,"test");
		ArrayList<Card> deck = new ArrayList<>();
		
		deck = mcl.execute();
		gcl.execute(test,deck,5);
		
		for(int i = 0 ; i < test.getHands().size() ; i++ ) {
			System.out.println(test.getHands().get(i));
		}
	}
}
