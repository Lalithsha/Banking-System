import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts;

    public Bank(){
        this.accounts = new HashMap<>();
    }

    public void createSavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate){
        if(!accounts.containsKey(accountNumber)){
            accounts.put(accountNumber, new SavingsAccount(accountNumber,ownerName,initialBalance,interestRate));
            System.out.println("Savings account created successfully");
        }
        else {
            System.out.println("Account number already exists");
        }
    }

    public void createCheckingAccount(String accountNumber, String ownerName, double initialBalance, double overDraftLimit){
        if(!accounts.containsKey(accountNumber)){
            accounts.put(accountNumber, new CheckingAccount(accountNumber, ownerName, initialBalance, overDraftLimit));
            System.out.println("Checking account created successfully");
        }
        else {
            System.out.println("Account number already exists");
        }
    }

    // Get an account by its number
    public Account getAccount(String accountNumber){
        return accounts.get(accountNumber);
    }

    // Perform a transfer between accounts
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount){
        Account fromAccount = getAccount(fromAccountNumber);
        Account toAccount = getAccount(toAccountNumber);

        if(fromAccount !=null && toAccount !=null){
            if(fromAccount.getBalance()>=amount){
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println("Transfer successful");
            }
            else {
                System.out.println("Insufficient funds to transfer");
            }
        }
        else {
            System.out.println("One or both accounts not found");
        }

    }

    public void calculateInterestForAllSavingsAccounts(){
        for(Account account: accounts.values()){
            if(account instanceof SavingsAccount){
                account.calculateInterest();
            }
        }
    }

}
