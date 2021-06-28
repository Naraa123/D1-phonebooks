package phonebook;

import java.util.*;
import java.sql.*;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MySQLConnection mysql = new MySQLConnection("phonebook", "root", "1016");
		Scanner scanner = new Scanner(System.in);
		
		if(mysql.dbConnect()) {
			System.out.println("Өгөгдлийн сантай амжилттай холбогдлоо.");
		} else {
			System.out.println("Амжилтгүй!!!");
		}
		
		
		// Schema дотор үүсгэсэн user нэртэй table -тэй ажиллах	
		// user хүснэгтэд хадгалсан username, password -той гараас оруулсан утга тулах эсэхийг шалгах
		
//		System.out.println("Та нэвтрэх нэрээ оруулна уу.");
//		String uname = scanner.next();
//		System.out.println("Та нууц үгээ оруулна уу.");
//		String pass = scanner.next();
//		
//		try {
//			// user хүснэгтээс бүх өгөгдлийг сонгох квери
//			String q = "select * from phonebooks";
//			// user хүснэгтээс ирсэн өгөгдлийг хадгалах
//			ResultSet result = mysql.getResult(q);
//			
//			// олон мөр өгөгдөл ирж магадгүй тул давталт ашиглана.
//			while(result.next()) {
//				//System.out.print (result.getString(1));
//				//System.out.print(result.getString(2) + "\n");
//				if(uname.equals(result.getString(1)) && pass.equals(result.getString(2))) {
//					System.out.println("Та амжилттай нэвтэрлээ.");
//					break;
//				}
//			}
//		} catch(SQLException e) {
//			System.out.println("SQL алдаа!!!");
//		} 
//		catch(Exception e) {
//			System.out.println("Нэвтэрч чадсангүй.");
//		}		
//		
//		// оролт, гаралттай ажиллаж дууссан бол хаах
//		scanner.close();
//		mysql.dbClose();	
		
	}
}