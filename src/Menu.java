import admin.CreateAccount;
import generator.UniqueNumberGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel panel1;
    private JPanel content;
    private JTextPane accountsDisplay;
    private JTextField name;
    private JTextField card;
    private JTextField address;
    private JTextField contact;
    private JTextField email;
    private JTextField pin;
    private JTextField city;
    private JTextField account;
    private JTextField balance;
    private JButton cancelButton;
    private JButton submitButton;
    private JComboBox comboBox1;

    public Menu(String username) {
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);

        card.setText(String.valueOf(UniqueNumberGenerator.generateUniqueNumber()));
        account.setText(String.valueOf(UniqueNumberGenerator.generateUniqueCard()));

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creteUser();
            }
        });
    }


    private void creteUser(){
        try {
            String userName = name.getText().trim();
            String userAddress = address.getText().trim();
            String userEmail = email.getText().trim();
            String userPhone = contact.getText().trim();
            int cardNumber = Integer.parseInt(card.getText().trim());
            int userPin = Integer.parseInt(pin.getText());
            String userCity = city.getText().trim();
            int accountId = Integer.parseInt(account.getText().trim());
            double acBalance = Double.parseDouble(balance.getText().trim());
            String acType = (String) comboBox1.getSelectedItem();
            System.out.println(acType);

            CreateAccount newAccount = new CreateAccount();

            try {
                boolean isUser = newAccount.createAccount(userName, userAddress, userEmail, userPhone, cardNumber, userPin, userCity, acType, accountId, acBalance);
                if (!isUser) {
                    JOptionPane.showMessageDialog(null, "Error creating bank account");
                } else {
                    JOptionPane.showMessageDialog(null, "Success");
                    clearSelections();
                }
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(null, "Enter a valid type");
            }
        }catch (NumberFormatException ne) {
            System.out.println(ne);
            JOptionPane.showMessageDialog(null, "Please fill in all the fields to continue");
        }
    }

    private void clearSelections() {

    }

    private void getAccounts(){

    }
}
