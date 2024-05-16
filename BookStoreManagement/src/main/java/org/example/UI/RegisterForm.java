package org.example.UI;

import org.example.AccountManager;
import org.example.UserBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegisterForm extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNumberField;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JLabel firstNameLabel;
    private JLabel phoneLabel;
    private JLabel lastNameLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JButton registerButton;
    private JCheckBox adminCheckBox;
    private JFrame jFrame;
    private AccountManager accountManager;

    public RegisterForm(AccountManager accountManager) {
        jFrame = new JFrame();
        jFrame.setContentPane(mainPanel);
        jFrame.pack();
        jFrame.setSize(400,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(checkInputs()) {
                        String firstName = firstNameField.getText();
                        String lastName = lastNameField.getText();
                        String phoneNumber = phoneNumberField.getText();
                        String password = new String(passwordField.getPassword());
                        String username = userNameField.getText();
                        UserBuilder userBuilder = new UserBuilder();
                        if(adminCheckBox.isSelected()) {
                            accountManager.addUser(
                                    userBuilder
                                            .setFirstName(firstName)
                                            .setLastName(lastName)
                                            .setPassword(password)
                                            .setUsername(username)
                                            .setPhoneNumber(phoneNumber)
                                            .buildAdmin());

                        }else {
                            accountManager.addUser(
                                    userBuilder
                                            .setFirstName(firstName)
                                            .setLastName(lastName)
                                            .setPassword(password)
                                            .setUsername(username)
                                            .setPhoneNumber(phoneNumber)
                                            .build());
                        }
                        JOptionPane.showMessageDialog(jFrame,
                                "Your account has been created","Account creation", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(jFrame,
                                "You didn't fill out all the information needed!", "Oops!", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(jFrame,
                            "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void showWindow(boolean show) {
        jFrame.setVisible(show);
    }

    private boolean checkInputs() {
        JTextField[] textFields = {firstNameField, lastNameField, phoneNumberField, userNameField};
        for (JTextField textField: textFields) {
            if(textField.getText().trim().isEmpty()) {
                return false;
            }
        }
        return !new String(passwordField.getPassword()).trim().isEmpty();
    }
}
