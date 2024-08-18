package Screens;

import com.google.gson.Gson;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


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
    private List<BreedingPigeons> breedPigeonsData;
    private List<BreedingPigeons> breedPigeonsData2;
    private JTextField textField3;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu menu2;
    private JMenuItem menuItem;
    private String gC1;
    private String gC2;
    private String gC3;
    private String gC4;
    private String gC5;
    private String gC6;
    private String gC7;
    private String gC8;
    private JMenuBar colorMenuBar;
    private JMenu colorMenu;
    private JMenuBar genderMenuBar;
    private JMenu genderMenu;
    private JMenuItem c1, c2, c3, c4, c5, c6, c7, c8, c9, g1, g2;

    AddPigeonWindow() {
        gson = new Gson();
        pigeonsData = new ArrayList<>();
        breedPigeonsData = new ArrayList<>();
        breedPigeonsData2 = new ArrayList<>();
        loadJsonFromFileFather();
        loadJsonFromFileMother();

        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("JudelsPigeonManager");

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
                MainWindow main = new MainWindow();
                main.show();
            }
        });

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
        textField4 = new JTextField("Times Scored");
        textField4.setBounds(140, 150, 100, 20);
        textField4.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField4.getText().equals("Times Scored"))
                    textField4.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField4.getText().equals(""))
                    textField4.setText("Times Scored");
            }
        });
        panel.add(textField4);
//----------
//Score Percentage
        textField5 = new JTextField("Times Flyed");
        textField5.setBounds(20, 150, 100, 20);
        textField5.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField5.getText().equals("Times Flyed"))
                    textField5.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField5.getText().equals(""))
                    textField5.setText("Times Flyed");
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
        menuBar = new JMenuBar();
        menuBar.setBounds(380, 150, 100, 20);
        menu = new JMenu("Father");
                for (int i = 0; i < breedPigeonsData.size(); i++){
                    menuItem = new JMenuItem();
                    menuItem.setText(breedPigeonsData.get(i).getBPigeonName());
                    System.out.println("the name: " + breedPigeonsData.get(i).getBPigeonName());
                    menu.add(menuItem);
                    menuItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            for (int i = 0; i < breedPigeonsData.size(); i++){
                                menu.setText(breedPigeonsData.get(i).getBPigeonName());
                                gC1 = breedPigeonsData.get(i).getBGeneticCode1();
                                gC2 = breedPigeonsData.get(i).getBGeneticCode2();
                                gC3 = breedPigeonsData.get(i).getBGeneticCode3();
                                gC4 = breedPigeonsData.get(i).getBGeneticCode4();

                            }

                        }
                    });}

        menuBar.add(menu);
        panel.add(menuBar);


//-----------
//Mother Input
        menuBar = new JMenuBar();
        menuBar.setBounds(500, 150, 100, 20);
        menu2 = new JMenu("Mother");
        for (int i = 0; i < breedPigeonsData2.size(); i++){
            menuItem = new JMenuItem();
            menuItem.setText(breedPigeonsData2.get(i).getBPigeonName());
            System.out.println("the name: " + breedPigeonsData2.get(i).getBPigeonName());
            menu2.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < breedPigeonsData2.size(); i++){
                        menu2.setText(breedPigeonsData2.get(i).getBPigeonName());
                        gC5 = breedPigeonsData2.get(i).getBGeneticCode1();
                        gC6 = breedPigeonsData2.get(i).getBGeneticCode2();
                        gC7 = breedPigeonsData2.get(i).getBGeneticCode3();
                        gC8 = breedPigeonsData2.get(i).getBGeneticCode4();
                    }

                }
            });}

        menuBar.add(menu2);
        panel.add(menuBar);

//---------
//Colour Input
        colorMenuBar = new JMenuBar();
        colorMenu = new JMenu("Color");
        c1 = new JMenuItem();
        c1.setText("BB");
        c2 = new JMenuItem();
        c2.setText("CH");
        c3 = new JMenuItem();
        c3.setText("BBWF");
        c4 = new JMenuItem();
        c4.setText("CHWF");
        c5 = new JMenuItem();
        c5.setText("BBPD");
        c6 = new JMenuItem();
        c6.setText("CHPD");
        c7 = new JMenuItem();
        c7.setText("BLCK");
        c8 = new JMenuItem();
        c8.setText("RED");
        c9 = new JMenuItem();
        c9.setText("MEAL");
        colorMenu.add(c1);
        colorMenu.add(c2);
        colorMenu.add(c3);
        colorMenu.add(c4);
        colorMenu.add(c5);
        colorMenu.add(c6);
        colorMenu.add(c7);
        colorMenu.add(c8);
        colorMenu.add(c9);
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BB");
            }
        });
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("CH");
            }
        });
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BBWF");
            }
        });
        c4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("CHWF");
            }
        });
        c5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BBPD");
            }
        });
        c6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("CHPD");
            }
        });
        c7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BL");
            }
        });
        c8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("RED");
            }
        });
        c9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("MEAL");
            }
        });
        colorMenuBar.add(colorMenu);
        colorMenuBar.setBounds(620, 100, 100, 20);
        panel.add(colorMenuBar);
