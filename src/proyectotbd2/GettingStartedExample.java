
package proyectotbd2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GettingStartedExample {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        int resultSet;
        String databse = "jdbc:cubrid:localhost:30000:demo:::?charset=UTF-8";
        String dbauser = "dba";
        String password = "dbaAdmin123.,";
        
        System.out.println("Ingrese nombre de usuario: ");
        
        
        try {
            Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
            connection = DriverManager.getConnection(databse);
            
            //String sql = "SELECT * FROM users";
            String sql = 
                    "INSERT INTO DBA.users (name_user, lastname_user, email_user)" + 
                    "VALUES ('Angel','Torres','angel@angel-torres.com')";
            prepareStatement = connection.prepareStatement(sql);
            
            //prepareStatement.setString(1, "2004");
            resultSet = prepareStatement.executeUpdate();
            
            //while(resultSet.next()) {
            //   int host_year = resultSet.getInt("host_year");
            //   String nation_code = resultSet.getString("nation_code");
            //   int gold = resultSet.getInt("gold");
               
            //   System.out.println("host_year: " + host_year + ", nation_code: " + nation_code + ", gold: " + gold);
            //}
            //resultSet.close();
            prepareStatement.close();
            connection.close();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //if (resultSet != null) try { 
            //    resultSet.close(); } catch(SQLException ex) {}
            if (prepareStatement != null) try { 
                prepareStatement.close(); } catch(SQLException ex) {}
            if (connection != null) try { 
                connection.close(); } catch(SQLException ex) {}
        }
    }
}