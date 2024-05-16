package org.example;

import org.example.UI.MainForm;
import org.example.UI.RegisterForm;

import java.io.Writer;
import java.util.ArrayList;

public class StoreRunner {

    private AccountManager accountManager;
    private BookLibrary bookLibrary;
    private BookManager bookManager;
    private Store store;
    private ShoppingCart shoppingCart;

    public StoreRunner() {
       setup();
    }
    public void run() {
        RegisterForm registerForm = new RegisterForm(accountManager);
        MainForm mainForm = new MainForm(registerForm, this);
    }
    private void setup() {
        Loader loader = new Loader();
        loader.readUsers();
        loader.readProducts();
        if(!(loader.getUsers() == null)) {
            accountManager = new AccountManager(loader.getUsers());
        } else {
            accountManager = new AccountManager(new ArrayList<User>());
        }

        bookManager = new BookManager();
        if(!(loader.getProducts() == null)) {
            bookLibrary = new BookLibrary(loader.getProducts());
        } else {
            bookLibrary = new BookLibrary(new ArrayList<Product>());
        }

        //store = new Store();
        shoppingCart = new ShoppingCart();
    }
    public void exiting() {
        System.out.println("here now");
        for (User user: accountManager.getUsers()){
            System.out.println("First name: " + user.getFirstName());
            System.out.println("-----");
        }
        Saver saver = new Saver();
        saver.saveProducts(bookLibrary.getProducts());
        saver.saveUsers(accountManager.getUsers());
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }
}
