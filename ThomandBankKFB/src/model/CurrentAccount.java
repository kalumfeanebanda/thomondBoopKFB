package model;

public class CurrentAccount extends Account {
    private static double AIR = 0.005;
    private double overdraftlim;

    public CurrentAccount(int id, int custNo, double overdraftlim){
    super(id, custNo);
    this.overdraftlim = overdraftlim;
    }


    @Override
    public boolean withdraw(double amount){
        if (amount > 0 && amount <= (balance + overdraftlim)){
            setBalance(getBalance() - amount);
            return true;
        }
            return false;
        }


    public void setOverdraftlim(double limit){
        this.overdraftlim = limit;
    }
    public static void setAIR(double newRate){
        AIR = newRate;
    }

}
