package stacker;

public class Judgement {
	public String jg(String hand,int enemyHand) {
		int playerHand = chengePlayer(hand);
		int result = playerHand - enemyHand ;
		if( result % 3 == 2) {
			return "Drow";
		}else if(result % 3 == 0) {
			return "Lose" ;
		}else {
			return "Win" ;
		}
	}
	public int chengePlayer(String hand) {
		switch(hand) {
		case "グー" :return 2;
		case "チョキ":return 3;
		default :return 4;
		}
	}
	public String chengeEnemy(int enemyHand) {
		switch(enemyHand) {
		case 0 :return "グー";
		case 1 :return "チョキ";
		default :return "パー";
		}
	}
}
