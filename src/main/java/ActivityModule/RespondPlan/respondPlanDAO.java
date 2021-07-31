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

public class respondPlanDAO {
    String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String IDQuery = "SELECT * from User WHERE email = ?";
    String AccQuery = "Update User_relations SET rel_status = 'accepted' WHERE ID1 = ? AND ID2 = ?";
    String IgnQuery = "DELETE FROM User_relations WHERE ID1 = ? AND ID2 = ?";
    int ReqedID;
    public void updateRel(String ReqedEmail,int ReqorID, String res)
    {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,username,password);
        
        PreparedStatement s1 = con.prepareStatement(IDQuery);
        s1.setString(1, ReqedEmail);
        
        ResultSet rs = s1.executeQuery();
        rs.next();
        ReqedID = rs.getInt("ID");
        
        if(res.equals("accepted"))
        {
            PreparedStatement s2 = con.prepareStatement(AccQuery);
            s2.setInt(1, ReqorID);
            s2.setInt(2, ReqedID);
            s2.executeUpdate();
            System.out.println(res + "and accepted");
        }
        else 
        {
            PreparedStatement s2 = con.prepareStatement(IgnQuery);
            s2.setInt(1, ReqorID);
            s2.setInt(2, ReqedID);
            s2.executeUpdate();
            System.out.println(res + "and ignored");
        }
        con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }    
    }
    
}
