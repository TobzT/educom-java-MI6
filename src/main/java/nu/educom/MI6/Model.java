package nu.educom.MI6;


import nu.educom.MI6.data.Agent;
import nu.educom.MI6.data.Crud;

import java.util.*;

public class Model {

    private IPresenter control;

    private Crud crud;
    private List<String> blacklist = new ArrayList<String>();
//    private String secretSentence = "For ThE Royal QUEEN";

    private String userNumber;
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }


    public Model(Crud crud) {
        this.crud = crud;
    }
    public boolean validateLogin(String userNum, String password) {
        try {
            Integer.parseInt(userNum);
        } catch (Exception e) {
            errors.put("validation", "You can only enter numbers.");
            return false;
        }

        int numLen = userNum.length();
        int parsedUserNumber = Integer.parseInt(userNum);
        if (numLen > 3 || 1 > parsedUserNumber || 956 < parsedUserNumber) {
            errors.put("validation", "AGENT NUMBER INVALID");
            return false;
        }
        userNumber = formatUserNumber(userNum);

        if (blacklist.contains(userNumber)) {
            errors.put("validation", "BLACKLISTED");
            return false;
        }
        Agent agent = crud.readOneAgentRow(userNumber);
        String passwordFromDb = agent.getPassword();
        if(!password.equals(passwordFromDb)) {
            errors.put("validation", "ACCESS DENIED");
            blacklist.add(userNumber);
            return false;
        }
        return true;
    }

    private String formatUserNumber(String userNum) {
        int numLen = userNum.length();
        if (numLen < 3){
          int amountOfZeroes = 3 - numLen;
          userNum = repeatZeroes(amountOfZeroes) + userNum;
        }
        return userNum;
  }

  private void addToBlacklist(String userNum) {
    this.blacklist.add(userNum);
  }

  private String repeatZeroes(int count) {
        return new String(new char[count]).replace("\0", "0");
  }

}
