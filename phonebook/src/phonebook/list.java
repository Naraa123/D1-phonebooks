package phonebook;

import java.sql.ResultSet;
public class list {
	MySQLConnection mysql;
	
	public boolean login(String u, String p) {
		mysql = new MySQLConnection("phonebook", "root", "1016");
		
		if(mysql.dbConnect()) {
			try {
				String query = "select * from phonebooks";
				ResultSet set = mysql.getResult(query);
				
				while(set.next()) {
					if(u.equals(set.getString(1)) && p.equals(set.getString(2)))
						return true;
				}
			}	catch(Exception e) {
				return false;
			}
		}
		return false;
	}
}
