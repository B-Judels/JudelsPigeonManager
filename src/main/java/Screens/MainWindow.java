package Screens;

import org.example.Pigeons;

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
        data = new String[][]{{"3333", "BB"}, {"1234", "CH"}, {"2533", "BB"}};
        Pigeons.data.add(new Pigeons("1234", "BB"));
        Pigeons.data.add(new Pigeons("1224", "CH"));
        Pigeons.data.add(new Pigeons("2533", "BB"));
        int totalData = Pigeons.data.size();
        System.out.println(Arrays.stream(Pigeons.data.toArray()).count());
        System.out.println(Arrays.stream(data).count());



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


