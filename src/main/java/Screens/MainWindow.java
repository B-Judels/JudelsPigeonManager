package Screens;

import javax.swing.*;

public class MainWindow {

    JFrame frame;
    JPanel panel;
    JTable table;
    JScrollPane scrollPane;
    String[] col;
    String[][] data;

    public MainWindow() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("JudelsPIgeonManager");

//this is a panel
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        col = new String[]{"Pigeon ID", "Pigeon colour"};
        data = new String[][]{{"1234", "BB"}, {"1111", "CH"}, {"5555", "BBWF"}};

        table = new JTable(data, col);
        table.setBounds(30, 100, 200, 300);
        panel.add(table);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 100, 200, 300);
        panel.add(scrollPane);

    }

    public void show(){
        frame.setVisible(true);
    }
}


