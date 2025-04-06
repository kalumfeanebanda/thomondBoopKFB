package gui;

import model.Account;
import model.CurrentAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class editOverdraft {
    private JTextField enterAccIdtxtField;
    private JTextField oldLimittxtField;
    private JTextField newOverLimit;
    private JButton changeOverdraftLimitButton;
    private JPanel rootPanel;
    private JLabel oldOverLimLabel;
    private JLabel newOverLimLabel;


    private CurrentAccount chosenAccount;


    public editOverdraft() {
        enterAccIdtxtField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = enterAccIdtxtField.getText();

                try {
                    int id = Integer.parseInt(input);
                    chosenAccount = null;

                    for (Account ac : proBank.thomondAccounts){
                        if (ac.getId() == id && ac instanceof CurrentAccount) {
                            chosenAccount = (CurrentAccount) ac;
                            break;
                        }
                    }

                    if (chosenAccount == null){
                        JOptionPane.showMessageDialog(rootPanel,"No current Account found with this ID",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    oldLimittxtField.setVisible(true);
                    oldOverLimLabel.setVisible(true);
                    newOverLimit.setVisible(true);
                    newOverLimLabel.setVisible(true);
                    changeOverdraftLimitButton.setVisible(true);

                    oldLimittxtField.setText(String.format("%.2f", chosenAccount.getOverLim()));


                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Please enter a valid Account ID",
                            "Error",JOptionPane.ERROR_MESSAGE);
                }



            }
        });
        changeOverdraftLimitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newLim = newOverLimit.getText();

                try {
                    double newLimit = Double.parseDouble(newLim);

                    if (newLimit < 0){
                        JOptionPane.showMessageDialog(rootPanel,
                                "Overdraft cannot be negative","Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    chosenAccount.setOverdraftlim(newLimit);
                    JOptionPane.showMessageDialog(rootPanel,
                            "Overdraft Limit changed successfully");

                    newOverLimit.setText("");
                    oldLimittxtField.setText(String.format("%.2f", chosenAccount.getOverLim()));



                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Enter a valid digit for the new limit",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    public static void display() {
        JFrame frame = new JFrame("Edit Overdraft");
        frame.setContentPane(new editOverdraft().rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
