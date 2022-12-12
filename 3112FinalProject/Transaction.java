

public class Transaction {
    private double amount;
    private String category;
    private Account belongstoAccount;

    public Transaction(String category, double amount, Account associatedAccount) {
        this.amount = amount;
        this.belongstoAccount = associatedAccount;
        this.category = category;

    }

    public double getTransactionAmount() {
        return this.amount;
    }

    public String getTransactionCategory() {
        return this.category;
    }

    public Account getassociatedAccount() {

        return this.belongstoAccount;

    }

}
