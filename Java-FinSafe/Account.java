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
        System.out.println(amount+" Successfully Deposited");
        transactions.add(amount);
        if (transactions.size()>5){
            transactions.remove(0);
        }
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
            if (transactions.size()>5){
                transactions.remove(0);
            }
            System.out.println(amount+ "Withdrawal successfull");
            System.out.println("Current balance: "+balance);
        }

    }
    public void printMiniStatement(){1
        System.out.println("Transaction History"); 
        for(double trans : transactions){
            if(trans>0){
                System.out.println("Deposited: "+trans);
            }else{
                System.out.println("Withdrawn: "+(-trans));
            }
        } 
        System.out.println("Current Balance: "+ balance);  
    }

}
