package org.example.UI;

import org.example.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton loginButton;
    private JButton registerButton;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JFrame jFrame;
    private RegisterForm registerForm;
    private boolean windowShowing = false;
    private StoreForm storeForm;

    public MainForm(RegisterForm registerForm, StoreRunner storeRunner, BookLibrary bookLibrary) {
        this.registerForm = registerForm;
        jFrame = new JFrame();
        jFrame.setTitle("Book Store Manager");
        jFrame.setContentPane(mainPanel);
        jFrame.pack();
        jFrame.setSize(400,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        windowShowing = false;
        showWindow(true);
        jFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(jFrame,
                        "Are you sure you want to exit?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    storeRunner.exiting();
                    System.exit(0);
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkInputs()) {
                    AccountManager accountManager = storeRunner.getAccountManager();
                    boolean loggedIn = accountManager.login(usernameTextField.getText(), new String(passwordField.getPassword()));
                    if (loggedIn) {
                        JOptionPane.showMessageDialog(jFrame,
                                "You have been logged in!", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
                        storeForm = new StoreForm(accountManager.getCurrentUser(), bookLibrary);
                        storeForm.showWindow(true);

                    } else {
                        JOptionPane.showMessageDialog(jFrame,
                                "Wrong combination of username and password.", "Oh no...", JOptionPane.WARNING_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(jFrame,
                            "You didn't fill out all the information needed!", "Oops!", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerForm.showWindow(true);

            }
        });
    }
    public void showWindow(boolean show){
        windowShowing = true;
        jFrame.setVisible(show);
    }
    private boolean checkInputs() {
        if (usernameTextField.getText().isEmpty() || new String(passwordField.getPassword()).isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
}
