package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Todo;

public class TodoDAO {
	public List<Todo> findAll(){
		List<Todo> list = new ArrayList<>();
		String sql ="""
			SELECT *
			FROM todos
			ORDER BY 
			importance DESC
			;
		""";
		try(Connection db = new TodoAppDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql);
			ResultSet rs = psm.executeQuery()
			){
				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					int importance = rs.getInt("importance");
					Todo todo = new Todo(id,title,importance);
					list.add(todo);
				}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertOne(Todo todo) {
		String sql ="""
				INSERT INTO todos
				(title,importance)
				VALUES
				(?,?)
				;
				""";
		try(Connection db = new TodoAppDataSource().getConnection();
		PreparedStatement psm = db.prepareStatement(sql)){
			psm.setString(1,todo.getTitle());
			psm.setInt(2,todo.getImportant());
			psm.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public Todo findOne(int id) {
	    String sql = """
	            SELECT *
	            FROM todos
	            WHERE id = ?
	            """;
	    try (Connection db = new TodoAppDataSource().getConnection();
	         PreparedStatement psm = db.prepareStatement(sql)) {
	        psm.setInt(1, id); // ここでパラメータを設定
	        try (ResultSet rs = psm.executeQuery()) { // クエリの実行
	            if (rs.next()) { // 単一のレコードを取得
	                int makeid = rs.getInt("id");
	                String title = rs.getString("title");
	                int importance = rs.getInt("importance");
	                return new Todo(makeid, title, importance); // 見つかったTodoを返す
	            }
	        }
	    } catch (SQLException | NamingException e) {
	        e.printStackTrace();
	    }
	    return null; // 見つからなかった場合はnullを返す
	}

	public void updateOne(Todo todo) {
		String sql ="""
				UPDATE todos
				SET title = ?,
				importance = ?
				WHERE id = ? 
				;
				""";
		try(Connection db = new TodoAppDataSource().getConnection();
			PreparedStatement psm = db.prepareStatement(sql)){
			psm.setString(1,todo.getTitle());
			psm.setInt(2,todo.getImportant());
			psm.setInt(3,todo.getId());
			psm.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public void deleteOne(int id) {
		String sql = """
				DELETE 
				FROM todos
				WHERE id = ?
				;
				""";
		try(Connection db = new TodoAppDataSource().getConnection();
				PreparedStatement psm = db.prepareStatement(sql)){
			psm.setInt(1,id);
			psm.executeUpdate();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
