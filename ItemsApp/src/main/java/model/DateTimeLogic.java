package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateTimeLogic {
    public void execute(Product pd, List<Product> list) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 24時間制のHH
        String formattedDate = sdf.format(now); // Dateをフォーマット
        pd.setDateTime(formattedDate); // String型の日付を設定
        list.add(0, pd); // リストの先頭に追加
        System.out.println("?");
    }
}
