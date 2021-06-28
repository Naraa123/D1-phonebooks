package phonebook;

import java.sql.*;

public class MySQLConnection {
	Connection conn = null;
	ResultSet rs = null;

	String username;// = "root";
	String password;// = "";
	String connUrl = "jdbc:mysql://localhost:3306/";
	String databaseName;

	// байгуулагч функц
	public MySQLConnection(String dbname, String uname, String pass) {
		databaseName = dbname;
		username = uname;
		password = pass;
	}


	public boolean dbConnect() {
		try {
			connUrl += databaseName + "?userUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(connUrl, username, password);

			if (conn != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public ResultSet getResult(String query) {
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(query);
			return rs;
		}

		catch (Exception e) {
			return rs = null;
		}
	}

	public void dbClose() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
