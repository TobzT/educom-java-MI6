package nu.educom.MI6;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

  private static String secretSentencePassword = "For ThE Royal QUEEN";
  private static List<String> blacklist = new ArrayList<String>();
  public static void main(String[] args) {
    blacklist.add("0");
    while (true) {
      Scanner sc = new Scanner(System.in);
      System.out.println("What is your number?");
      String userNumber;
      try {
        userNumber = Integer.toString(sc.nextInt());
      } catch (Exception e) {
        System.out.println("You can only enter numbers.");
        continue;
      }
      int numLen = userNumber.length();

      if (numLen > 3) {
        System.out.println(String.format("Agent number %s is invalid. Try again.", userNumber));
        continue;
      } else if(1 > Integer.parseInt(userNumber) || 956 < Integer.parseInt(userNumber)) {
        System.out.println(String.format("Agent number %s is invalid. Try again.", userNumber));
        continue;
      }
      userNumber = formatUserNumber(userNumber);

      System.out.println("What is the secret sentence?");
      Scanner in = new Scanner(System.in);
      String secretSentence = in.nextLine();

      if (blacklist.contains(userNumber)) {
        System.out.println(String.format("Invalid secret sentence... Try again."));
        continue;
      }
      if(secretSentence.equals(secretSentencePassword)) {
        System.out.println(String.format("Logging in as %s...", userNumber));
        return;
      } else {
        System.out.println(String.format("Invalid secret sentence... Try again."));
        addToBlacklist(userNumber);
      }
    }
  }

  private static String formatUserNumber(String userNum) {
    int numLen = userNum.length();
    if (numLen < 3){
      int amountOfZeroes = 3 - numLen;
      userNum = repeat(amountOfZeroes, "0") + userNum;
    }
    return userNum;
  }

//  private static List<String> addToBlacklist(List<String> blacklist, String userNum) {
//    blacklist.add(userNum);
//    return blacklist;
//  }

  private static void addToBlacklist(String userNum) {
    blacklist.add(userNum);
  }

  private static String repeat(int count, String with) {
    return new String(new char[count]).replace("\0", with);
  }
}