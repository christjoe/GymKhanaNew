/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityModule.PlanActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class sendPlanDAO {
     String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String IDQuery = "SELECT * from User WHERE email = ?";
    String ActQuery = "INSERT INTO Activities (ID1,ID2,A_Name,A_Date,A_Time,A_Status) VALUES (?,?,?,?,?,'planning')";
    int ReqorID;
    
    public void createAct(String ReqorMail,UserModel planWith,ActivityModel Activity)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
        
        PreparedStatement s1 = con.prepareStatement(IDQuery);
        s1.setString(1, ReqorMail);
        
        ResultSet rs = s1.executeQuery();
        rs.next();
        ReqorID = rs.getInt("ID");
        
        PreparedStatement s2 = con.prepareStatement(ActQuery);
        s2.setInt(1,ReqorID);
        s2.setInt(2,planWith.getID());
        s2.setString(3, Activity.getName());
        s2.setString(4, Activity.getDate());
        s2.setString(5, Activity.getTime());
        s2.executeUpdate();
        
        
        con.close();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
