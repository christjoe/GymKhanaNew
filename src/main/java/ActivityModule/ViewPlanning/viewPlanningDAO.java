/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityModule.ViewPlanning;

/**
 *
 * @author iamsm
 */
import ActivityModule.ActivityModel;
import ActivityModule.UserModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class viewPlanningDAO {
    String url = "jdbc:mysql://localhost:3307/Gymkhana?autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "sqlrocks123";
    String IDQuery = "SELECT * from User WHERE email = ?";
    String UPlanSentQuery = "select ID,Name FROM User,Activities WHERE A_Status = 'planning' AND ID = ID2 AND ID1 =?";
    String UPlanRecQuery = "select ID,Name FROM User,Activities WHERE A_Status = 'planning' AND ID = ID1 AND ID2 =?";
    String APlanSentQuery = "SELECT A_Name,DATE_FORMAT(A_Date,'%d %m %Y') AS A_Date,DATE_FORMAT(A_Time,'%H %i') AS A_Time FROM Activities WHERE ID1 = ?";
    String APlanRecQuery = "SELECT A_Name,DATE_FORMAT(A_Date,'%d %m %Y') AS A_Date,DATE_FORMAT(A_Time,'%H %i') AS A_Time FROM Activities WHERE ID2 = ?";    
    UserModel[] Users;
    ActivityModel[] Activity;
    int UserID;
    private void getIDFMAIL(String UserEmail)
    {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,username,password);
        
        PreparedStatement s1 = con.prepareStatement(IDQuery);
        s1.setString(1, UserEmail);
        
        ResultSet rs = s1.executeQuery();
        rs.next();
        UserID = rs.getInt("ID");
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public UserModel[] getUPlanRec(String UserEmail)
    {
        int ListLength = 0,i=0;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,username,password);
        
        getIDFMAIL(UserEmail);
        
        System.out.println(UserID);
        
        PreparedStatement s2 = con.prepareStatement(UPlanRecQuery,ResultSet.TYPE_SCROLL_SENSITIVE);
        s2.setInt(1,UserID);
        ResultSet rs = s2.executeQuery();
        
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
    public UserModel[] getUPlanSent(String UserEmail)
    {
        int ListLength = 0,i=0;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,username,password);
        
        getIDFMAIL(UserEmail);
        
        System.out.println(UserID);
        
        PreparedStatement s2 = con.prepareStatement(UPlanSentQuery,ResultSet.TYPE_SCROLL_SENSITIVE);
        s2.setInt(1,UserID);
        ResultSet rs = s2.executeQuery();
        
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
    public ActivityModel[] getAPlanRec(String UserEmail)
    {
        int ListLength = 0,i=0;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,username,password);
        
        getIDFMAIL(UserEmail);
        
        System.out.println(UserID);
        
        PreparedStatement s2 = con.prepareStatement(APlanRecQuery,ResultSet.TYPE_SCROLL_SENSITIVE);
        s2.setInt(1,UserID);
        ResultSet rs = s2.executeQuery();
        
        for(;rs.next();ListLength++);
        Activity = new ActivityModel[ListLength];
        
        rs.beforeFirst();
        while(rs.next() && i<ListLength)
            {
              Activity[i] = new ActivityModel(rs.getString("A_Name"),rs.getString("A_Date"),rs.getString("A_Time"));
              i++;
            }
        con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        } 
        return Activity;
    }
        public ActivityModel[] getAPlanSent(String UserEmail)
    {
        int ListLength = 0,i=0;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,username,password);
        
        getIDFMAIL(UserEmail);
        
        System.out.println(UserID);
        
        PreparedStatement s2 = con.prepareStatement(APlanSentQuery,ResultSet.TYPE_SCROLL_SENSITIVE);
        s2.setInt(1,UserID);
        ResultSet rs = s2.executeQuery();
        
        for(;rs.next();ListLength++);
        Activity = new ActivityModel[ListLength];
        
        rs.beforeFirst();
        while(rs.next() && i<ListLength)
            {
              Activity[i] = new ActivityModel(rs.getString("A_Name"),rs.getString("A_Date"),rs.getString("A_Time"));
              i++;
            }
        con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        } 
        return Activity;
    }
}

