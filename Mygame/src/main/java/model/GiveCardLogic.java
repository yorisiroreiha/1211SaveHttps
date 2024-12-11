package model;


import java.util.ArrayList;

public class GiveCardLogic{
	public void execute(Player p,ArrayList<Card> deck,int pick) {
		ArrayList<Card> temp = new ArrayList<>();
		PickCardLogic pcl = new PickCardLogic() ;
		temp = pcl.execute(deck,pick);
		if(p.getHands()!=null) {
			for( int i = 0 ; i < p.getHands().size() ; i++ ) {
				temp.add(p.getHands().get(i));
			}
			
		}
		p.setHands(temp);
	}
}
