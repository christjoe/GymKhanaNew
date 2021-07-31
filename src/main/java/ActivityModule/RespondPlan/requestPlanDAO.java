/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityModule.RespondPlan;

/**
 *
 * @author iamsm
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class requestPlanDAO {
    String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String sql1 = "SELECT * from User WHERE email = ?";
    String sql2 = "INSERT INTO User_relations VALUES (?,?,'requested')";
    int ReqorID;
    public void createRel(String ReqorEmail,int ReqedID)
    {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,username,password);
        
        PreparedStatement s1 = con.prepareStatement(sql1);
        s1.setString(1, ReqorEmail);
        
        ResultSet rs = s1.executeQuery();
        rs.next();
        ReqorID = rs.getInt("ID");
        
        PreparedStatement s2 = con.prepareStatement(sql2);
        s2.setInt(1, ReqorID);
        s2.setInt(2, ReqedID);
        s2.executeUpdate();
        
        con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }    
    }
    
}
