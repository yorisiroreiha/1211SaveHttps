package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import model.Data;

@WebServlet("/playerData")
public class PlayerDataDAO extends HttpServlet {
	public List<Data> findAll(){
		List<Data> list = new  ArrayList<>();
		String sql = """
				SELECT * 
				FROM playerData
				""";
		try(Connection db = new ConnectionDB().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			ResultSet rst =  psm.executeQuery();
			while(rst.next()) {
				int id = rst.getInt("id");
				String name  = rst.getString("name");
				String pass = rst.getString("pass");
				int STR = rst.getInt("Strength");
				int CON = rst.getInt("Constitution");
				int DEX = rst.getInt("dexterity");
				int AGI = rst.getInt("agility");
				int INT = rst.getInt("intelligence");
				int SEC = rst.getInt("sensing");
				int MET = rst.getInt("mentality");
				int LUC = rst.getInt("luck");
				Data temp = new Data(id, name, pass, STR, CON, DEX, AGI, INT, SEC, MET, LUC);
				list.add(temp);
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list;
	}
	
	public Data findOne(int id) {
		Data data = new Data();
		String sql = """
				SELECT *
				FROM playerData
				WHERE id = ? 
				;
				""";
				try(Connection db  = new ConnectionDB().getConnection();
					PreparedStatement psm = db.prepareStatement(sql)){
					psm.setInt(1,id);
					ResultSet rst = psm.executeQuery();
					if(rst.next()) {
						String name  = rst.getString("name");
						String pass = rst.getString("pass");
						int STR = rst.getInt("Strength");
						int CON = rst.getInt("Constitution");
						int DEX = rst.getInt("dexterity");
						int AGI = rst.getInt("agility");
						int INT = rst.getInt("intelligence");
						int SEC = rst.getInt("sensing");
						int MET = rst.getInt("mentality");
						int LUC = rst.getInt("luck");
						Data temp = new Data(id, name, pass, STR, CON, DEX, AGI, INT, SEC, MET, LUC);
						data = temp ;
					}
				} catch (SQLException | NamingException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		return data ;
	}
	
	public Data findOne(String name) {
		Data data = new Data();
		String sql = """
				SELECT * 
				FROM playerData
				WHERE name = ?
				;
				""";
		try(Connection db = new ConnectionDB().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setString(1,name);
			ResultSet rst = psm.executeQuery();
			if(rst.next()) {
				int id = rst.getInt("id");
				String pass = rst.getString("pass");
				int STR = rst.getInt("Strength");
				int CON = rst.getInt("Constitution");
				int DEX = rst.getInt("dexterity");
				int AGI = rst.getInt("agility");
				int INT = rst.getInt("intelligence");
				int SEC = rst.getInt("sensing");
				int MET = rst.getInt("mentality");
				int LUC = rst.getInt("luck");
				Data temp = new Data(id, name, pass, STR, CON, DEX, AGI, INT, SEC, MET, LUC);
				data = temp ;
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return data ;
	}
	
	public void InsertOne(Data data) {
		String sql = """
				INSERT INTO playerData 
				VALUES
				(?,?,?,?,?,?,?,?,?,?,?)
				;
				""";
		try(Connection db = new ConnectionDB().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setInt(1,data.getId());
			psm.setString(2,data.getName());
			psm.setString(3,data.getPass());
			psm.setInt(4,data.getSTR());
			psm.setInt(5,data.getCON());
			psm.setInt(6,data.getDEX());
			psm.setInt(7,data.getAGI());
			psm.setInt(8,data.getINT());
			psm.setInt(9,data.getSEC());
			psm.setInt(10,data.getMET());
			psm.setInt(11,data.getLUC());
			psm.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public void updateStatusOne(Data data) {
	    String sql = """
	            UPDATE playerData
	            SET 
	            Strength = ? ,
	            Constitution = ? ,
	            dexterity = ? ,
	            agility = ? ,
	            intelligence = ? ,
	            sensing = ? ,
	            mentality = ? ,
	            luck = ? 
	            WHERE id = ? 
	            ;
	            """;
	    try (Connection db = new ConnectionDB().getConnection();
	         PreparedStatement psm = db.prepareStatement(sql)) {
	        // SQL内で指定した順番に合わせる
	        psm.setInt(1, data.getSTR());
	        psm.setInt(2, data.getCON());
	        psm.setInt(3, data.getDEX());
	        psm.setInt(4, data.getAGI());
	        psm.setInt(5, data.getINT());
	        psm.setInt(6, data.getSEC());
	        psm.setInt(7, data.getMET());
	        psm.setInt(8, data.getLUC());
	        psm.setInt(9, data.getId()); // IDはWHERE句に対応
	        psm.executeUpdate();
	    } catch (SQLException | NamingException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updatePassOne(Data data) {
	String sql = """
			UPDATE playerData
			SET pass = ? 
			WHERE id = ?
			;
			""";
	try(Connection db = new  ConnectionDB().getConnection();
		PreparedStatement psm = db.prepareStatement(sql)){
		psm.setString(1,data.getPass());
		psm.setInt(2,data.getId());
		psm.executeUpdate();
	} catch (SQLException | NamingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
	}
	
	public void deleteOne(Data data) {
		String sql = """
				DELETE 
				FROM playerData
				WHERE id = ?
				""";
		try(Connection db = new ConnectionDB().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setInt(1,data.getId());
			psm.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public String active() {
		return "PlayerDataDAO now active";
	}
	
}
