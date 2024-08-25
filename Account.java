import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    protected String accountNumber;
    protected String ownerName;
    protected double balance;
    protected List<Transaction> transactions;

    public Account(String accountNumber,String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.transactinos = new ArraList<>();
    }

    // To be implemented by subclass
    public abstract void calculateInterest();

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            transactions.add(new Transaction("Deposit",amount));
            System.out.println("Deposited: $"+amount);
        }
        else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if(amount>0 && balance>=amount){
            balance-=amount;
            transactions.add(new Transaction("Withdrawal ",-amount));
            System.out.println("Withdrawn: $" + amount);
        }
        else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }

    // Get the current balance
    public double getBalance(){
        return balance;
    }

    // Get the account number
    public String getAccountNumber(){
        return accountNumber;
    }

    // Get the account owner's name
    public String getOwnerName(){
        return ownerName;
    }

    public List<Transaction> getTransactions(){
        return new ArrayList<>(transactions);
    }


    // Print transaction history
    public void printTransactionHistory(){
        System.out.println("Transaction History for account "+accountNumber+":");
        for(Transaction transaction: transactions){
            System.out.println(transaction);
        }
    }

}
