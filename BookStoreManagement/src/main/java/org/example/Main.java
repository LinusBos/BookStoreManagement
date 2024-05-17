package org.example;

import org.example.UI.MainForm;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StoreRunner storeRunner = new StoreRunner(new Loader(), new Saver());
        storeRunner.run();
    }
}