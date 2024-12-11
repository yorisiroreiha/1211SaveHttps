
package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CollectDataSouece {
	public Connection getConnection() throws NamingException, SQLException {
		InitialContext icx = new InitialContext();
		DataSource ds = (DataSource)icx.lookup("java:comp/env/jdbc/collection");
		
		return ds.getConnection();
	}
}