package Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainWindow {

    JFrame frame;
    JPanel panel;
    JTable table;
    JScrollPane scrollPane;
    String[] col;
    String[][] data;
    JButton button;
    JTextField textField;
    JLabel label;

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
        int totalData = data.length;



        table = new JTable(data, col);
        table.setBounds(30, 100, 200, 300);
        panel.add(table);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 100, 200, 300);
        panel.add(scrollPane);

        label = new JLabel("Pigeon ID");
        label.setBounds(300, 100, 100, 20);
        panel.add(label);

        textField = new JTextField(10);
        textField.setBounds(390, 100, 200, 20);
        String newID = textField.getText();
        panel.add(textField);

        label = new JLabel("Pigeon colour");
        label.setBounds(300, 120, 100, 20);
        String newColour = textField.getText();
        panel.add(label);

        textField = new JTextField(10);
        textField.setBounds(390, 120, 200, 20);
        panel.add(textField);

        button = new JButton("Add");
        button.setBounds(300, 140, 100, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    data[totalData][0] = newID;
                    data[totalData][1] = newColour;
                    System.out.println(data[totalData]);
                }catch(Exception x) {
                    x.printStackTrace();
                }
            }
        });


    }

    public void show(){
        frame.setVisible(true);
    }
}


