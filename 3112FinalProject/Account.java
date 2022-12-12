import java.util.ArrayList;

public class Account {
    private String type;
    private double balance;
    public double BalanceDue;
    private int accountId;
    private User owner;
    private ArrayList<Transaction> transactions;

    public Account(String type, User owner, Instance system) {
        this.type = type;
        this.owner = owner;
        this.accountId = system.generateAccountId();
        this.transactions = new ArrayList<Transaction>();

        owner.addNewAccount(this);
        system.addNewAccount(this);

    }

    public int getAccountId() {
        return this.accountId;
    }

    public double getAccountBalance() {
        return this.balance;

    }

    public void setAccountBalnace(double b) {

        this.balance = b;

    }

    public double totalMoneySpent() {
        double total = 0;
        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Income")) == false) {

                total += t.getTransactionAmount();

            }

        }
        return total;

    }

    public double totalMoneyEarned() {
        double total = 0;
        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Income")) == true) {

                total += t.getTransactionAmount();

            }

        }
        return total;

    }

    public double calculateBalanceDue() {
        double x = 0;
        for (Transaction t : this.transactions) {
            x += t.getTransactionAmount();

        }
        return x;

    }

    public void displayTransactionsForMonth() {

        System.out.println("[[Transaction History For Month]]");
        System.out.println("");

        for (Transaction t : this.transactions) {

            System.out.println("Transaction Category : " + t.getTransactionCategory() + "           Transaction Amount: $"
                    + t.getTransactionAmount());

        }

        System.out.println("");

        System.out.println("Total Money Spent This Month: $" + this.totalMoneySpent());
        System.out.println("");
        System.out.println("Total Money Earned This Month: $" + this.totalMoneyEarned());
        System.out.println("");


    }

    public void clearAccountTransactionList() {

        this.transactions.clear();

    }

    public void displayAccountInfo() {
        System.out.println("Account Name : " + this.type);
        System.out.println("Account Balance $: " + this.balance);
        System.out.println("Account Id : " + this.accountId);
    }

    public void addTransaction(String category, double amount) {

        Transaction t = new Transaction(category, amount, this);
        this.transactions.add(t);

    }

    public void makeAWithdrawlTransaction(String category, double amount) {
        this.addTransaction(category, amount);
        this.balance = this.balance - amount;

    }

    public void makeADepositTransaction(String category, double amount) {

        this.addTransaction(category, amount);
        this.balance = this.balance + amount;

    }

    // public void displayMonthTransactionSummary() {

    // System.out.println("[[[Your Monthly Transaction Summary]]");
    // this.displayTransactionsByCategory();
    // this.displayMaximumWithdrawl();
    // this.displayMaximumDeposit();
    // this.displayMinimumWithdrawl();
    // this.displayMinimumDeposit();
    // }

    public void displayWithdrawlTransactions() {

        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Income")) == false)
                ;

            {
                System.out.println(" Transaction Category: " + t.getTransactionCategory() + "     Amount: -$"
                        + t.getTransactionAmount());

            }

        }

    }

    public void displayDepositTransactions() {

        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Income")) == true)

            {
                System.out.println(" Transaction Category: " + t.getTransactionCategory() + "     Amount: +$"
                        + t.getTransactionAmount());

            }

        }

    }

    public void displayHomeCategory() {
        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Home and Utilities")) == true) {
                System.out.println(" Transaction Category: " + t.getTransactionCategory() + "     Amount: -$"
                        + t.getTransactionAmount());

            }

        }
    }

    public void displayTransportationCategory() {
        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Transportation")) == true) {
                System.out.println(" Transaction Category: " + t.getTransactionCategory() + "     Amount: -$"
                        + t.getTransactionAmount());

            }

        }
    }

    public void displayFoodCategory() {
        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Food")) == true) {
                System.out.println(" Transaction Category: " + t.getTransactionCategory() + "     Amount: -$"
                        + t.getTransactionAmount());

            }

        }
    }

    public void displayInsuranceCategory() {
        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Insurance")) == true) {
                System.out.println(" Transaction Category: " + t.getTransactionCategory() + "     Amount: -$"
                        + t.getTransactionAmount());

            }

        }
    }

    public void displayEntertainmentCategory() {
        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Entertainment")) == true) {
                System.out.println(" Transaction Category: " + t.getTransactionCategory() + "     Amount: -$"
                        + t.getTransactionAmount());

            }

        }
    }

    public void displayOtherCategory() {
        for (Transaction t : this.transactions) {

            if ((t.getTransactionCategory().equals("Other")) == true) {
                System.out.println(" Transaction Category: " + t.getTransactionCategory() + "     Amount: -$"
                        + t.getTransactionAmount());

            }

        }
    }

    public void displayTransactionsByCategory() {
        this.displayDepositTransactions();
        this.displayHomeCategory();
        this.displayTransportationCategory();
        this.displayFoodCategory();
        this.displayInsuranceCategory();
        this.displayEntertainmentCategory();
        this.displayOtherCategory();

    }

    // public ArrayList withdrawlsList() {
    // ArrayList<Transaction> withdrawls = new ArrayList<Transaction>();
    // for (Transaction t : this.transactions) {

    // if ((t.getTransactionCategory().equals("Income")) == false) {

    // withdrawls.add(t);

    // }

    // }
    // return withdrawls;

    // }

    // public ArrayList depositsList() {
    // ArrayList<Transaction> deposit = new ArrayList<Transaction>();
    // for (Transaction t : this.transactions) {

    // if ((t.getTransactionCategory().equals("Income")) == true) {

    // deposit.add(t);

    // }

    // }
    // return deposit;

    // }

    // public void displayMaximumWithdrawl() {

    // double max;
    // ArrayList<Transaction> w = this.withdrawlsList();

    // max = w.get(0).getTransactionAmount();
    // for (int i = 1; i < w.size(); i++) {

    // if (max < w.get(i).getTransactionAmount()) {

    // max = w.get(i).getTransactionAmount();

    // }
    // }
    // System.out.println("Your Maximum Transaction Amount is :$" + max);

    // }

    // public void displayMaximumDeposit() {

    // double max;
    // ArrayList<Transaction> w = this.depositsList();

    // max = w.get(0).getTransactionAmount();
    // for (int i = 1; i < w.size(); i++) {

    // if (max < w.get(i).getTransactionAmount()) {

    // max = w.get(i).getTransactionAmount();

    // }
    // }
    // System.out.println("Your Maximum Deposit Amount is :$" + max);

    // }

    // public void displayMinimumWithdrawl() {

    // double min;
    // ArrayList<Transaction> w = this.withdrawlsList();

    // min = w.get(0).getTransactionAmount();
    // for (int i = 1; i < w.size(); i++) {

    // if (min > w.get(i).getTransactionAmount()) {

    // min = w.get(i).getTransactionAmount();

    // }
    // }
    // System.out.println("Your Minimum Transaction Amount is :$" + min);

    // }

    // public void displayMinimumDeposit() {

    // double min;
    // ArrayList<Transaction> w = this.depositsList();

    // min = w.get(0).getTransactionAmount();
    // for (int i = 1; i < w.size(); i++) {

    // if (min > w.get(i).getTransactionAmount()) {

    // min = w.get(i).getTransactionAmount();

    // }
    // }
    // System.out.println("Your Minimum Deposit Amount is :$" + min);

    // }

}
