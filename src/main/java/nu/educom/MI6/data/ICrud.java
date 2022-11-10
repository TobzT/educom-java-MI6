package nu.educom.MI6.data;

import java.util.List;

public interface ICrud {
    public IAgent readOneAgentRow(String userNumber);

    public List<LoginAttempt> getLastLoginAttempts(String userNumber);


}
