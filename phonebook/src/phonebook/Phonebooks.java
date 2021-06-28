package phonebook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Phonebooks {

	private MySQLConnection mysql = new MySQLConnection("phonebook", "root", "1016");
    private ResultSet set = null;

    public Phonebooks() {
      mysql.dbConnect();
    }

    public ResultSet getProductInfo() {
      try {
        String query = "select * from phonebooks";
        set = mysql.getResult(query);
        return set;
      } catch (Exception e) {
        return null;
      }
    }

    public boolean updatePhonebooks(String name, String phone, String mobile, String nickname, String address, String email, String organization) {
      boolean updated = false;

      try {
        String query = "UPDATE phonebooks SET name = ?, phone = ?, mobile = ?, nickname = ?, address = ?, email = ?, organization = ? WHERE name = '" + name + "";
        PreparedStatement pst = mysql.getConnection().prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, phone);
        pst.setString(3, mobile);
        pst.setString(4, nickname);
        pst.setString(5, address);
        pst.setString(6, email);
        pst.setString(7, organization);
        pst.executeUpdate();
        updated = true;
      } catch(Exception e) {
        updated = false;
      }
      return updated;
    }

    public boolean insertPhonebooks(String name, String phone, String mobile, String nickname, String address, String email, String organization) {
      boolean inserted = false;

      try {
        String query = "INSERT INTO phonebooks (name, phone, mobile, nickname, address, email, organization) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = mysql.getConnection().prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, phone);
        pst.setString(3, mobile);
        pst.setString(4, nickname);
        pst.setString(5, address);
        pst.setString(6, email);
        pst.setString(7, organization);
        pst.execute();
        inserted = true;

      } catch(Exception e) {
        e.printStackTrace();
      }
      return inserted;
    }
//
    public boolean deletePhonebooks(int code) {
      boolean deleted = false;
      try {
        String query = "DELETE FROM `products` WHERE `product_id` = '" + code + "'";
        PreparedStatement pst = mysql.getConnection().prepareStatement(query);
        pst.execute();

        deleted = true;

      } catch(Exception e) {
        e.printStackTrace();
      }
      return deleted;
    }

  }