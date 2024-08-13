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
    private JTextField textField3;

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

        tableModel = new DefaultTableModel(new String[]{"Pigeon ID", "Pigeon Colour", "Pigeon Gender"}, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 200, 300);

        // Load data into the table
        for (Pigeons pigeon : pigeonsData) {
            tableModel.addRow(new Object[]{pigeon.getPigeonID(), pigeon.getPigeonColour(), pigeon.getPigeonGender()});
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

        label = new JLabel("Pigeon Gender");
        label.setBounds(300, 140, 100, 20);
        panel.add(label);

        textField3 = new JTextField(10);
        textField3.setBounds(390, 140, 200, 20);
        panel.add(textField3);

        button = new JButton("Add");
        button.setBounds(300, 170, 100, 20);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input from text fields
                    String id = textField.getText();
                    String colour = textField2.getText();
                    String gender = textField3.getText();

                    // Add to table
                    tableModel.addRow(new Object[]{id, colour, gender});

                    // Add to the pigeons data list
                    Pigeons pigeon = new Pigeons(id, colour, gender);
                    pigeonsData.add(pigeon);

                    // Save updated data to JSON file
                    saveJsonToFile();

                    // Clear input fields
                    textField.setText("");
                    textField2.setText("");
                    textField3.setText("");

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
