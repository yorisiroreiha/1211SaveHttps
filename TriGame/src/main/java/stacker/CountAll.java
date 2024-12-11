package stacker;

import java.io.Serializable;

public class CountAll implements Serializable{
	private int win;
	private int drow;
	private int lose;
	
	public CountAll() {}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getDrow() {
		return drow;
	}

	public void setDrow(int drow) {
		this.drow = drow;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}
	
	
}
