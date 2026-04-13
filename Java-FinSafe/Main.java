import java.util.*;
public class Main{
    public static void main(String []args){
       Scanner sc=new Scanner(System.in);
       Account acc=new Account("Arunkumar Paidipelli",1000); 
       while(true){
        System.out.println("\n1. Choose Deposit");
        System.out.println("2. Choose Withdraw");
        System.out.println("3.Choose MiniStatement");
        System.out.println("4.Exit");
        int choosedValue=sc.nextInt();
        if (choosedValue==1){
            System.out.println("Enter amount: ");
            double amt=sc.nextDouble();
            acc.deposit(amt);
        }else if(choosedValue==2){
            System.out.println("Enter amount");
            double amt=sc.nextDouble();
            try{
                acc.withdraw(amt);
            }catch(InsufficientFundsException e){
                System.out.println(e.getMessage());
            }
        
        }else if(choosedValue==3){
            acc.printMiniStatement();

        }
        else if(choosedValue==4){
            System.out.println("Thank you");
            break;
        }
        else{
            System.out.println("Invalid choice");
        }
    }
    sc.close();
}

