package Screens;

import javax.swing.*;

public class MainWindow {

    JFrame frame;
    JPanel panel;
    JTable table;

    public MainWindow() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("JudelsPIgeonManager");


        panel = new JPanel();
        frame.add(panel);

        table = new JTable(1,4);
        panel.add(table);

    }

    public void show(){
        frame.setVisible(true);
    }
}


