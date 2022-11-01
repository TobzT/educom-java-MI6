package nu.educom.MI6;


public class Main {

  public static void main(String[] args){
    View view = new View();
    Presenter presentor = new Presenter(view);
    presentor.displayLogin();
  }


//  private static String secretSentencePassword = "For ThE Royal QUEEN";
//  private static List<String> blacklist = new ArrayList<String>();
//  public static void main(String[] args) {
//    blacklist.add("0");
//
//    // Define frame, label and panels
//    JFrame frame = new JFrame("Super Secret Login Tool");
//    JLabel numberLabel = new JLabel("Service number:", JLabel.CENTER);
//    JLabel pwLabel = new JLabel("Secret sentence:", JLabel.CENTER);
//    JPanel panel1 = new JPanel();
//    JPanel panel2 = new JPanel();
//
//    // configure panel 1
//    BoxLayout boxlayout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
//    panel1.setLayout(boxlayout1);
//    panel1.setBorder(new EmptyBorder(new Insets(45, 30, 45, 30)));
//    panel1.setBackground(Color.RED);
//
//
//    // configure panel 2
//    BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
//    panel2.setLayout(boxlayout2);
//    panel2.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));
//    panel2.setBackground(Color.GREEN);
//
//    // Define new components
//    JButton button1 = new JButton("Submit");
//    JFormattedTextField textField = new JFormattedTextField();
//    JPasswordField pwField = new JPasswordField();
//
//    // Add components to the frame
//    panel1.add(numberLabel);
//    panel1.add(textField);
//    panel1.add(pwLabel);
//    panel1.add(pwField);
//    panel2.add(button1);
//
//    // Add the label and panel to the frame
//    frame.setLayout(new GridLayout(2, 1));
////    frame.add(label);
//    frame.add(panel1);
//    frame.add(panel2);
//
//    // Settings for the frame
//    frame.pack();
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setVisible(true);
//
//
//    System.out.println(textField.getText());
//    while (true) {
//      String userNumber;
//      try {
//        userNumber = JOptionPane.showInputDialog(frame, "What is your number?");
//        if (userNumber == null) {
//          break;
//        }
//        Integer.parseInt(userNumber);
//      } catch (Exception e) {
//        String out = "You can only enter numbers.";
//        JOptionPane.showMessageDialog(frame, out);
//        continue;
//      }
//      int numLen = userNumber.length();
//      int parsedUserNumber = Integer.parseInt(userNumber);
//      if (numLen > 3 || 1 > parsedUserNumber || 956 < parsedUserNumber) {
//        String out = String.format("Agent number %s is invalid. Try again.", userNumber);
//        JOptionPane.showMessageDialog(frame, out);
//        continue;
//      }
//      userNumber = formatUserNumber(userNumber);
//
//      String secretSentence = JOptionPane.showInputDialog(frame, "What is the secret sentence?");
//      if(secretSentence == null) {
//        break;
//      }
//
//      if (blacklist.contains(userNumber)) {
//        String out = "ACCESS DENIED";
//        JOptionPane.showMessageDialog(frame, out);
//        continue;
//      }
//      if(secretSentence.equals(secretSentencePassword)) {
//        String out = String.format("Logging in as %s...", userNumber);
//        JOptionPane.showMessageDialog(frame, out);
//      } else {
//        String out = "ACCESS DENIED";
//        addToBlacklist(userNumber);
//        JOptionPane.showMessageDialog(frame, out);
//      }
//    }
//  }
//
//  private static String formatUserNumber(String userNum) {
//    int numLen = userNum.length();
//    if (numLen < 3){
//      int amountOfZeroes = 3 - numLen;
//      userNum = repeatZeroes(amountOfZeroes) + userNum;
//    }
//    return userNum;
//  }
//
//  private static void addToBlacklist(String userNum) {
//    blacklist.add(userNum);
//  }
//
//  private static String repeatZeroes(int count) {
//    return new String(new char[count]).replace("\0", "0");
//  }
}