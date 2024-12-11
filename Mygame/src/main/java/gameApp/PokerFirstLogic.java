package gameApp;

import java.util.ArrayList;

import model.Card;
import model.GiveCardLogic;
import model.MakeCardLogic;
import model.Player;

public class PokerFirstLogic {
	public ArrayList<Card> execute(Player user) {
		GiveCardLogic gcl = new GiveCardLogic();
		MakeCardLogic mcl = new MakeCardLogic();
		ArrayList<Card> deck = mcl.execute();
		
		gcl.execute(user, deck, 5);
		return deck;
	}
}
