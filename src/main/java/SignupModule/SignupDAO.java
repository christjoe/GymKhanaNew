/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignupModule;

/**
 *
 * @author iamsm
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class SignupDAO {
    String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String sql1 = "SELECT * from User WHERE email = ?";
    String sql2 = "INSERT INTO User(Name,email,password) VALUES (?,?,?)";
    
    public boolean signupUser(String Name, String email, String pass)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection(url,username,password);
            
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setString(1,email);
            ResultSet rs = st1.executeQuery();
            
            if(rs.next())
            {
                return false;
            }
            PreparedStatement st2 = con.prepareStatement(sql2);
        //  Statement st = con.createStatement();
          
            st2.setString(1,Name);
            st2.setString(2,email);
            st2.setString(3,pass);
            st2.executeUpdate();
            con.close();
        } catch(Exception e){
            e.printStackTrace();
           
        }
         return true;
    }
}
