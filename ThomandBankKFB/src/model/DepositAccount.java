package model;

import javax.naming.InsufficientResourcesException;

public class DepositAccount extends Account {
    private static double AIR = 0.02;

    public DepositAccount(int id, int custNo){
        super(id, custNo);
    }

    @Override
    public boolean withdraw(double amount){
        if (amount > 0 && amount <= balance){
            setBalance(getBalance()- amount);
            return true;
        }
        return false;


        }



    public static void setAIR(double newRate){
        AIR = newRate;
    }

}
