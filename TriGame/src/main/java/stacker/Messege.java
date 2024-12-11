package stacker;

import java.io.Serializable;

public class Messege implements Serializable{
	private String playerHand;
	private String enemyHand;
	private String messege;
	
	public Messege() {}

	public String getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(String playerHand) {
		this.playerHand = playerHand;
	}

	public String getEnemyHand() {
		return enemyHand;
	}

	public void setEnemyHand(String enemyHand) {
		this.enemyHand = enemyHand;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}
	
}
