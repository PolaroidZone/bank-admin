package admin;

import databse.DatabaseConnector;

import javax.swing.*;
import java.util.Objects;

public class AdminSession {

    public AdminSession() {
    }
    public boolean login(String username, String password) {
        DatabaseConnector.getConnection();
        try {
            boolean isExists = DatabaseConnector.login(username, password);
            if (!isExists){
                DatabaseConnector.closeConnection();
                return false;
            } else {
                DatabaseConnector.closeConnection();
                return true;
            }
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Enter a valid input");
            return false;
        }
    }
}
