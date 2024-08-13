//package Screens;
//
//import org.example.Pigeons;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class MainWindow {
//
//    TableModel DefaultTableModel;
//    JFrame frame;
//    JPanel panel;
//    JTable table;
//    JScrollPane scrollPane;
//    String[] col;
//    String[][] data;
//    JButton button;
//    JTextField textField;
//    JTextField textField2;
//    JLabel label;
//
//    public MainWindow() {
//        frame = new JFrame();
//        frame.setSize(800, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setTitle("JudelsPIgeonManager");
//
////this is a panel
//        panel = new JPanel();
//        panel.setLayout(null);
//        frame.add(panel);
//        col = new String[]{"Pigeon ID", "Pigeon colour"};
//        data = new String[][]{{"3333", "BB"}, {"1234", "CH"}, {"2533", "BB"}};
//        Pigeons.data.add(new Pigeons("1234", "BB"));
//        Pigeons.data.add(new Pigeons("1224", "CH"));
//        Pigeons.data.add(new Pigeons("2533", "BB"));
//        int totalData = Pigeons.data.size();
//        System.out.println(Arrays.stream(Pigeons.data.toArray()).count());
//        System.out.println(Arrays.stream(data).count());
//
//        table = new JTable(DefaultTableModel);
//        table.setBounds(30, 100, 200, 300);
//        table.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {"1234","BB"}
//                },
//                new String [] {
//                        "ID", "Colour"
//                }
//        ));
//        panel.add(table);
//
//
//        scrollPane = new JScrollPane();
//        scrollPane.setBounds(30, 100, 200, 300);
//        scrollPane.setViewportView(table);
//        panel.add(scrollPane);
//
//        label = new JLabel("Pigeon ID");
//        label.setBounds(300, 100, 100, 20);
//        panel.add(label);
//
//        textField = new JTextField(10);
//        textField.setBounds(390, 100, 200, 20);
//        String newID = textField.getText();
//        panel.add(textField);
//
//        label = new JLabel("Pigeon colour");
//        label.setBounds(300, 120, 100, 20);
//        panel.add(label);
//
//        textField2 = new JTextField(10);
//        textField2.setBounds(390, 120, 200, 20);
//        panel.add(textField2);
//
//        button = new JButton("Add");
//        button.setBounds(300, 140, 100, 20);
//        panel.add(button);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//                    tableModel.addRow(new Object[]{textField.getText(), textField2.getText()});
//                    System.out.println(tableModel);
//
//
//                }catch(Exception x) {
//                    x.printStackTrace();
//                    System.out.println("NAH");
//                }
//            }
//        });
//
//
//    }
//
//    public void show(){
//        frame.setVisible(true);
//    }
//}
//
//
package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Pigeons;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {

    private DefaultTableModel tableModel;
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton button;
    private JTextField textField;
    private JTextField textField2;
    private JLabel label;
    private Gson gson;
    private List<Pigeons> pigeonsData;
    private String jsonFilePath = "pigeons.json"; // JSON file path

    public MainWindow() {
        gson = new Gson();
        pigeonsData = new ArrayList<>();

        // Load data from JSON file
        loadJsonFromFile();

        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("JudelsPigeonManager");

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        tableModel = new DefaultTableModel(new String[]{"Pigeon ID", "Pigeon Colour"}, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 200, 300);

        // Load data into the table
        for (Pigeons pigeon : pigeonsData) {
            tableModel.addRow(new Object[]{pigeon.getPigeonID(), pigeon.getPigeonColour()});
        }

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 100, 200, 300);
        panel.add(scrollPane);

        label = new JLabel("Pigeon ID");
        label.setBounds(300, 100, 100, 20);
        panel.add(label);

        textField = new JTextField(10);
        textField.setBounds(390, 100, 200, 20);
        panel.add(textField);

        label = new JLabel("Pigeon Colour");
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
                    // Get input from text fields
                    String id = textField.getText();
                    String colour = textField2.getText();

                    // Add to table
                    tableModel.addRow(new Object[]{id, colour});

                    // Add to the pigeons data list
                    Pigeons pigeon = new Pigeons(id, colour);
                    pigeonsData.add(pigeon);

                    // Save updated data to JSON file
                    saveJsonToFile();

                    // Clear input fields
                    textField.setText("");
                    textField2.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void loadJsonFromFile() {
        try (FileReader reader = new FileReader("src/pigeons.json")) {
            Type listType = new TypeToken<ArrayList<Pigeons>>() {}.getType();
            pigeonsData = gson.fromJson(reader, listType);

            if (pigeonsData == null) {
                pigeonsData = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            pigeonsData = new ArrayList<>();
        }
    }

    private void saveJsonToFile() {
        try (FileWriter writer = new FileWriter("src/pigeons.json")) {
            gson.toJson(pigeonsData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        frame.setVisible(true);
    }
}
