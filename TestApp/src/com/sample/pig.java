package com.sample;

public class pig extends Dog {

	public pig(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	@Override
	public void makeNoise() {
		for( int i = 0 ; i < 5 ; i++ ) {
			System.out.println("ぶー");
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
