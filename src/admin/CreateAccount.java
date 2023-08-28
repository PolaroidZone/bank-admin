package admin;

import constructer.Account;
import constructer.User;
import databse.DatabaseConnector;
import generator.UniqueNumberGenerator;

public class CreateAccount {

    public CreateAccount() {
    }

    public boolean createAccount(String name, String address, String email, String contact, int card, int pin, String city, String acType, int acNo, double balance) {
        DatabaseConnector.getConnection();
        User user = new User(name, address, email, contact, card, pin, city);
        Account account= new Account(acNo, card, acType, balance);
        boolean isUser = DatabaseConnector.createUser(user);
        boolean isAccount = DatabaseConnector.createBankAccount(account);
        if (isUser && isAccount) {
            return true;
        } else {
            return false;
        }
    }

}
