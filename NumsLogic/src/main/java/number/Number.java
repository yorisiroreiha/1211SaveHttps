package number;

import java.io.Serializable;
import java.util.ArrayList;

public class Number implements Serializable{
	private int baseNumber;
	private int count;
	private ArrayList<Integer> playerNumber;
	private ArrayList<String> check;
	
	public Number() {}
	public Number(int baseNumber) {
		this.baseNumber = baseNumber ;
		playerNumber = new ArrayList<>();
		check = new ArrayList<>();
	}
	public int getBaseNumber() {
		return baseNumber;
	}
	public void setBaseNumber(int baseNumber) {
		this.baseNumber = baseNumber;
	}
	public int getCount() {
		return this.count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPlayerNumber(int n) {
		return playerNumber.get(n);
	}
    public void setPlayerNumber(int number) {
        if (this.playerNumber == null) {
            this.playerNumber = new ArrayList<>();
        }
        this.playerNumber.add(number);
    }
	public String getCheck(int n) {
		return check.get(n);
	}
	public void setCheck(String check) {
        if (this.check == null) {
            this.check = new ArrayList<>();
        }
        this.check.add(check);
    }


	
	
	
}
