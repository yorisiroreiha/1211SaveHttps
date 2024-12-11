package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Lunch;

public class LunchDAO {
	//全件表示用
	public List<Lunch> findAll(){
		List<Lunch> list = new ArrayList<>();
		String sql = """
				SELECT *
				FROM lunches
				""";
		try(Connection db = new LunchAppDataSource().getConnection();
				PreparedStatement ps = db.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				int id = rs.getInt("id");
				String shop = rs.getString("shop");
				String menu = rs.getString("menu");
				Lunch lunch = new Lunch(id,shop,menu);
				list.add(lunch);
			}
		} catch (SQLException | NamingException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				
		return list;
	}
	//追加用
	public void insertOne(Lunch lunch) {
		String sql ="""
				INSERT INTO lunches(shop,menu)
				VALUES(?,?)
				;
				""";
		try(Connection db = new LunchAppDataSource().getConnection();
				PreparedStatement ps = db.prepareStatement(sql)){
			ps.setString(1,lunch.getShop());
			ps.setString(2,lunch.getMenu());
			ps.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	//更新用
	public Lunch findOne(int id) {
		Lunch lunch = null ;
		String sql ="""
				SELECT
				shop,menu
				FROM lunches
				WHERE
				id = ? 
				;
				""";
		try(Connection db = new LunchAppDataSource().getConnection();
				PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				lunch = new Lunch(id,rs.getString("shop"),rs.getString("menu"));
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return lunch;
	}
	//書き換え用
	public void updateOne(Lunch lunch) {
		String sql = """
				UPDATE lunches
				SET
				shop = ?,
				menu = ?
				WHERE 
				id = ?
				;
				""";
		try(Connection db = new LunchAppDataSource().getConnection();
				PreparedStatement ps = db.prepareStatement(sql)){
			ps.setString(1,lunch.getShop());
			ps.setString(2,lunch.getMenu());
			ps.setInt(3,lunch.getId());
			ps.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	//削除用
	public void deleteOne(int id) {
		String sql = """
				DELETE 
				FROM lunches
				WHERE 
				id = ? 
				;
				""";
		try( Connection db = new LunchAppDataSource().getConnection();
				PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
