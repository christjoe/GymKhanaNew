/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PartnerModule.RequestPartners;

/**
 *
 * @author iamsm
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class viewRequestsDAO {
    String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String IDQuery = "SELECT * from User WHERE email = ?";
    String reqQuery = "select ID,Name FROM User,User_relations WHERE rel_status = 'requested' AND ID = ID1 AND ID2 =?; ";
    UserModel[] Users;
    int UserID;
    public UserModel[] getRequests(String UserEmail)
    {
        int ListLength = 0,i=0;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,username,password);
        
        PreparedStatement s1 = con.prepareStatement(IDQuery);
        s1.setString(1, UserEmail);
        
        ResultSet rs = s1.executeQuery();
        rs.next();
        UserID = rs.getInt("ID");
        System.out.println(UserID);
        
        PreparedStatement s2 = con.prepareStatement(reqQuery,ResultSet.TYPE_SCROLL_SENSITIVE);
        s2.setInt(1,UserID);
        rs = s2.executeQuery();
        
        for(;rs.next();ListLength++);
        Users = new UserModel[ListLength];
        
        rs.beforeFirst();
        while(rs.next() && i<ListLength)
            {
              Users[i] = new UserModel(rs.getInt("ID"),rs.getString("Name"));
              i++;
            }
        con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        } 
        return Users;
    }
}
