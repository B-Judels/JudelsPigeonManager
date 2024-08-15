package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.BreedingPigeons;
import org.example.Pigeons;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddBreedersWindow {

    private DefaultTableModel tableModel;
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JButton button;
    private JButton button1;
    private Gson gson;
    private List<BreedingPigeons> breedPigeonsData;
    private List<BreedingPigeons> breedPigeonsData2;


    public AddBreedersWindow() {
        gson = new Gson();
        breedPigeonsData = new ArrayList<>();
        breedPigeonsData2 = new ArrayList<>();


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
        button.setBounds(0, 0, 80, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainWindow main = new MainWindow();
                main.show();
            }
        });

        button = new JButton("Add Pigeon");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(90, 0, 120, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddPigeonWindow add = new AddPigeonWindow();
                add.show();
            }
        });

        button = new JButton("Add Breeder");
        button.setBackground(Color.CYAN);
        button.setEnabled(false);
        button.setBounds(220, 0, 120, 20);
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
        textField2 = new JTextField("Name");
        textField2.setBounds(140, 100, 100, 20);
        textField2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField2.getText().equals("Name"))
                    textField2.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField2.getText().equals(""))
                    textField2.setText("Name");
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
//Colour Input
        textField4 = new JTextField("Colour");
        textField4.setBounds(620, 100, 100, 20);
        textField4.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField4.getText().equals("Colour"))
                    textField4.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField4.getText().equals(""))
                    textField4.setText("Colour");
            }
        });
        panel.add(textField4);
//------------
//Letters Input
        textField6 = new JTextField("Letters");
        textField6.setBounds(380, 100, 100, 20);
        textField6.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField6.getText().equals("Letters"))
                    textField6.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField6.getText().equals(""))
                    textField6.setText("Letters");
            }
        });
        panel.add(textField6);
//---------

//Button so add all input text to Data List
        button = new JButton("Add");
        button.setBounds(320, 200, 100, 20);
        panel.add(button);
//----------
        //Action Listener For Add Button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input from text fields
                    String id = textField.getText();
                    String callingCard = textField2.getText();
                    String year = textField3.getText();
                    String colour = textField4.getText();
                    String gender = "C";
                    String letters = textField6.getText();

                    //---------
                    // Add to the pigeons data list
                    BreedingPigeons breedPigeon = new BreedingPigeons(id, callingCard, year, letters, gender, colour);
                    breedPigeonsData.add(breedPigeon);
                    //----------
                    System.out.println(gender);
                    // Save updated data to JSON file
                        saveJsonToFileFather();
                    //------------
                    // Set Input Fields Back To Default
                    textField.setText("Pigeon ID");
                    textField2.setText("Name");
                    textField3.setText("Year");
                    textField4.setText("Colour");
                    textField6.setText("Letters");
                    //----
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


//mother input
        //Pigeon ID Input
        textField7 = new JTextField("Pigeon ID");
        textField7.setBounds(20, 300, 100, 20);
        textField7.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField7.getText().equals("Pigeon ID"))
                    textField7.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField7.getText().equals(""))
                    textField7.setText("Pigeon ID");
            }
        });
        panel.add(textField7);
//--------
//Calling Card Input
        textField8 = new JTextField("Name");
        textField8.setBounds(140, 300, 100, 20);
        textField8.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField8.getText().equals("Name"))
                    textField8.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField8.getText().equals(""))
                    textField8.setText("Name");
            }
        });
        panel.add(textField8);
//----------
//Year Input
        textField9 = new JTextField("Year");
        textField9.setBounds(260, 300, 100, 20);
        textField9.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField9.getText().equals("Year"))
                    textField9.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField9.getText().equals(""))
                    textField9.setText("Year");
            }
        });
        panel.add(textField9);
//----------
//Colour Input
        textField10 = new JTextField("Colour");
        textField10.setBounds(620, 300, 100, 20);
        textField10.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField10.getText().equals("Colour"))
                    textField10.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField10.getText().equals(""))
                    textField10.setText("Colour");
            }
        });
        panel.add(textField10);
//------------

//-----------
//Letters Input
        textField12 = new JTextField("Letters");
        textField12.setBounds(380, 300, 100, 20);
        textField12.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField12.getText().equals("Letters"))
                    textField12.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField12.getText().equals(""))
                    textField12.setText("Letters");
            }
        });
        panel.add(textField12);
//---------

//Button so add all input text to Data List
        button1 = new JButton("Add");
        button1.setBounds(320, 400, 100, 20);
        panel.add(button1);
//----------
        //Action Listener For Add Button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input from text fields
                    String id2 = textField7.getText();
                    String callingCard2 = textField8.getText();
                    String year2 = textField9.getText();
                    String colour2 = textField10.getText();
                    String gender2 = "H";
                    String letters2 = textField12.getText();

                    //---------
                    // Add to the pigeons data list
                    BreedingPigeons breedPigeon2 = new BreedingPigeons(id2, callingCard2, year2, letters2, gender2, colour2);
                    breedPigeonsData2.add(breedPigeon2);
                    //----------
                    System.out.println(gender2);
                    // Save updated data to JSON file
                    saveJsonToFileMother();
                    //------------
                    // Set Input Fields Back To Default
                    textField7.setText("Pigeon ID");
                    textField8.setText("Name");
                    textField9.setText("Year");
                    textField10.setText("Colour");
                    textField12.setText("Letters");
                    //----
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
//Save New Pigeon To father json file
private void saveJsonToFileFather() {
    try {
        // Read existing data
        List<BreedingPigeons> existingData = new ArrayList<>();
        Type pigeonListType = new TypeToken<List<BreedingPigeons>>() {}.getType();
        try (Reader reader = new FileReader("src/Fathers.json")) {
            existingData = gson.fromJson(reader, pigeonListType);
            if (existingData == null) {
                existingData = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            // File not found, initialize with empty list
        }

        // Add new data
        existingData.addAll(breedPigeonsData);

        // Write updated data
        try (FileWriter writer = new FileWriter("src/Fathers.json")) {
            gson.toJson(existingData, writer);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
//-----------

    //Save New Pigeon To father json file
    private void saveJsonToFileMother() {
        try {
            // Read existing data
            List<BreedingPigeons> existingData2 = new ArrayList<>();
            Type pigeonListType2 = new TypeToken<List<BreedingPigeons>>() {}.getType();
            try (Reader reader2 = new FileReader("src/Mothers.json")) {
                existingData2 = gson.fromJson(reader2, pigeonListType2);
                if (existingData2 == null) {
                    existingData2 = new ArrayList<>();
                }
            } catch (FileNotFoundException e) {
                // File not found, initialize with empty list
            }

            // Add new data
            existingData2.addAll(breedPigeonsData2);

            // Write updated data
            try (FileWriter writer2 = new FileWriter("src/Mothers.json")) {
                gson.toJson(existingData2, writer2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//-----------

//Set AddBreederWindow visible
public void show() {
    frame.setVisible(true);
}
}
//---------
