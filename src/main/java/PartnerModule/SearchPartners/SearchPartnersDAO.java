/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PartnerModule.SearchPartners;

/**
 *
 * @author iamsm
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
public class SearchPartnersDAO {
    String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String sql = "SELECT * FROM User ";
    UserModel[] Users = new UserModel[10];
    
    public UserModel[] getUsers()
    {
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next() && i<10)
            {
              Users[i] = new UserModel(rs.getString("Name"));
              i++;
            }            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Users;
    }
}
