package gui;

import model.CurrentAccount;
import model.DepositAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createaccountForm {
    private JPanel rootPanel;
    private JRadioButton depositRadioButton;
    private JRadioButton currentRadioButton;
    private JTextField createacctxtfield;
    private JButton addNewAccountButton;
    private JTextField overdraftLimtxtField;
    private JLabel overLimLabel;



    public createaccountForm() {


        ButtonGroup radioGaGa = new ButtonGroup();
        radioGaGa.add(currentRadioButton);
        radioGaGa.add(depositRadioButton);




        addNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String creation = createacctxtfield.getText();

                if (creation == null){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Please fill an Id","Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {

                    int newGuy = Integer.parseInt(creation);

                    boolean exists = proBank.thomondAccounts.stream().anyMatch(account ->
                            account.getId() == newGuy);

                    if (exists) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Account ID already exists",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }


                    int addCustNo = proBank.thomondAccounts.size() +1;


                    if (depositRadioButton.isSelected()){
                        DepositAccount newEntry = new  DepositAccount(newGuy,addCustNo);
                        proBank.thomondAccounts.add(newEntry);
                        JOptionPane.showMessageDialog(rootPanel,"New Account created successfully");

                    } else if (currentRadioButton.isSelected()) {


                        double overlim = Double.parseDouble(overdraftLimtxtField.getText());

                        if (overlim < 0){
                            JOptionPane.showMessageDialog(rootPanel,"Please enter Positive number"
                            ,"Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else if (overdraftLimtxtField.getText() == null) {
                            overlim = 0;

                        }


                        CurrentAccount newAccount = new CurrentAccount(newGuy,addCustNo,overlim);
                        proBank.thomondAccounts.add(newAccount);
                        JOptionPane.showMessageDialog(rootPanel,"New Account created successfully");

                    }

                    createacctxtfield.setText("");
                    overLimLabel.setVisible(false);
                    overdraftLimtxtField.setVisible(false);
                    radioGaGa.clearSelection();





                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Please enter a valid ID number",
                    "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        depositRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                overLimLabel.setVisible(false);
                overdraftLimtxtField.setVisible(false);
            }
        });
        currentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    overLimLabel.setVisible(true);
                    overdraftLimtxtField.setVisible(true);

            }
        });
    }

    public static void display() {
        JFrame frame = new JFrame("New Account");
        frame.setContentPane(new createaccountForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
