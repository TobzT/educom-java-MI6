package nu.educom.MI6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.*;
public class Crud {

    private String connString = "jdbc:mysql://127.0.0.1/mi6";
    private String userName = "mi6_user";
    private String password = "EducomCheeta";

    private Connection conn;


    private Connection openConn() {
        try {
            conn = DriverManager.getConnection(connString, userName, password);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void closeConn() {
        try {
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    private PreparedStatement prepareStatement(String sql) {
//
//    }

    public Agent readOneRow(String sql, String userNumber) {
        PreparedStatement sqlPrep = null;
        ResultSet rs = null;
        Agent agent = null;
        this.openConn();

        try {
            sqlPrep = conn.prepareStatement(sql);
            sqlPrep.setString(1, userNumber);
            rs = sqlPrep.executeQuery();
            if(rs.next())
            {
                agent = new Agent(rs);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return agent;
    }





}
