package nu.educom.MI6.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public Agent readOneAgentRow(String userNumber) {
        String sql = "SELECT * FROM agents WHERE userNumber = ?";
        Agent agent = null;
        PreparedStatement sqlPrep = null;
        ResultSet rs = null;

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

    public List<Agent> readManyAgentRows(List<String> userNumbers) {
        List<Agent> output = new ArrayList<Agent>();
        String sql = "SELECT * FROM AGENTS WHERE ";
        String extraSql = "";
        PreparedStatement sqlPrep = null;
        ResultSet rs = null;

        int len = userNumbers.size();
        for (int i = 0; i < len; i++) {
            if(i < len - 1) {
                extraSql += "userNumber = ? OR ";
            } else {
                extraSql += "userNumber = ?;";
            }
        }
        sql += extraSql;

        this.openConn();
        try {
            sqlPrep = conn.prepareStatement(sql);
            int i = 0;
            for (String userNumber : userNumbers) {
                i++;
                sqlPrep.setString(i, userNumber);
            }

            rs = sqlPrep.executeQuery();
            while(rs.next())
            {
                output.add(new Agent(rs));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return output;
    }

    public void createLoginRow(String userNumber, boolean success) {
        String sql = "INSERT INTO login (userNumber, success) VALUES (?, ?);";
        PreparedStatement sqlPrep = null;
        this.openConn();

        try {
            sqlPrep = conn.prepareStatement(sql);
            sqlPrep.setString(1, userNumber);
            sqlPrep.setBoolean(2, success);
            sqlPrep.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<LoginAttempt> getLastLoginAttempts(String userNumber) {
        List<LoginAttempt> output = new ArrayList<LoginAttempt>();
        String sql = "SELECT * FROM login WHERE userNumber = ? AND id > (SELECT id FROM login WHERE success = true ORDER BY id DESC LIMIT 1) ORDER BY id DESC;";
        PreparedStatement sqlPrep = null;
        ResultSet rs = null;

        this.openConn();

        try {
            sqlPrep = conn.prepareStatement(sql);
            sqlPrep.setString(1, userNumber);
            rs = sqlPrep.executeQuery();
            while(rs.next())
            {
                 output.add(new LoginAttempt(rs));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return output;

    }







}
