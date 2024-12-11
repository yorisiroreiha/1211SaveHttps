package com.sample;
import java.util.ArrayList;
import java.util.Scanner;
public class AnimaisCall {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		ArrayList<Animal> ani = new ArrayList<>();
		System.out.print("何体生成しますか＞＞");
		int make = sca.nextInt(); sca.nextLine();//←改行コード破壊用
		for( int i = 0 ; i < make ; i++ ) {
			System.out.print("何を生成しますか(1:犬,2:猫,3:豚)>>");
			int select = sca.nextInt(); sca.nextLine();
			switch(select) {
			case 1 :
				ani.add(new Dog("dog"));
				break;
			case 2 :
				ani.add(new Cat("cat"));
				break;
			case 3:
				ani.add(new pig("pig"));
				break;
			default : 
				System.out.println("その生物はいません");
				break;
			}
		}
		for( int i = 0 ; i < ani.size(); i++ ) {
			ani.get(i).greeting();
			ani.get(i).makeNoise();
		}
		sca.close();
	}
}
