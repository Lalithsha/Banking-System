import java.util.Scanner;
public class BankingSystem {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n===== Banking System Menu =====");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Transfer");
            System.out.println("7. Print Transaction History");
            System.out.println("8. Calculate Interest for Savings Accounts");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createSavingsAccount(bank, scanner);
                    break;
                case 2:
                    createCheckingAccount(bank, scanner);
                    break;
                case 3:
                    deposit(bank, scanner);
                    break;
                case 4:
                    withdraw(bank, scanner);
                    break;
                case 5:
                    checkBalance(bank, scanner);
                    break;
                case 6:
                    transfer(bank, scanner);
                    break;
                case 7:
                    printTransactionHistory(bank, scanner);
                    break;
                case 8:
                    bank.calculateInterestForAllSavingsAccounts();
                    break;
                case 9:
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }

    }

    public static void createSavingsAccount(Bank bank, Scanner scanner){
        System.out.println("Enter the account number");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter the owner name: ");
        String ownerName = scanner.nextLine();
        System.out.println("Enter the initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.println("Enter interest rate (as a decimal");
        double interestRate = scanner.nextDouble();

        bank.createSavingsAccount(accountNumber,ownerName,initialBalance,interestRate);

    }

    private static void createCheckingAccount(Bank bank, Scanner scanner){
        System.out.println("Enter the account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter owner name:");
        String ownerName= scanner.nextLine();
        System.out.println("Enter initial balance");
        double initialBalance = scanner.nextDouble();
        System.out.println("Enter overdraft limit");
        double overDraftLimit = scanner.nextDouble();

        bank.createCheckingAccount(accountNumber, ownerName, initialBalance, overDraftLimit);
    }

    private static void deposit(Bank bank, Scanner scanner){
        System.out.println("Enter account number");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter deposit amount: ");
        double amount = scanner.nextDouble();


        Account account = bank.getAccount(accountNumber);
        if(account!=null){
            account.deposit(amount);
        }
        else {
            System.out.println("Account not found");
        }

    }

    private static void withdraw(Bank bank , Scanner scanner){
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter withdraw amount: ");
        double amount = scanner.nextDouble();

        Account account = bank.getAccount(accountNumber);
        if(account!=null){
            account.withdraw(amount);
        }
        else {
            System.out.println("Account not found: ");
        }

    }

    private static void checkBalance(Bank bank, Scanner sc){
        System.out.println("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = bank.getAccount(accountNumber);
        if(account!=null){
            System.out.println("Current account balance: $"+ account.getBalance());
        }
        else {
            System.out.println("Account not found");
        }
    }


    private static void transfer(Bank bank, Scanner sc){
        System.out.println("Enter account number: ");
        String fromAccountNumber = sc.nextLine();
        System.out.println("Enter destination account");
        String toAccountNumber = sc.nextLine();
        System.out.println("Enter transfer amount: ");
        double amount = sc.nextDouble();

        bank.transfer(fromAccountNumber, toAccountNumber,amount);

    }

    private static void printTransactionHistory(Bank bank, Scanner sc){
        System.out.println("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = bank.getAccount(accountNumber);
        if(account!=null){
            account.printTransactionHistory();
        }
        else {
            System.out.println("Account not found");
        }
    }

}
