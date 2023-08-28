import admin.AdminSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login extends JFrame{
    private JPanel panel1;
    private JPanel content;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton cancelButton;
    private JButton loginButton;

    public Login() {
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminSession adminSession = new AdminSession();
                String username = emailField.getText().trim();
                String password = Arrays.toString(passwordField.getPassword()).trim();
                boolean isAdmin = adminSession.login(username, password);
                if (!isAdmin) {
                    JOptionPane.showMessageDialog(null,"Wrong username or password");
                } else {
                    new Menu(username);
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
