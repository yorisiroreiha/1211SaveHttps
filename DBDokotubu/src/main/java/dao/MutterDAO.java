package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Mutter;

public class MutterDAO {
	public List<Mutter> findAll(){
		String sql = """
				SELECT *
				FROM mutters
				ORDER BY
				id DESC
				;
				""";
		List<Mutter> list = new ArrayList<>();
		try(Connection db = new DokotubuDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql);
			ResultSet rst = psm.executeQuery();
			){
			while (rst.next()) {
				int id = rst.getInt("id");
				String userName = rst.getString("name");
				String text = rst.getString("text");
				Mutter mut = new Mutter(id,userName,text);
				list.add(0,mut);
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean create(Mutter mut) {
		String sql ="""
				INSERT INTO 
				mutters (name,text)
				VALUES
				(?,?)
				;
				""";
		try(Connection db = new DokotubuDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setString(1, mut.getUserName());
			psm.setString(2,mut.getText());
			int result = psm.executeUpdate();
			if(result==1) {
				return true ;
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return false;}
	
	public Mutter findOne(int id) {
		String sql = """
				SELECT * 
				FROM mutters
				WHERE id = ? 
				;
				""";
		Mutter mutter = null;
		try(Connection db = new DokotubuDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql);
			ResultSet rst = psm.executeQuery()){
			psm.setInt(1,id);
			int pickedId = rst.getInt("id");
			String userName = rst.getString("name");
			String text = rst.getString("text");
			mutter = new Mutter(pickedId,userName,text);
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return mutter;
	} 
	public void Update(Mutter mutter) {
		String sql = """
				UPDATE mutters
				SET  name = ? ,
				text = ? 
				WHERE id = ? 
				;
				""";
		try(Connection db = new  DokotubuDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setString(1,mutter.getUserName());
			psm.setString(2,mutter.getText());
			psm.setInt(3,mutter.getId());
			psm.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void Delete(int id) {
		String sql = """
				DELETE 
				FROM mutters
				
				""";
	}
}
