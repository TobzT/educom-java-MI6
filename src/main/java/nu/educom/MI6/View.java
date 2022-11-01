package nu.educom.MI6;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View {
    private IPresenter control;
    private JFrame frame;
    private JLabel numberLabel;
    private JLabel pwLabel;
    private JFormattedTextField textField;
    private  JPasswordField pwField;
    private JPanel panel1;
    private JPanel panel2;

    public View() {
        frame = new JFrame("Super Secret Login Tool");
    }
    public void setControlInterface(IPresenter control) {
        this.control = control;
    }

    public void displayLogin() {
        // Define frame, label and panels
        numberLabel = new JLabel("Service number:", JLabel.CENTER);
        pwLabel = new JLabel("Secret sentence:", JLabel.CENTER);
        panel1 = new JPanel();
        panel2 = new JPanel();

        // configure panel 1
        BoxLayout boxlayout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(boxlayout1);
        panel1.setBorder(new EmptyBorder(new Insets(45, 30, 45, 30)));
        panel1.setBackground(Color.RED);

        // configure panel 2
        BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel2.setLayout(boxlayout2);
        panel2.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));
        panel2.setBackground(Color.GREEN);

        // Define new components
        JButton button1 = new JButton("Submit");
        textField = new JFormattedTextField();
        pwField = new JPasswordField();

        // Add components to the frame
        panel1.add(numberLabel);
        panel1.add(textField);
        panel1.add(pwLabel);
        panel1.add(pwField);
        panel2.add(button1);

        // Add the label and panel to the frame
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
