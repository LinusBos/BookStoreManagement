package org.example.UI;

import org.example.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class StoreForm extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel mainPanel;
    private JPanel libraryPanel;
    private JPanel adminPanel;
    private JComboBox filterComboBox;
    private JTextField searchField;
    private JButton searchButton;
    private JTable productTable;
    private JScrollPane scrollPane;
    private JTextField titleField;
    private JTextField sellPriceField;
    private JTextField releaseDateField;
    private JTextField quantityField;
    private JButton updateButton;
    private JLabel titleLabel;
    private JLabel sellPriceLabel;
    private JLabel releaseDateLabel;
    private JLabel quantityLabel;
    private JButton configureButton;
    private JButton createBookButton;
    private JTextField purchasePriceField;
    private JLabel purchasePriceLabel;
    private JButton undoButton;
    private JFrame jFrame;
    private User currentUser;
    private String[] filterOptions = {" ","Price", "Quantity", "Alphabetic"};
    private String[] columnNames = {"Title", "Price", "Quantity"};
    private ArrayList<Product> bookList;
    private BookSorter bookSorter;
    private CommandInvoker commandInvoker;
    private int selectedRowIndex;

    public StoreForm(User currentUser, Catalog bookLibrary) {
        this.currentUser = currentUser;
        this.bookList = bookLibrary.getProducts();
        this.commandInvoker = new CommandInvoker();
        bookSorter = new BookSorter();
        selectedRowIndex = - 1; //Mark as no selected row.
        jFrame = new JFrame();
        jFrame.setTitle("Book Store Manager");
        jFrame.setContentPane(mainPanel);
        jFrame.pack();
        jFrame.setSize(800,800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (!currentUser.isAdmin()) {
            tabbedPane.remove(adminPanel);
            configureButton.setVisible(false);
        }
        filterComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (filterComboBox.getSelectedItem().equals("Price")) {
                    bookSorter.setFilterStrategy(new PriceFilter());
                } else if (filterComboBox.getSelectedItem().equals("Quantity")){
                    bookSorter.setFilterStrategy(new QuantityFilter());
                } else {
                    bookSorter.setFilterStrategy(new AlphabeticFilter());
                }
                bookList = bookSorter.sortBooks(bookList);
                setupTable();
            }
        });
        setupTable();
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedRowIndex >= 0) {
                    Book oldBook = (Book) bookList.get(selectedRowIndex);

                    BookBuilder bookBuilder = new BookBuilder();
                    String title = titleField.getText();
                    double sellPrice = Double.parseDouble(sellPriceField.getText());
                    double purchasePrice = Double.parseDouble(purchasePriceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());
                    String releaseDate = releaseDateField.getText();

                    Book updatedBook = (Book) bookBuilder
                            .setAuthorList(oldBook.getAuthors())
                            .setTitle(title)
                            .setQuantity(quantity)
                            .setSellPrice(sellPrice)
                            .setReleaseDate(releaseDate)
                            .setPurchasePrice(purchasePrice)
                            .build();
                    Command updateBookCommand = new UpdateBookCommand((BookLibrary) bookLibrary, oldBook, updatedBook);
                    commandInvoker.executeCommand(updateBookCommand);
                    JOptionPane.showMessageDialog(jFrame,
                            "Book updated!", "Confirmed!", JOptionPane.INFORMATION_MESSAGE);
                    setupTable();
                    tabbedPane.setSelectedIndex(0);
                }

            }
        });
        createBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookBuilder bookBuilder = new BookBuilder();
                String title = titleField.getText();
                double sellPrice = 0;
                double purchasePrice = 0;
                try {
                    sellPrice = Double.parseDouble(sellPriceField.getText());
                    purchasePrice = Double.parseDouble(purchasePriceField.getText());
                } catch (NumberFormatException ignored) {

                }
                int quantity = Integer.parseInt(quantityField.getText());
                String releaseDate = releaseDateField.getText();

                String authorFirstName = JOptionPane.showInputDialog("Enter Author's First name:");
                String authorMiddleName = JOptionPane.showInputDialog("Enter Author's middle name:");
                String authorLastName = JOptionPane.showInputDialog("Enter Author's last name:");

                Author author = new Author(authorFirstName, authorMiddleName, authorLastName);
                ArrayList<Author> authors = new ArrayList<>();
                authors.add(author);

                Book updatedBook = (Book) bookBuilder
                        .setAuthorList(authors)
                        .setTitle(title)
                        .setQuantity(quantity)
                        .setSellPrice(sellPrice)
                        .setReleaseDate(releaseDate)
                        .setPurchasePrice(purchasePrice)
                        .build();
                Command createBookCommand = new AddBookCommand((BookLibrary) bookLibrary, updatedBook);
                commandInvoker.executeCommand(createBookCommand);
                JOptionPane.showMessageDialog(jFrame,
                        "Book created!", "Confirmed!", JOptionPane.INFORMATION_MESSAGE);
                setupTable();
                tabbedPane.setSelectedIndex(0);

            }
        });
        configureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRowIndex = productTable.getSelectedRow();
                if (selectedRowIndex < 0) {
                    // no row selected
                    JOptionPane.showMessageDialog(jFrame,
                            "Please select a row", "Oh no...", JOptionPane.WARNING_MESSAGE);
                } else {
                    Product product = bookList.get(selectedRowIndex);
                    titleField.setText(product.getTitle());
                    sellPriceField.setText(String.valueOf(product.getSellPrice()));
                    releaseDateField.setText(product.getReleaseDate());
                    quantityField.setText(String.valueOf(product.getQuantity()));
                    purchasePriceField.setText(String.valueOf(product.getPurchasePrice()));
                    JOptionPane.showMessageDialog(jFrame,
                            "Book selected, moving you to admin page", "Confirmed!", JOptionPane.INFORMATION_MESSAGE);
                    tabbedPane.setSelectedIndex(1);
                }

            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandInvoker.undoLastCommand();
                JOptionPane.showMessageDialog(jFrame,
                        "Last command has been undone!", "Confirmed!", JOptionPane.INFORMATION_MESSAGE);
                setupTable();
                tabbedPane.setSelectedIndex(0);
            }
        });
    }
    private void setupTable() {
        String[][] tableData = generateData();
        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);
        productTable.setModel(tableModel);
        if (scrollPane == null) {
            scrollPane = new JScrollPane(productTable);
            libraryPanel.add(scrollPane);  // Add the scrollPane to the appropriate panel
        }

    }
    private String[][] generateData() {
        String[][] data = new String[bookList.size()][columnNames.length];
        for (int i = 0; i < bookList.size(); i++) {
            // "Title", "Price", "Quantity"
            data[i][0] = bookList.get(i).getTitle();
            data[i][1] = String.valueOf(bookList.get(i).getSellPrice());
            data[i][2] = String.valueOf(bookList.get(i).getQuantity());
        }
        return data;
    }


    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public void showWindow(boolean showing) {
        jFrame.setVisible(showing);
    }

    private void createUIComponents() {
        filterComboBox = new JComboBox(filterOptions);
        productTable = new JTable();

    }
}
