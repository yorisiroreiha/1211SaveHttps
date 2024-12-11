package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LunchAppDataSource {
	public Connection getConnection() throws NamingException, SQLException {
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/lunchapp");
		return ds.getConnection();
	}
}