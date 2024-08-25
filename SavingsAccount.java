public class SavingsAccount extends Account{

    private double interestRate;

    // constructor
    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate){
        super(accountNumber,ownerName,initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        transactions.add(new Transaction("Interest", interest));
        System.out.println("Interest added: $"+ interest);
    }

    // Getter and setter
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}
