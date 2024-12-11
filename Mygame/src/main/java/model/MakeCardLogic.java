package model;


import java.util.ArrayList;
import java.util.Collections;

public class MakeCardLogic{
	public ArrayList<Card> execute() {
		String[] storrs = {"♧","♡","♢","♤"};
		String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		ArrayList<Card> list = new ArrayList<>();
		
		for( int i = 0 ; i < storrs.length ; i++ ) {
			for( int j = 0 ; j < numbers.length ; j++ ) {
				Card card = new Card(storrs[i],numbers[j]);
				list.add(card);
			}
		}
		Collections.shuffle(list);
		return list ;
	}
}
