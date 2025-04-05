package gui;

import javax.swing.*;

public class changeair {
    private JPanel rootPanel;
    private JRadioButton depositRadioButton;
    private JRadioButton currentRadioButton;
    private JTextField oldAIRtxtField;
    private JTextField newAIRtxtField;
    private JButton changeAIRButton;


    public static void display() {
        JFrame frame = new JFrame("Change AIR");
        frame.setContentPane(new changeair().rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
