package nu.educom.MI6.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAttempt {
     private int id;
     private String userNumber;
     private String date;
     private boolean success;

     public LoginAttempt(ResultSet rs) {
          try {
               id = rs.getInt("id");
               userNumber  = rs.getString("userNumber");
               date = rs.getString("time").replace('-', '/');
               success = rs.getBoolean("success");
          } catch (SQLException e) {
               System.out.println(e.getMessage());
          }
     }

     public int getId() {
          return id;
     }

     public String getUserNumber() {
          return userNumber;
     }

     public String getDate() {
          return date;
     }

     public boolean getSuccess() {
          return success;
     }

     public void read() {
          System.out.println(String.format("id: %d", id));
          System.out.println(String.format("userNumber: %s", userNumber));
          System.out.println(String.format("date: %s", date));
          System.out.println(String.format("success: %s \n\r", success));
     }
}
