package Screens;

import com.google.gson.Gson;
import org.example.Pigeons;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddPigeonWindow {

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

    AddPigeonWindow() {
        gson = new Gson();
        pigeonsData = new ArrayList<>();

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
        button.setEnabled(true);
        button.setBounds(0, 0, 80, 30);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainWindow main = new MainWindow();
                main.show();
            }
        });

        button = new JButton("Add");
        button.setBackground(Color.CYAN);
        button.setEnabled(false);
        button.setBounds(90, 0, 80, 30);
        panel.add(button);


//Pigeon ID Input
        textField = new JTextField("Pigeon ID");
        textField.setBounds(20, 100, 100, 20);
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Pigeon ID"))
                    textField.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField.getText().equals(""))
                    textField.setText("Pigeon ID");
            }
        });
        panel.add(textField);
//--------
//Calling Card Input
        textField2 = new JTextField("Calling Card");
        textField2.setBounds(140, 100, 100, 20);
        textField2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField2.getText().equals("Calling Card"))
                    textField2.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField2.getText().equals(""))
                    textField2.setText("Calling Card");
            }
        });
        panel.add(textField2);
//----------
//Year Input
        textField3 = new JTextField("Year");
        textField3.setBounds(260, 100, 100, 20);
        textField3.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField3.getText().equals("Year"))
                    textField3.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField3.getText().equals(""))
                    textField3.setText("Year");
            }
        });
        panel.add(textField3);
//----------
//Score Input
        textField4 = new JTextField("Score");
        textField4.setBounds(20, 150, 100, 20);
        textField4.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField4.getText().equals("Score"))
                    textField4.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField4.getText().equals(""))
                    textField4.setText("Score");
            }
        });
        panel.add(textField4);
//----------
//Score Percentage
        textField5 = new JTextField("Score Percentage");
        textField5.setBounds(140, 150, 100, 20);
        textField5.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField5.getText().equals("Score Percentage"))
                    textField5.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField5.getText().equals(""))
                    textField5.setText("Score Percentage");
            }
        });
        panel.add(textField5);
//---------------
//Wins Input
        textField6 = new JTextField("Wins");
        textField6.setBounds(260, 150, 100, 20);
        textField6.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField6.getText().equals("Wins"))
                    textField6.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField6.getText().equals(""))
                    textField6.setText("Wins");
            }
        });
        panel.add(textField6);
//----------------
//Father Input
        textField7 = new JTextField("Father");
        textField7.setBounds(380, 150, 100, 20);
        textField7.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField7.getText().equals("Father"))
                    textField7.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField7.getText().equals(""))
                    textField7.setText("Father");
            }
        });
        panel.add(textField7);
//-----------
//Mother Input
        textField8 = new JTextField("Mother");
        textField8.setBounds(500, 150, 100, 20);
        textField8.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField8.getText().equals("Mother"))
                    textField8.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField8.getText().equals(""))
                    textField8.setText("Mother");
            }
        });
        panel.add(textField8);
//---------
//Colour Input
        textField9 = new JTextField("Colour");
        textField9.setBounds(620, 100, 100, 20);
        textField9.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField9.getText().equals("Colour"))
                    textField9.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField9.getText().equals(""))
                    textField9.setText("Colour");
            }
        });
        panel.add(textField9);
//------------
//Gender Input
        textField10 = new JTextField("Gender");
        textField10.setBounds(500, 100, 100, 20);
        textField10.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField10.getText().equals("Gender"))
                    textField10.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField10.getText().equals(""))
                    textField10.setText("Gender");
            }
        });
        panel.add(textField10);
//-----------
//Letters Input
        textField11 = new JTextField("Letters");
        textField11.setBounds(380, 100, 100, 20);
        textField11.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField11.getText().equals("Letters"))
                    textField11.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField11.getText().equals(""))
                    textField11.setText("Letters");
            }
        });
        panel.add(textField11);
//---------
//weaned Input
        textField12 = new JTextField("Date Weaned");
        textField12.setBounds(620, 150, 100, 20);
        textField12.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField12.getText().equals("Date Weaned"))
                    textField12.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (textField12.getText().equals(""))
                    textField12.setText("Date Weaned");
            }
        });
        panel.add(textField12);
//----------

        button = new JButton("Add");
        button.setBounds(320, 200, 100, 20);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input from text fields
                    String id = textField.getText();
                    String callingCard = textField2.getText();
                    String year = textField3.getText();
                    int score = Integer.parseInt(textField4.getText());
                    double scorePercentage = Double.parseDouble(textField5.getText());
                    int wins = Integer.parseInt(textField6.getText());
                    String father = textField7.getText();
                    String mother = textField8.getText();
                    String colour = textField9.getText();
                    String gender = textField10.getText();
                    String letters = textField11.getText();
                    String weaned = textField12.getText();

                    // Add to the pigeons data list
                    Pigeons pigeon = new Pigeons(id, callingCard, year, score, scorePercentage, wins, father, mother, colour, gender, letters, weaned);
                    pigeonsData.add(pigeon);

                    // Save updated data to JSON file
                    saveJsonToFile();

                    // Clear input fields
                    textField.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                    textField6.setText("");
                    textField7.setText("");
                    textField8.setText("");
                    textField9.setText("");
                    textField10.setText("");
                    textField11.setText("");
                    textField12.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
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
