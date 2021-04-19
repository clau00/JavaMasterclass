package DebuggingAndUnitTesting;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    //  The branch is true if the customer makes the transaction at a branch
    //  and it is false if it is done at an ATM
    public double deposit(double amount, boolean branch){
        this.balance += amount;
        return balance;
    }

    //  The branch is true if the customer makes the transaction at a branch
    //  and it is false if it is done at an ATM
    public double withdraw(double amount, boolean branch){
        if ((amount > 500.00) && !branch){
            throw new IllegalArgumentException();
        }
        this.balance -= amount;
        return balance;
    }

    public double getBalance(){
        return balance;
    }

    public boolean isChecking() {
        return accountType == CHECKING;
    }

}
