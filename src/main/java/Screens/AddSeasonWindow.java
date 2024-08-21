package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Pigeons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddSeasonWindow {
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private List<String> seasonName;
    private List<String> currentSeasonName;
    private Gson gson;

    public AddSeasonWindow() {
        gson = new Gson();
        seasonName = new ArrayList<>();
        currentSeasonName = new ArrayList<>();

        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Judels Pigeon Manager|Add Season");
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        button = new JButton("Back");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(0, 0, 80, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UpdateScoresWindow update = new UpdateScoresWindow();
                update.show();
            }
        });

        textField = new JTextField("New Season Name");
        textField.setBounds(110, 30, 160, 20);
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("New Season Name")) {}
                    textField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField.getText().equals(""))
                    textField.setText("New Season Name");
            }
        });
        panel.add(textField);
        button = new JButton("Add");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(270, 30, 80, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seasonName.add(textField.getText());
                currentSeasonName.add(textField.getText());
                saveJsonToFileSeasons();


                try {
                    File myObj2 = new File("src/"+currentSeasonName.get(0)+"RaceData.json");
                    if (myObj2.createNewFile()) {
                        System.out.println("File created: " + myObj2.getName());
                    } else {
                        System.out.println("File already exists djou moegoe.");
                    }
                } catch (IOException ee) {
                    System.out.println("An error occurred. EISHHH!");
                }

                try {
                    File myObj3 = new File("src/"+currentSeasonName.get(0)+"Races.json");
                    if (myObj3.createNewFile()) {
                        System.out.println("File created: " + myObj3.getName());
                    } else {
                        System.out.println("File already exists djou moegoe.");
                    }
                } catch (IOException ee) {
                    System.out.println("An error occurred. EISHHH!");
                }


                //gui fields back to default
                textField.setText("");
                currentSeasonName.clear();
            }
        });
    }

    private void saveJsonToFileSeasons() {
        try {
            // Read existing data
            java.util.List<String> existingData = new ArrayList<>();
            Type pigeonListType = new TypeToken<List<String>>() {}.getType();
            try (Reader reader = new FileReader("src/Seasons.json")) {
                existingData = gson.fromJson(reader, pigeonListType);
                if (existingData == null) {
                    existingData = new ArrayList<>();
                }
            } catch (FileNotFoundException e) {
                // File not found, initialize with empty list
            }

            // Add new data
            existingData.addAll(seasonName);

            // Write updated data
            try (FileWriter writer = new FileWriter("src/Seasons.json")) {
                gson.toJson(existingData, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void show() {
        frame.setVisible(true);
    }
}
