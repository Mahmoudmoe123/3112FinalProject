import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private int userId;
    private int loginPin;
    private double monthlyBudget;
    private ArrayList<Account> myaccounts;
    private boolean monthStart;

    /**
     * 
     */
    public User(String fName, String lName, int pin, Instance s) {

        this.firstName = fName;
        this.lastName = lName;
        this.loginPin = pin;
        this.userId = s.generateUserId();
        this.monthStart = false;

        this.myaccounts = new ArrayList<Account>();

    }

    public boolean getMonthStart() {

        return this.monthStart;

    }

    public void setMonthStart(boolean m) {
        this.monthStart = m;

    }

    public boolean checkifMonthStarted() {

        if (this.monthStart == true) {

            return true;

        }
        return false;

    }

    public double getMonthlyBudget() {

        return this.monthlyBudget;

    }

    public void setMonthlyBudget(double b) {

        this.monthlyBudget = b;

    }

    public void addNewAccount(Account nAccount) {

        this.myaccounts.add(nAccount);

    }

    public Account getFirstAccount() {

        return this.myaccounts.get(0);

    }

    public String getUserFirstname() {

        return this.firstName;

    }

    public String getUserLastname() {

        return this.lastName;

    }

    public int getUserId() {
        return this.userId;

    }

    public int getUserPin() {

        return this.loginPin;

    }

    public String getFirstName() {
        return this.firstName;

    }

    public void printAccountInfo() {
        System.out.println("");
        System.out.println("Welcome: " + this.firstName + " " + this.lastName);

        for (Account a : myaccounts) {
            a.displayAccountInfo();

        }

    }

    public boolean checkifAccountExists() {
        if (this.myaccounts.size() == 0) {

            return false;

        }
        return true;

    }

    public void setAccountBalance(double b) {

        this.myaccounts.get(0).setAccountBalnace(b);

    }

    public double getAccoutnBalance() {

        return this.myaccounts.get(0).getAccountBalance();

    }

    public void makeAWithdrawlTransaction(String category, double amount) {

        this.getFirstAccount().makeAWithdrawlTransaction(category, amount);

    }


    public void makeADepositTransaction(String category, double amount) {

        this.getFirstAccount().makeADepositTransaction(category, amount);

    }

    // public void displayUserInfo(){

    // System.out.println(this.firstName);
    // System.out.println(this.lastName);
    // System.out.println(this.userId);

    // }

}
