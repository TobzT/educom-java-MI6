package nu.educom.MI6.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CrudTest implements ICrud {

    public IAgent readOneAgentRow(String userNumber) {
        return new AgentTest();
    }

    public List<LoginAttempt> getLastLoginAttempts(String userNumber) {
        return new ArrayList<LoginAttempt>();
    }
}
