package Screens;

import org.example.Pigeons;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MainWindow {

    TableModel DefaultTableModel;
    JFrame frame;
    JPanel panel;
    JTable table;
    JScrollPane scrollPane;
    String[] col;
    String[][] data;
    JButton button;
    JTextField textField;
    JTextField textField2;
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

//        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//        ArrayList<Pigeons> list = Pigeons.data;

//        for (int i = 0; i < list.size(); i++) {
//            Object rowData = new Object[][]{{list.get(i).getPigeonID(), list.get(i).getPigeonColour()}};
//            tableModel.addRow(Object[] rowData);
//        }


        table = new JTable(DefaultTableModel);
        table.setBounds(30, 100, 200, 300);
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {"1234", "BB"}
                },
                new String [] {
                        "ID", "Colour"
                }
        ));
        panel.add(table);


        scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 100, 200, 300);
        scrollPane.setViewportView(table);
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
        panel.add(label);

        textField2 = new JTextField(10);
        textField2.setBounds(390, 120, 200, 20);
        panel.add(textField2);

        button = new JButton("Add");
        button.setBounds(300, 140, 100, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                    tableModel.addRow(new Object[]{textField.getText(), textField2.getText()});
                    System.out.println(tableModel);


                }catch(Exception x) {
                    x.printStackTrace();
                    System.out.println("NAH");
                }
            }
        });


    }

    public void show(){
        frame.setVisible(true);
    }
}


