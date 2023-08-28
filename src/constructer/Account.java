package constructer;

public class Account {
    private int accountId;
    private int userId;
    private String acType;
    private double balance;

    public Account() {
    }

    public Account(int accountId, int userId, String acType, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.acType = acType;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
