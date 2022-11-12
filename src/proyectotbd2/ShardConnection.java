
package proyectotbd2;

import cubrid.jdbc.driver.CUBRIDConnection;

import java.sql.*;

public class ShardConnection {
	static  {
		try {
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static CUBRIDConnection getCUBRIDConnection(String dbuser, String password) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
                                "jdbc:cubrid:localhost:30000:testing01:::?charset=UTF-8", 
                                dbuser, password);
			System.out.println("Connected!");
		} catch ( Exception e ) {
			System.err.println("Error: " + e.getMessage());
		}

		return (CUBRIDConnection)conn;
	}
}