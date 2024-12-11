package gameApp;

import java.util.ArrayList;

import model.Card;
import model.GiveCardLogic;
import model.Player;

public class PokerChargeLogic {
	public void execute(Player user,ArrayList<Card> deck,int n) {
		GiveCardLogic gcl = new GiveCardLogic();
		gcl.execute(user,deck,n);
	}
}
