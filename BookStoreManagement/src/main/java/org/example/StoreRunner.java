package org.example;

import org.example.UI.MainForm;
import org.example.UI.RegisterForm;
import org.example.UI.StoreForm;

import java.io.Writer;
import java.util.ArrayList;

public class StoreRunner {

    private AccountManager accountManager;
    private Catalog bookLibrary;
    private ProductManager bookManager;

    private DataReader loader;
    private DataWriter saver;

    public StoreRunner(DataReader loader, DataWriter saver) {
       this.loader = loader;
       this.saver = saver;
       setup();
    }
    public void run() {
        RegisterForm registerForm = new RegisterForm(accountManager);
        MainForm mainForm = new MainForm(registerForm, this, bookLibrary);
    }
    private void setup() {
        loader.readUsers();
        loader.readProducts();
        if (!(loader.getUsers() == null)) {
            accountManager = new AccountManager(loader.getUsers());
        } else {
            accountManager = new AccountManager(new ArrayList<User>());
        }

        bookManager = new BookManager();
        if (!(loader.getProducts() == null)) {
            bookLibrary = new BookLibrary(loader.getProducts());
        } else {
            bookLibrary = new BookLibrary(new ArrayList<>());
        }

    }
    public void exiting() {
        saver.saveProducts(bookLibrary.getProducts());
        saver.saveUsers(accountManager.getUsers());
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }
}
