package gui;

import javax.swing.*;

public class editOverdraft {
    private JTextField enterAccIdtxtField;
    private JTextField oldLimittxtField;
    private JTextField newOverLimit;
    private JButton changeOverdraftLimitButton;
    private JPanel rootPanel;


    public static void display() {
        JFrame frame = new JFrame("Edit Overdraft");
        frame.setContentPane(new editOverdraft().rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
