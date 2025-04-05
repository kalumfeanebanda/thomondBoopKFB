package gui;

import javax.swing.*;

public class createaccountForm {
    private JPanel rootPanel;
    private JRadioButton depositRadioButton;
    private JRadioButton currentRadioButton;
    private JTextField createacctxtfield;
    private JButton addNewAccountButton;


    public static void display() {
        JFrame frame = new JFrame("New Account");
        frame.setContentPane(new createaccountForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
