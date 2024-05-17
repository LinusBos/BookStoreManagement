package org.example.UI;

import org.example.*;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class StoreForm extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel mainPanel;
    private JPanel libraryPanel;
    private JPanel shoppingCartPanel;
    private JPanel adminPanel;
    private JComboBox filterComboBox;
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea textArea1;
    private JFrame jFrame;
    private User currentUser;
    private String[] filterOptions = {" ","Price", "Quantity", "Alphabetic"};
    private ArrayList<Product> bookList;
    private BookSorter bookSorter;
    public StoreForm(User currentUser, BookLibrary bookLibrary) {
        this.currentUser = currentUser;
        this.bookList = bookLibrary.getProducts();
        bookSorter = new BookSorter();
        jFrame = new JFrame();
        jFrame.setTitle("Book Store Manager");
        jFrame.setContentPane(mainPanel);
        jFrame.pack();
        jFrame.setSize(800,800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (!currentUser.isAdmin()) {
            tabbedPane.remove(adminPanel);
        }
        filterComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (filterComboBox.getSelectedItem().equals("Price")) {
                    bookSorter.setFilterStrategy(new PriceFilter());
                } else if (filterComboBox.getSelectedItem().equals("Popularity")){

                } else {
                    bookSorter.setFilterStrategy(new AlphabeticFilter());
                }
                bookList = bookSorter.sortBooks(bookList);
            }
        });
    }



    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public void showWindow(boolean showing) {
        jFrame.setVisible(showing);
    }

    private void createUIComponents() {
        filterComboBox = new JComboBox(filterOptions);
    }
}
