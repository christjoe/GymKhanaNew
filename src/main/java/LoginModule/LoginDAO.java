/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginModule;

/**
 *
 * @author iamsm
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author iamsm
 */
public class LoginDAO {
    String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String sql = "SELECT * FROM User WHERE email = ? AND password = ?";
 //   String sql = "SELECT * FROM users";
//    String uname0 = "tusk";
//    String pass0 = "tusk";
    boolean flag = false;
    public boolean checkCred(String email, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql);
        //  Statement st = con.createStatement();
          
          st.setString(1,email);
            st.setString(2,pass);
            ResultSet rs = st.executeQuery();
        //    System.out.println(rs);
            flag = rs.next();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}

