package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Pigeons;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
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
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JLabel label;
    private Gson gson;
    private List<Pigeons> pigeonsData;
    private JTextField textField3;
    JMenu menu, submenu;
    JMenuItem i1, i2, i3, i4, i5, i6;

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

        button = new JButton("Team");
        button.setBackground(Color.CYAN);
        button.setEnabled(false);
        button.setBounds(0, 0, 80, 30);
        panel.add(button);

        button = new JButton("Add");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(90, 0, 80, 30);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddPigeonWindow add = new AddPigeonWindow();
                add.show();
            }
        });

        tableModel = new DefaultTableModel(new String[]{"ID", "Calling Card", "Year", "Score", "Score Odds", "Wins"}, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 500, 200);

        // Load data into the table
        for (Pigeons pigeon : pigeonsData) {
            tableModel.addRow(new Object[]{pigeon.getPigeonID(), pigeon.getPigeonCallingCard(),
                    pigeon.getPigeonYear(), pigeon.getPigeonScore(), pigeon.getPigeonScorePercentage(), pigeon.getPigeonWins()});
        }

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 50, 200, 300);
        scrollPane.setSize(700,500);
        panel.add(scrollPane);
//
//        label = new JLabel("Pigeon ID");
//        label.setBounds(450, 100, 100, 20);
//        panel.add(label);
//
//        textField = new JTextField(10);
//        textField.setBounds(590, 100, 200, 20);
//        panel.add(textField);
//
//        label = new JLabel("Pigeon Calling Card");
//        label.setBounds(450, 120, 150, 20);
//        panel.add(label);
//
//        textField2 = new JTextField(10);
//        textField2.setBounds(590, 120, 200, 20);
//        panel.add(textField2);
//
//        label = new JLabel("Pigeon Year");
//        label.setBounds(450, 140, 100, 20);
//        panel.add(label);
//
//        textField3 = new JTextField(10);
//        textField3.setBounds(590, 140, 200, 20);
//        panel.add(textField3);
//
//        label = new JLabel("Pigeon Score");
//        label.setBounds(450, 160, 100, 20);
//        panel.add(label);
//
//        textField4 = new JTextField(10);
//        textField4.setBounds(590, 160, 200, 20);
//        textField4.setText("00");
//        panel.add(textField4);
//
//        label = new JLabel("Pigeon Score Percentage");
//        label.setBounds(440, 180, 160, 20);
//        panel.add(label);
//
//        textField5 = new JTextField(10);
//        textField5.setBounds(590, 180, 200, 20);
//        textField5.setText("00");
//        panel.add(textField5);
//
//        label = new JLabel("Pigeon wins");
//        label.setBounds(450, 200, 100, 20);
//        panel.add(label);
//
//        textField6 = new JTextField(10);
//        textField6.setBounds(590, 200, 200, 20);
//        textField6.setText("00");
//        panel.add(textField6);
//
//        label = new JLabel("Pigeon Father");
//        label.setBounds(450, 220, 100, 20);
//        panel.add(label);
//
//        textField7 = new JTextField(10);
//        textField7.setBounds(590, 220, 200, 20);
//        panel.add(textField7);
//
//        label = new JLabel("Pigeon Mother");
//        label.setBounds(450, 240, 100, 20);
//        panel.add(label);
//
//        textField8 = new JTextField(10);
//        textField8.setBounds(590, 240, 200, 20);
//        panel.add(textField8);
//
//        label = new JLabel("Pigeon Colour");
//        label.setBounds(450, 260, 100, 20);
//        panel.add(label);
//
//        textField9 = new JTextField(10);
//        textField9.setBounds(590, 260, 200, 20);
//        panel.add(textField9);
//
//        label = new JLabel("Pigeon Gender");
//        label.setBounds(450, 280, 100, 20);
//        panel.add(label);
//
//        textField10 = new JTextField(10);
//        textField10.setBounds(590, 280, 200, 20);
//        panel.add(textField10);
//
//        label = new JLabel("Pigeon Letters");
//        label.setBounds(450, 300, 100, 20);
//        panel.add(label);
//
//        textField11 = new JTextField(10);
//        textField11.setBounds(590, 300, 200, 20);
//        panel.add(textField11);
//
//        label = new JLabel("Pigeon Weaned");
//        label.setBounds(450, 320, 100, 20);
//        panel.add(label);
//
//        textField12 = new JTextField(10);
//        textField12.setBounds(590, 320, 200, 20);
//        panel.add(textField12);
//
//
//        button = new JButton("Add");
//        button.setBounds(450, 350, 100, 20);
//        panel.add(button);
//
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    // Get input from text fields
//                    String id = textField.getText();
//                    String callingCard = textField2.getText();
//                    String year = textField3.getText();
//                    int score = Integer.parseInt(textField4.getText());
//                    double scorePercentage = Double.parseDouble(textField5.getText());
//                    int wins = Integer.parseInt(textField6.getText());
//                    String father = textField7.getText();
//                    String mother = textField8.getText();
//                    String colour = textField9.getText();
//                    String gender = textField10.getText();
//                    String letters = textField11.getText();
//                    String weaned = textField12.getText();
//
//                    // Add to table
//                    tableModel.addRow(new Object[]{id, callingCard, year, score, scorePercentage, wins});
//
//                    // Add to the pigeons data list
//                    Pigeons pigeon = new Pigeons(id, callingCard, year, score, scorePercentage, wins, father, mother, colour, gender, letters, weaned);
//                    pigeonsData.add(pigeon);
//
//                    // Save updated data to JSON file
//                    saveJsonToFile();
//
//                    // Clear input fields
//                    textField.setText("");
//                    textField2.setText("");
//                    textField3.setText("");
//                    textField4.setText("");
//                    textField5.setText("");
//                    textField6.setText("");
//                    textField7.setText("");
//                    textField8.setText("");
//                    textField9.setText("");
//                    textField10.setText("");
//                    textField11.setText("");
//                    textField12.setText("");
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
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

    public void show() {
        frame.setVisible(true);
    }
}
