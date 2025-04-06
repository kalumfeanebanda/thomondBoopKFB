package gui;

import model.CurrentAccount;
import model.DepositAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class changeair {
    private JPanel rootPanel;
    private JRadioButton depositRadioButton;
    private JRadioButton currentRadioButton;
    private JTextField oldAIRtxtField;
    private JTextField newAIRtxtField;
    private JButton changeAIRButton;


    public changeair() {

        newAIRtxtField.setEditable(false);


        depositRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oldAIRtxtField.setText(String.format("%.3f", DepositAccount.getAIR()));
                newAIRtxtField.setEditable(true);
            }
        });


        currentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oldAIRtxtField.setText(String.format("%.3f", CurrentAccount.getAIR()));
                newAIRtxtField.setEditable(true);
            }
        });
        changeAIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double newAIR = Double.parseDouble(newAIRtxtField.getText());

                    if (newAIR < 0){
                        JOptionPane.showMessageDialog(rootPanel,"Enter on positive values"
                        ,"Invald", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (depositRadioButton.isSelected()){
                        DepositAccount.setAIR(newAIR);
                        JOptionPane.showMessageDialog(rootPanel,"Deposit Account AIR updated");
                        oldAIRtxtField.setText(String.format("%.3f",DepositAccount.getAIR()));
                        newAIRtxtField.setText("");

                    } else if (currentRadioButton.isSelected()){
                        CurrentAccount.setAIR(newAIR);
                        JOptionPane.showMessageDialog(rootPanel,"Current Account AIR updated");
                        oldAIRtxtField.setText(String.format("%.3f", CurrentAccount.getAIR()));
                        newAIRtxtField.setText("");

                    } else {
                        JOptionPane.showMessageDialog(rootPanel,"Please select an account type"
                        ,"Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel,"Please input a valid number",
                            "Error",JOptionPane.ERROR_MESSAGE);
                }





            }
        });
    }

    public static void display() {
        JFrame frame = new JFrame("Change AIR");
        frame.setContentPane(new changeair().rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
