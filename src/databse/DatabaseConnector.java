package databse;

import admin.CreateAccount;
import constructer.Account;
import constructer.User;

import java.sql.*;

// TODO: Get database connection and run queries
public class DatabaseConnector {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cse_atm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    // TODO: 2. Create a static method called `getConnection` that returns a Connection object.
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
            return connection;
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
            return null;
        }
    }

    // TODO: 3. Create a static method called `closeConnection` that closes the database connection.
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection.");
            e.printStackTrace();
        }
    }

    // TODO: 4. Create a static method called `createUser` that inserts a new user into the database.
    public static boolean createUser(User user) {
        String query = "INSERT INTO users (name, address, email, contact, userId, pin, city) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, user.getName());
            statement.setString(2, user.getAddress());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setInt(5, user.getCardNumber());
            statement.setInt(6, user.getPin());
            statement.setString(7, user.getCity());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was affected, indicating successful user creation
        } catch (SQLException e) {
            System.out.println("Error creating user.");
            e.printStackTrace();
            return false;
        }
    }

    // TODO : 5. Create a static method called 'createBankAccount' that inserts a new bank account into the database.
    public static boolean createBankAccount(Account account) {
        String query = "INSERT INTO bank_accounts (accountId, userId, acType, balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, account.getAccountId());
            statement.setInt(2, account.getUserId());
            statement.setString(3, account.getAcType());
            statement.setDouble(4, account.getBalance());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was affected, indicating successful user creation
        } catch (SQLException e) {
            System.out.println("Error creating bank account.");
            e.printStackTrace();
            return false;
        }
    }

    // TODO : 6. Create a static method called 'login' to log int the back admin
    public static boolean login(String username, String password) {
        String query = "SELECT adminId FROM admin WHERE adminId = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            return true;
        } catch (SQLException e) {
            System.out.println("Error creating bank account.");
            e.printStackTrace();
            return false;
        }
    }

    // TODO: 7. Create a static method called `getBankAccounts' that returns all the bank accounts.
    public static String getAccounts() {
        String query = "SELECT * FROM bank_account";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("acNo");
            }
        } catch (SQLException e) {
            System.out.println("Error validating user.");
            e.printStackTrace();
            return "Error getting accounts";
        }
        return "Error getting accounts";
    }

}
