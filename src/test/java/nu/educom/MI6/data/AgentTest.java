package nu.educom.MI6.data;

import java.sql.ResultSet;

public class AgentTest implements IAgent {

    public String getPassword() {
        return "adminadmin";
    }

    public String getDetails() {
        return "NO LICENSE TO KILL";
    }

    public boolean getActive() {
        return true;
    }
}
