package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import model.Donut;

/**
 * Servlet implementation class DonutDAO
 */
@WebServlet("/DonutDAO")
public class DonutDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/donutapp");
		this.db = ds.getConnection();
	}

	private void disconnect()  {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ConnectCheck() {
		try {
			this.connect();
			System.out.println("OK");
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public List<Donut> findAll() {
		List<Donut> list = new ArrayList<Donut>();
		String sql = """
				SELECT 
				id,
				name,
				price,
				imgname
				FROM donuts
				""";
		try(Connection db = new DonutDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			ResultSet rst = psm.executeQuery();
			while (rst.next()) {
				int id = rst.getInt("id");
				String name = rst.getString("name");
				int price = rst.getInt("price");
				String imgname = rst.getString("imgname");
				Donut donut = new Donut(id,name,price,imgname);
				list.add(donut);
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list;
		
	}
	public void insertOne(Donut donut) {
		System.out.println("set");
		String sql ="""
				INSERT INTO donuts
				(name,price,imgname)
				VALUES
				(?,?,?)
				;
				""";
		try(Connection db = new DonutDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setString(1,donut.getName());
			psm.setInt(2,donut.getPrice());
			psm.setString(3,donut.getImgname());
			System.out.print("ready");
			psm.executeUpdate();
			System.out.print("OK");
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public Donut findOne(int id) {
		Donut donut = new Donut();
		String sql = """
				SELECT 
				id,
				name,
				price,
				imgname
				FROM donuts
				WHERE id = ? 
				;
				""";
		try(Connection db = new DonutDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setInt(1,id);
			ResultSet rst = psm.executeQuery();
			if(rst.next()) {
				String name = rst.getString("name");
				int price = rst.getInt("price");
				String imgname = rst.getString("imgname");
				donut.setId(id);
				donut.setName(name);
				donut.setPrice(price);
				donut.setImgname(imgname);
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return donut;
	}
	public void updateOne(Donut donut) {
		String sql="""
				UPDATE donuts
				SET name = ?,
				price = ?,
				imgname = ?
				WHERE id = ?
				;
				""";
		try(Connection db = new DonutDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setString(1,donut.getName());
			psm.setInt(2,donut.getPrice());
			psm.setString(3,donut.getImgname());
			psm.setInt(4,donut.getId());
			psm.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void deleteOne(int id) {
		String sql = """
				DELETE
				FROM donuts
				WHERE id = ? 
				;
				""";
		try(Connection db = new DonutDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setInt(1,id);
			psm.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
