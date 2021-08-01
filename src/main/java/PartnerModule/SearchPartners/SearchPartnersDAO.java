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
import java.sql.PreparedStatement;
import java.sql.Statement;
public class SearchPartnersDAO {
    String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String sql = "SELECT * FROM User where email != ? ";
    UserModel[] Users = new UserModel[10];
   public UserModel[] getUsers(String UserEmail)
    {
        int ListLength = 0,i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE);
            st.setString(1, UserEmail);
            ResultSet rs = st.executeQuery();
            
            for(;rs.next();ListLength++);
        Users = new UserModel[ListLength];
        
        rs.beforeFirst();
            while(rs.next() && i<ListLength)
            {
              Users[i] = new UserModel(rs.getInt("ID"),rs.getString("Name"));
              i++;
            }            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Users;
    }
}
