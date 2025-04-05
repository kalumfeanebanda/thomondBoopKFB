package gui;

import model.Account;
import model.CurrentAccount;
import model.DepositAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class proBank {
    private JPanel rootPanel;
    private JTabbedPane tabbedPane;
    private JPanel accountIdPanel;
    private JTextField accountIdtextField;
    private JRadioButton depositAccountRadioButton;
    private JRadioButton currentAccountRadioButton;
    private JPanel atmButtonPanel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton checkBalanceButton;
    private JButton logoutButton;
    private JButton createNewAccountButton;
    private JButton changeAIRButton;
    private JButton changeOverDraftLimitButton;


    private Account chosenOne;


     public static ArrayList<Account> thomondAccounts = new ArrayList<>();
    public proBank() {
    //    initComponents();
        populateMyAccounts();
        functions();
        hidestuff();



        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(depositAccountRadioButton);
        radioGroup.add(currentAccountRadioButton);



        accountIdtextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountIdtextField.setText("");
                hidestuff();
                accountIdtextField.setEnabled(true);
                depositAccountRadioButton.setSelected(false);
                currentAccountRadioButton.setSelected(false);

                depositAccountRadioButton.setEnabled(true);
                currentAccountRadioButton.setEnabled(true);

              radioGroup.clearSelection();

                hidestuff();
            }
        });
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = accountIdtextField.getText();
                try {
                    int accountId = Integer.parseInt(id);
                    for (Account ac : thomondAccounts) {
                        if (ac.getId() == accountId){
                            double bal = ac.getBalance();
                            String balanceDec = String.format("%.2f", bal);
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Account id: "+ id +
                                    " balance: €" + balanceDec );
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(rootPanel, "Account was not found", "Error",
                            JOptionPane.ERROR_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel, "Invalid Account Id" , "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(rootPanel, "enter deposit amount:");

                if (input != null) {
                    try {
                        double dep = Double.parseDouble(input);

                        if (dep <= 0){
                            JOptionPane.showMessageDialog(rootPanel,"Deposit needs to be positive",
                                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
                            return;
                        }


                        int accountId = Integer.parseInt(accountIdtextField.getText());

                        for (Account ac : thomondAccounts){
                            if (ac.getId() == accountId){
                                ac.deposit(dep);
                                JOptionPane.showMessageDialog(rootPanel, "updated balance: €" +
                                        String.format("%.2f", ac.getBalance()));
                                break;
                            }
                        }



                    } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(rootPanel, "enter an actual number, Please :)",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }


                }

            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String accountBalance = String.format("%.2f", chosenOne.getBalance());
                String withdr = JOptionPane.showInputDialog("balance: €" + accountBalance+ " enter withdrawal amount.");

                if (withdr == null) return;

                try {
                    double amount = Double.parseDouble(withdr);
                    if (amount <0){
                        JOptionPane.showMessageDialog(rootPanel,"Amount needs to be positive",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (chosenOne.withdraw(amount)){
                        String update = String.format("%.2f", chosenOne.getBalance());
                        JOptionPane.showMessageDialog(rootPanel,
                                "updated balance: €" + update);
                    } else {
                        JOptionPane.showMessageDialog(rootPanel,"amount exceeds available balance");
                    }

                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(rootPanel,"Invalid Input", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createaccountForm.display();
            }
        });
        changeAIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeair.display();
            }
        });
        changeOverDraftLimitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editOverdraft.display();
            }
        });
    }


    private void hidestuff() {
        depositButton.setVisible(false);
        withdrawButton.setVisible(false);
        checkBalanceButton.setVisible(false);
        logoutButton.setVisible(false);
        depositAccountRadioButton.setVisible(false);
        currentAccountRadioButton.setVisible(false);

    }


    private void populateMyAccounts() {
      //   used to populate myAccounts ArrayList with test data
        thomondAccounts.add(new DepositAccount(1, 1));
       thomondAccounts.get(0).deposit(100);
      thomondAccounts.add(new DepositAccount(2, 2));
       thomondAccounts.get(1).deposit(500);
       thomondAccounts.add(new DepositAccount(3, 3));
        thomondAccounts.get(2).deposit(300);
        thomondAccounts.add(new CurrentAccount(4, 1, 100));
        thomondAccounts.add(new CurrentAccount(5, 2, 1000));
        thomondAccounts.add(new CurrentAccount(6, 4, 200));
    }








private void functions() {
    accountIdtextField.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String input = accountIdtextField.getText();
            try {
                int accountId = Integer.parseInt(input);
                chosenOne = null;
                for (Account ac : proBank.thomondAccounts ){
                    if (ac.getId() == accountId){
                        chosenOne = ac;
                        break;
                    }
                }
                if (chosenOne != null){

                    if (chosenOne instanceof DepositAccount){
                        depositAccountRadioButton.setSelected(true);
                    } else if (chosenOne instanceof CurrentAccount){
                        currentAccountRadioButton.setSelected(true);
                    }

                    depositAccountRadioButton.setVisible(true);
                    currentAccountRadioButton.setVisible(true);
                    accountIdtextField.setEnabled(false);
                    depositAccountRadioButton.setEnabled(false);
                    currentAccountRadioButton.setEnabled(false);

                    depositButton.setVisible(true);
                    withdrawButton.setVisible(true);
                    checkBalanceButton.setVisible(true);
                    logoutButton.setVisible(true);


                } else {
                    JOptionPane.showMessageDialog(rootPanel, "Invalid Account ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException f) {
                JOptionPane.showMessageDialog(rootPanel, "Enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
            }



        }
    });






}





    public static void main(String[] args) {
        JFrame frame = new JFrame("Thomond Bank");
        frame.setContentPane(new proBank().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
