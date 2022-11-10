package nu.educom.MI6.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Agent implements IAgent{

    private int id;
    private String userNumber;
    private String password;
    private boolean active;
    private boolean license_to_kill;
    private String license_to_kill_expire;

    public Agent(ResultSet set) {
        try {
            id = set.getInt("id");
            password = set.getString("pw");
            userNumber = set.getString("userNumber");
            active = set.getBoolean("active");
            license_to_kill = set.getBoolean("license_to_kill");
            try {
                license_to_kill_expire = set.getDate("license_to_kill_expire").toString();
            } catch (NullPointerException e) {
                license_to_kill_expire = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getPassword() {
        return password;
    }

    public void read() {
        System.out.println(String.format("id: %d", id));
        System.out.println(String.format("userNumber: %s", userNumber));
        System.out.println(String.format("password: %s", password));
        System.out.println(String.format("active: %s", active));
        System.out.println(String.format("license_to_kill: %s", license_to_kill));
        System.out.println(String.format("license_to_kill_expire: %s \r\n", license_to_kill_expire));
    }

    public String getDetails() {
        if(!license_to_kill) {
            return "NO LICENSE TO KILL";
        } else {
            String output = String.format("ACTIVE LICENSE TO KILL EXPIRES ON %s", license_to_kill_expire);
            return output;
        }
    }

    public boolean getActive() {
        return active;
    }
}
