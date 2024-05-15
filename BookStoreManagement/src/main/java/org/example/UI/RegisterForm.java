package org.example.UI;

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

    public RegisterForm() {
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
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    String password = new String(passwordField.getPassword());
                    String username = userNameField.getText();
                    UserBuilder userBuilder = new UserBuilder();
                    if(adminCheckBox.isBorderPainted()) {
                        userBuilder.setFirstName(firstName).setLastName(lastName).setPassword(password).setUsername(username).setPhoneNumber(phoneNumber).buildAdmin();
                    }else {
                        userBuilder.setFirstName(firstName).setLastName(lastName).setPassword(password).setUsername(username).setPhoneNumber(phoneNumber).build();
                    }
                } catch (Exception exception) {

                }


                JOptionPane.showMessageDialog(jFrame,
                        "Your account has been created");
            }
        });
    }

    public void showWindow(boolean show) {
        jFrame.setVisible(show);
    }
}
