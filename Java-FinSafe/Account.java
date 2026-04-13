import java.util.*;
public class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<Double> transactions =new ArrayList<>();
    public Account(String accountHolder,double balance){
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    public void deposit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        balance+=amount;
        transactions.add(amount);
    }
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount<=0){
            throw new IllegalArgumentException("Invalid amount");
        }
        else if (amount>balance){
            throw new InsufficientFundsException("Not enough balance");
        }
        else{
            balance-=amount;
            transactions.add(-amount);
        }

    }

}
