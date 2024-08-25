public class CheckingAccount extends Account {

    private  double overDraftLimit;

    // Constructor
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double overDraftLimit) {
        super(accountNumber,ownerName,initialBalance);
    }

    @Override
    public void withdraw(double amount){
        if(amount>0 && (balance+overDraftLimit)>=amount){
            balance-=amount;
            transactions.add(new Transaction("Withdrawal ", -amount));
            System.out.println("Withdrawn: $"+amount);
        }
        else {
            System.out.println("Invalid withdrawal amount or exceeds overdraft limit");
        }
    }

    @Override
    public void calculateInterest(){
        System.out.println("Checking accounts do not earn interest");
    }

    public double getOverDraftLimit(){
        return overDraftLimit;
    }

}
