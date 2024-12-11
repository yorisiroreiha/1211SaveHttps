package dao;



	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import logic.CheckUserPass;
import model.Collections;
import model.UserPass;


	public class CollectYoutubeConnection {
		public List<Collections> findAll(){
			String sql = """
					SELECT * 
					FROM links
					;
					""";
			List<Collections> list = new ArrayList<>();
			try(Connection db = new CollectDataSouece().getConnection();
				PreparedStatement psm = db.prepareStatement(sql);
				ResultSet rst = psm.executeQuery()){
				while (rst.next()) {
					int id = rst.getInt("id");
					String title = rst.getString("title");
					String body = rst.getString("body");
					String comment = rst.getString("comment");
					Collections word = new Collections(id,title,body);
					word.setComment(comment);
					list.add(0,word);
				}
			} catch (SQLException | NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return list ;
		}
		
		public List<Collections> limitFindNeed(String findWord, int choice,int limit,int ofset) {
		    String sql = """
		            SELECT *
		            FROM links
		            WHERE title LIKE ?
		            LIMIT ?
		            OFFSET ?
		            ;
		            """;

		    // リストの初期化
		    List<Collections> list = new ArrayList<>();

		    // ワイルドカードの設定
		    String type = switch (choice) {
	        case 0 -> findWord + "%";    // front: ワードで始まる
	        case 1 -> "%" + findWord;    // end: ワードで終わる
	        case 2 -> "%" + findWord + "%";  // like: ワードを含む
	        default -> findWord;         // is: 完全一致
	    };
		    try(Connection db = new CollectDataSouece().getConnection();
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
					String comment = rst.getString("comment");
					Collections word = new Collections(id,title,body);
					word.setComment(comment);
					list.add(0,word);
				}
		    } catch (SQLException | NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		    // データベース接続
		    return list;
		}
		
		public List<Collections> findNeed(String findWord, int choice) {
		    String sql = """
		            SELECT *
		            FROM links
		            WHERE title LIKE ?
		            ;
		            """;

		    // リストの初期化
		    List<Collections> list = new ArrayList<>();

		    // ワイルドカードの設定
		    String type = switch (choice) {
	        case 0 -> findWord + "%";    // front: ワードで始まる
	        case 1 -> "%" + findWord;    // end: ワードで終わる
	        case 2 -> "%" + findWord + "%";  // like: ワードを含む
	        default -> findWord;         // is: 完全一致
	    };
		    try(Connection db = new CollectDataSouece().getConnection();
		    	PreparedStatement psm = db.prepareStatement(sql);
		    	){
		    	psm.setString(1,type);
		    	ResultSet rst = psm.executeQuery();
				while (rst.next()) {
					int id = rst.getInt("id");
					String title = rst.getString("title");
					String body = rst.getString("body");
					String comment = rst.getString("comment");
 					Collections word = new Collections(id,title,body);
 					word.setComment(comment);
					list.add(0,word);
				}
		    } catch (SQLException | NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
		    }
		    // データベース接続
		    return list;
		}
		public void insertOne(Collections lunch) {
			String sql ="""
					INSERT INTO links(title,body,comment)
					VALUES(?,?,?)
					;
					""";
			try(Connection db = new CollectDataSouece().getConnection();
					PreparedStatement ps = db.prepareStatement(sql)){
				ps.setString(1,lunch.getTitle());
				ps.setString(2,lunch.getBody());
				ps.setString(3,lunch.getComment());
				ps.executeUpdate();
			} catch (SQLException | NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		public Collections findOne(int id) {
			Collections collection = new Collections();
			System.out.println("call");
			String sql ="""
					SELECT
					title,
					body,
					comment 
					FROM links
					WHERE id = ? 
					;
					""";
			if(id==0) {System.out.println("error0");}
			try(Connection db = new CollectDataSouece().getConnection();
				PreparedStatement psm = db.prepareStatement(sql)){
				psm.setInt(1,id);
				ResultSet rst = psm.executeQuery();
				while(rst.next()) {
					String title = rst.getString("title");
					String body = rst.getString("body");
					String comment = rst.getString("comment");
					collection.setId(id);
					collection.setTitle(title);
					collection.setBody(body);
					collection.setComment(comment);
					System.out.println(collection.getId());
				}
			} catch (SQLException | NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return collection;
		}
		public void setOnt(Collections collection) {
			String sql ="""
					UPDATE links
					SET title = ?,
					body = ? ,
					comment = ?
					WHERE id = ? 
					;
					""";
			try(Connection db = new CollectDataSouece().getConnection();
				PreparedStatement psm = db.prepareStatement(sql)){
				psm.setString(1,collection.getTitle());
				psm.setString(2,collection.getBody());
				psm.setString(3,collection.getComment());
				psm.setInt(4,collection.getId());
				psm.executeUpdate();
			} catch (SQLException | NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		public boolean deleteOne(Collections collection,UserPass pass) {
			String sql = """
					DELETE 
					FROM links
					WHERE id = ?
					;
					""";
			try(Connection db =  new CollectDataSouece().getConnection();
				PreparedStatement psm = db.prepareStatement(sql)){
				psm.setInt(1,collection.getId());
				CheckUserPass cup = new CheckUserPass();
				if(cup.execute(pass)) {
					psm.executeUpdate();
					return true ;
				}else {
					return false ;
				}
			} catch (SQLException | NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return false ;
		}
	}