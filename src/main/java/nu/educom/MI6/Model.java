package nu.educom.MI6;


import java.util.List;

public class Model {

    private IPresenter control;
    private List<String> blacklist;
    private String secretSentence = "For ThE Royal QUEEN";

    public boolean validateLogin(String userNum, String SecretSentence) {


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
