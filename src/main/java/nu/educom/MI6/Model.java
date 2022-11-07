package nu.educom.MI6;


import nu.educom.MI6.data.Agent;
import nu.educom.MI6.data.Crud;
import nu.educom.MI6.data.LoginAttempt;

import java.time.LocalDateTime;
import java.util.*;
import java.time.format.DateTimeFormatter;

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
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    public Model(Crud crud) {
        this.crud = crud;
    }
    public boolean validateLogin(String userNum, String password) {
        try {
            Integer.parseInt(userNum);
        } catch (Exception e) {
            errors.put("validation", "ONLY NUMBERS");
            return false;
        }

        int numLen = userNum.length();
        int parsedUserNumber = Integer.parseInt(userNum);
        if (numLen > 3 || 1 > parsedUserNumber || 956 < parsedUserNumber) {
            errors.put("validation", "AGENT NUMBER INVALID");
            userNumber = formatUserNumber(userNum);
            crud.createLoginRow(userNumber, false);
            return false;
        }
        userNumber = formatUserNumber(userNum);

        List<LoginAttempt> rows = crud.getLastLoginAttempts(userNumber);
        int potTimeout = 0;
        String lastDate = null;
        try {
            lastDate = rows.get(0).getDate();

        } catch (Exception e) {
            System.out.println(e);
        }
        int size = rows.size();
        if(size != 0) {
            potTimeout = (int)Math.pow(2, size) / 2;
        }

        if(!this.validateTime(lastDate, potTimeout)) {
            errors.put("validation", "TIMED OUT");
//            crud.createLoginRow(userNumber, false);
            return false;
        }
        if (blacklist.contains(userNumber)) {
            errors.put("validation", "BLACKLISTED");
            return false;
        }
        Agent agent = crud.readOneAgentRow(userNumber);
        String passwordFromDb = agent.getPassword();
        if(!password.equals(passwordFromDb)) {
            errors.put("validation", "ACCESS DENIED");
            crud.createLoginRow(userNumber, false);
            blacklist.add(userNumber);
            return false;
        }

        if(!agent.getActive()) {
            errors.put("validation", "NOT ACTIVE");
            crud.createLoginRow(userNumber, false);
            blacklist.add(userNumber);
            return false;
        }
        crud.createLoginRow(userNumber, true);
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

  private boolean validateTime(String lastDate,int potTimeout) {
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);
        System.out.println(String.format("Potential timeout: %s", potTimeout));
        if(lastDate == null) {
            return true;
        }

        int lastDay = Integer.parseInt(lastDate.substring(8, 10));
        int currentDay = Integer.parseInt(currentTime.substring(8, 10));
        int lastHours = Integer.parseInt(lastDate.substring(11, 13));
        int currentHours = Integer.parseInt(currentTime.substring(11, 13));
        int lastMinutes = Integer.parseInt(lastDate.substring(14, 16));
        int currentMinutes = Integer.parseInt(currentTime.substring(14, 16));
        int newMinutes = lastMinutes + potTimeout;
        while (newMinutes > 60) {
            newMinutes -= 60;
            lastHours += 1;
            if(lastHours > 24) {
                lastHours -= 24;
                lastDay += 1;
            }
        }
        if(lastDay <= currentDay) {
            if(lastHours <= currentHours) {
                if(newMinutes <= currentMinutes) {

                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }


        return true;
  }
  private void addToBlacklist(String userNum) {
    this.blacklist.add(userNum);
  }

  private String repeatZeroes(int count) {
        return new String(new char[count]).replace("\0", "0");
  }

}
