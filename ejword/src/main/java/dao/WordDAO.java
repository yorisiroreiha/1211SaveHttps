package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Word;

public class WordDAO {
	public List<Word> findAll(){
		String sql = """
				SELECT * 
				FROM words
				;
				""";
		List<Word> list = new ArrayList<Word>();
		try(Connection db = new EjwordDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql);
			ResultSet rst = psm.executeQuery()){
			while (rst.next()) {
				int id = rst.getInt("id");
				String title = rst.getString("title");
				String body = rst.getString("body");
				Word word = new Word(id,title,body);
				list.add(0,word);
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list ;
	}
	
	public List<Word> limitFindNeed(String findWord, int choice,int limit,int ofset) {
	    String sql = """
	            SELECT *
	            FROM words
	            WHERE title LIKE ?
	            LIMIT ?
	            OFFSET ?
	            ;
	            """;

	    // リストの初期化
	    List<Word> list = new ArrayList<>();

	    // ワイルドカードの設定
	    String type = switch (choice) {
        case 0 -> findWord + "%";    // front: ワードで始まる
        case 1 -> "%" + findWord;    // end: ワードで終わる
        case 2 -> "%" + findWord + "%";  // like: ワードを含む
        default -> findWord;         // is: 完全一致
    };
	    try(Connection db = new EjwordDataSource().getConnection();
	    	PreparedStatement psm = db.prepareStatement(sql);
	    	){
	    	psm.setString(1,type);
	    	psm.setInt(2,limit);
	    	psm.setInt(3,ofset);
	    	ResultSet rst = psm.executeQuery();
			while (rst.next()) {
				int id = rst.getInt("id");
				String title = rst.getString("title");
				String body = rst.getString("body");
				Word word = new Word(id,title,body);
				list.add(0,word);
			}
	    } catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	    // データベース接続
	    return list;
	}
	
	public List<Word> findNeed(String findWord, int choice) {
	    String sql = """
	            SELECT *
	            FROM words
	            WHERE title LIKE ?
	            ;
	            """;

	    // リストの初期化
	    List<Word> list = new ArrayList<>();

	    // ワイルドカードの設定
	    String type = switch (choice) {
        case 0 -> findWord + "%";    // front: ワードで始まる
        case 1 -> "%" + findWord;    // end: ワードで終わる
        case 2 -> "%" + findWord + "%";  // like: ワードを含む
        default -> findWord;         // is: 完全一致
    };
	    try(Connection db = new EjwordDataSource().getConnection();
	    	PreparedStatement psm = db.prepareStatement(sql);
	    	){
	    	psm.setString(1,type);
	    	ResultSet rst = psm.executeQuery();
			while (rst.next()) {
				int id = rst.getInt("id");
				String title = rst.getString("title");
				String body = rst.getString("body");
				Word word = new Word(id,title,body);
				list.add(0,word);
			}
	    } catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	    // データベース接続
	    return list;
	}


}
