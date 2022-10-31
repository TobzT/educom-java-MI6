package nu.educom.MI6;

import java.util.*;
import javax.swing.*;

public class Main {

  private static String secretSentencePassword = "For ThE Royal QUEEN";
  private static List<String> blacklist = new ArrayList<String>();
  public static void main(String[] args) {
    blacklist.add("0");
    JFrame frame = new JFrame("InputDialog Example #1");
    while (true) {
      String userNumber;
      try {
        userNumber = JOptionPane.showInputDialog(frame, "What is your number?");
        if (userNumber != null) {
          Integer.parseInt(userNumber);
        }
      } catch (Exception e) {
        String out = "You can only enter numbers.";
        JOptionPane.showMessageDialog(frame, out);
        continue;
      }
      int numLen = userNumber.length();
      int parsedUserNumber = Integer.parseInt(userNumber);
      if (numLen > 3 || 1 > parsedUserNumber || 956 < parsedUserNumber) {
        String out = String.format("Agent number %s is invalid. Try again.", userNumber);
        JOptionPane.showMessageDialog(frame, out);
        continue;
      }
      userNumber = formatUserNumber(userNumber);

      String secretSentence = JOptionPane.showInputDialog(frame, "What is the secret sentence?");

      if (blacklist.contains(userNumber)) {
        String out = String.format("ACCESS DENIED");
        JOptionPane.showMessageDialog(frame, out);
        continue;
      }
      if(secretSentence.equals(secretSentencePassword)) {
        String out = String.format("Logging in as %s...", userNumber);
        JOptionPane.showMessageDialog(frame, out);
      } else {
        String out = String.format("ACCESS DENIED");
        addToBlacklist(userNumber);
        JOptionPane.showMessageDialog(frame, out);
      }
    }
  }

  private static String formatUserNumber(String userNum) {
    int numLen = userNum.length();
    if (numLen < 3){
      int amountOfZeroes = 3 - numLen;
      userNum = repeatZeroes(amountOfZeroes) + userNum;
    }
    return userNum;
  }

  private static void addToBlacklist(String userNum) {
    blacklist.add(userNum);
  }

  private static String repeatZeroes(int count) {
    return new String(new char[count]).replace("\0", "0");
  }
}