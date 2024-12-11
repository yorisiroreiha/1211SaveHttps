import java.util.Random;
import java.util.Scanner;
public class FortunesApp {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sca = new Scanner(System.in) ;
		String[] fortunes = {"大吉","中吉","小吉","吉","凶"};
		System.out.print("あなたの名前を入力してください＞");
		String name = sca.nextLine();
		System.out.print("あなたの誕生月を入力してください＞");
		int month = sca.nextInt(); sca.nextLine();//←改行コード打ち消し用
		int random = new Random().nextInt(fortunes.length);
		System.out.printf("%02d月産まれの%sの今日の運勢は%sです%n",month,name,fortunes[random] );
		sca.close();
	}

}
