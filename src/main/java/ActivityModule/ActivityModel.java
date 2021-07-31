/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityModule;

/**
 *
 * @author iamsm
 */
public class ActivityModel {
    String a_name;
    String a_date;
    String a_time;
    public ActivityModel(String name,String date,String time)
    {
        a_name = name;
        a_date = date;
        a_time = time;
    }
    public String getName()
     {
          return a_name;
     }
     public String getDate()
     {
          return a_date;
     }
     public String getTime()
     {
          return a_time;
     }
}
