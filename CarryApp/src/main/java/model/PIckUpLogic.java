package model;

import java.io.Serializable;
import java.util.Random;

public class PIckUpLogic implements Serializable{
	public void execute(Carry carry,int times) {
		String[] menu = {"大根","セロリ","里芋","カブ","ゴーヤ","キュウリ","カツオのたたき","ラム肉",
				"鯖の水煮","ブリ","タコ","ちくわ","魚肉ソーセージ","こんにゃく","ツナ缶",
				"納豆","アボガド","レーズン","あげ玉"} ;
		String[] make = new String[times];
		
		for( int i = 0 ; i < times ; i++ ) {
			int temp = new Random().nextInt(menu.length-i);
			make[i] = menu[temp] ;
			menu[temp] = menu[menu.length-i-1] ;
			menu[menu.length-i-1] = make[i] ;
		}
		for( int i = 0 ; i < make.length ; i++ ) {
			if(i==0) {
				carry.setMenu(make[i]);
			}else{
				carry.setMenu(carry.getMenu()+make[i]);
			}
		}
	}
}
