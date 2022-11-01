package nu.educom.MI6;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View {
    private IPresenter control;
    private LoginHandler loginHandler;
    private BackHandler backHandler;
    private JFrame frame;
    private JLabel numberLabel;
    private JLabel pwLabel;

    private JLabel errLabel;
    private JFormattedTextField textField;
    private  JPasswordField pwField;
    private JPanel panel1;
    private JPanel panel2;

    private JPanel errPanel;

    private JButton loginButton;

    private JButton backButton;

    public View() {
        // define frame
        frame = new JFrame("Super Secret Login Tool");

    }
    public void setControlInterface(IPresenter control) {

        this.control = control;

    }

    public void setLoginHandler() {
        loginHandler = new LoginHandler(control);
    }

    public void setBackHandler() {
        backHandler = new BackHandler(control);
    }
    private void displayText(String errMsg, Color color){
        frame.getContentPane().removeAll();
        frame.repaint();

        errLabel = new JLabel(errMsg, JLabel.CENTER);
        errLabel.setForeground(color);
        errPanel = new JPanel();

        panel2 = new JPanel();

        backButton = new JButton("Back");
        backButton.addActionListener(backHandler);

        // configure panel2
        BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel2.setLayout(boxlayout2);
        panel2.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));


        // configure errPanel
        BoxLayout boxlayout = new BoxLayout(errPanel, BoxLayout.Y_AXIS);
        errPanel.setLayout(boxlayout);
        errPanel.setBorder(new EmptyBorder(new Insets(45, 30, 45, 30)));

        errPanel.add(errLabel);
        panel2.add(backButton);

        frame.setLayout(new GridLayout(2, 1));
        frame.add(errPanel);
        frame.add(panel2);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void displayError(String errMsg) {
        displayText(errMsg, Color.RED);
    }

    public void displaySuccess(String msg) {
        displayText(msg, Color.GREEN);
    }
    public void displayLogin() {
        frame.getContentPane().removeAll();
        frame.repaint();

        // Define label and panels
        numberLabel = new JLabel("Service number:", JLabel.CENTER);
        pwLabel = new JLabel("Secret sentence:", JLabel.CENTER);
        panel1 = new JPanel();
        panel2 = new JPanel();

        // configure panel 1
        BoxLayout boxlayout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(boxlayout1);
        panel1.setBorder(new EmptyBorder(new Insets(45, 30, 45, 30)));
//        panel1.setBackground(Color.RED);

        // configure panel 2
        BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel2.setLayout(boxlayout2);
        panel2.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));
//        panel2.setBackground(Color.GREEN);

        // Define new components
        loginButton = new JButton("Submit");
        loginButton.addActionListener(loginHandler);

        textField = new JFormattedTextField();
        pwField = new JPasswordField();

        // Add components to the panels
        panel1.add(numberLabel);
        panel1.add(textField);
        panel1.add(pwLabel);
        panel1.add(pwField);
        panel2.add(loginButton);

        // Add the panels to the frame
        frame.setLayout(new GridLayout(2, 1));
        frame.add(panel1);
        frame.add(panel2);

        // Settings for the frame
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    public String getUserNumber() {
        return textField.getText();
    }

    public String getSecretSentence() {
        return new String(pwField.getPassword());
    }



}
