package nu.educom.MI6;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Agent {

    private int id;
    private String userNumber;
    private boolean active;
    private boolean license_to_kill;
    private String license_to_kill_expire;

    public Agent(ResultSet set) {
        try {
            id = set.getInt("id");
            userNumber = set.getString("userNumber");
            active = set.getBoolean("active");
            license_to_kill = set.getBoolean("license_to_kill");
            license_to_kill_expire = set.getDate("license_to_kill_expire").toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void read() {
        System.out.println(String.format("id: %d", id));
        System.out.println(String.format("userNumber: %s", userNumber));
        System.out.println(String.format("active: %s", active));
        System.out.println(String.format("license_to_kill: %s", license_to_kill));
        System.out.println(String.format("license_to_kill_expire: %s", license_to_kill_expire));
    }
}