//------------
//Gender Input

        genderMenuBar = new JMenuBar();
        genderMenuBar.setBounds(500, 100, 100, 20);
        genderMenu = new JMenu("Gender");
        g1 = new JMenuItem();
        g1.setText("C");
        g1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderMenu.setText("C");
            }
        });
        g2 = new JMenuItem();
        g2.setText("H");
        g2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderMenu.setText("H");
            }
        });
        genderMenu.add(g1);
        genderMenu.add(g2);
        genderMenuBar.add(genderMenu);
        panel.add(genderMenuBar);


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
                    int score = Integer.parseInt(textField4.getText());
                    int flyed = Integer.parseInt(textField5.getText());
                    double scoreOdss = (Double.parseDouble(String.valueOf(score)) / Double.parseDouble(String.valueOf(flyed))) * 100;
                    System.out.println("score " + score);
                    System.out.println("flyed " + flyed);
                    System.out.println("scorePercentage " + scoreOdss);
                    int wins = Integer.parseInt(textField6.getText());
                    String father = menu.getText();
                    String mother = menu2.getText();
                    String colour = colorMenu.getText();
                    String gender = genderMenu.getText();
                    String letters = textField11.getText();
                    String weaned = textField12.getText();
                    //---------
                    // Add to the pigeons data list
                    Pigeons pigeon = new Pigeons(id, callingCard, year, score, scoreOdss, wins, father, mother, colour, gender, letters, weaned, flyed,
                            gC1, gC2, gC3, gC4, gC5, gC6, gC7, gC8);
                    pigeonsData.add(pigeon);
                    //----------
                    // Save updated data to JSON file
                    saveJsonToFile();
                    //------------
                    // Set Input Fields Back To Default
                    textField.setText("Pigeon ID");
                    textField2.setText("Calling Card");
                    textField3.setText("Year");
                    textField4.setText("Times Scored");
                    textField5.setText("Times Flyed");
                    textField6.setText("Wins");
                    colorMenu.setText("Colour");
                    menu.setText("Father");
                    menu2.setText("Mother");
                    genderMenu.setText("Gender");
                    textField11.setText("Letters");
                    textField12.setText("Date Weaned");
                    //----
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void loadJsonFromFileFather() {
        try (FileReader reader = new FileReader("src/Fathers.json")) {
            Type listType = new TypeToken<ArrayList<BreedingPigeons>>() {
            }.getType();
            breedPigeonsData = gson.fromJson(reader, listType);

            if (breedPigeonsData == null) {
                breedPigeonsData = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            breedPigeonsData = new ArrayList<>();
        }
    }

    private void loadJsonFromFileMother() {
        try (FileReader reader2 = new FileReader("src/Mothers.json")) {
            Type listType2 = new TypeToken<ArrayList<BreedingPigeons>>() {
            }.getType();
            breedPigeonsData2 = gson.fromJson(reader2, listType2);

            if (breedPigeonsData2 == null) {
                breedPigeonsData2 = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            breedPigeonsData2 = new ArrayList<>();
        }
    }

//Save New Pigeons To json file
    private void saveJsonToFile() {
        try {
            // Read existing data
            List<Pigeons> existingData = new ArrayList<>();
            Type pigeonListType = new TypeToken<List<Pigeons>>() {}.getType();
            try (Reader reader = new FileReader("src/pigeons.json")) {
                existingData = gson.fromJson(reader, pigeonListType);
                if (existingData == null) {
                    existingData = new ArrayList<>();
                }
            } catch (FileNotFoundException e) {
                // File not found, initialize with empty list
            }

            // Add new data
            existingData.addAll(pigeonsData);

            // Write updated data
            try (FileWriter writer = new FileWriter("src/pigeons.json")) {
                gson.toJson(existingData, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//-----------
//Set AddPigeonWindow visible
    public void show() {
        frame.setVisible(true);
    }
}
//---------