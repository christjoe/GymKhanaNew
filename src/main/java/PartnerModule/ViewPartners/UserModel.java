package PartnerModule.ViewPartners;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iamsm
 */
public class UserModel {
    int ID;
    String name;
    UserModel(int id,String uname)
    {
        ID = id;
        name = uname;
    }
    public String getName()
     {
          return name;
     }
     public int getID()
     {
          return ID;
     }
}
