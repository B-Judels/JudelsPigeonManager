package org.example;

import Screens.MainWindow;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow main = new MainWindow();
                main.show();
            }
        });
    }
}