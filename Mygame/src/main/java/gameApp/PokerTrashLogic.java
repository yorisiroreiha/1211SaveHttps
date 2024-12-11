package gameApp;

import model.Player;

public class PokerTrashLogic{
	public void execute(Player user,String[] trash) {
		int[] temp = new int[trash.length];
		for( int i = 0 ; i < trash.length ; i++ ) {
			temp[i] = Integer.parseInt(trash[i]);
		}
		for( int i = 0 ; i < temp.length ; i++ ) {
			user.getHands().remove(temp[i]);
			for( int j = 0 ; j < temp.length ; j++) {
				temp[j]-- ;
			}
		}
	}
}
