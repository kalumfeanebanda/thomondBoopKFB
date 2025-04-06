package gui;

import model.Account;
import model.CurrentAccount;
import model.DepositAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interestCalc {
    private JPanel rootPanel;
    private JTextField idtxtField;
    private JTextField cBalancetxtField;
    private JButton calculateInterestButton;


    private Account CalAccount;

    public interestCalc(Account chosenOne) {
        this.CalAccount = chosenOne;
        idtxtField.setText(CalAccount.getId()+ "");


        cBalancetxtField.setText("€"+String.format("%.2f", CalAccount.getBalance()));

        calculateInterestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CalAccount.getBalance() <=0){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Account must have positive balance to apply interest",
                            "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double AIRrate = (CalAccount instanceof CurrentAccount) ? CurrentAccount.getAIR() : DepositAccount.getAIR();

                double monthOfInterest = (CalAccount.getBalance() * AIRrate);
                double yearOfInterest = monthOfInterest * 12;

                JOptionPane.showMessageDialog(rootPanel,
                        "AIR Rate: " + (AIRrate * 100) + "%" +
                        "\nInterest Earned After a Month: €" + String.format("%.2f",monthOfInterest)+
                                "\nInterest Earned After a Year: €" + String.format("%.2f",yearOfInterest));

            }
        });
    }

    public static void display(Account chosenOne) {
        JFrame frame = new JFrame("interest Calculator");
        frame.setContentPane(new interestCalc(chosenOne).rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
