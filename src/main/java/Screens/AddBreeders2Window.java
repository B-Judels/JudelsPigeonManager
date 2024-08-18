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

public class AddBreeders2Window {

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
    private List<BreedingPigeons> breedPigeonsData2;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuBar menuBar2;
    private JMenu menu2;
    private JMenuBar menuBar3;
    private JMenu menu3;
    private JMenuBar menuBar4;
    private JMenu menu4;
    private JMenuItem gene1, c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
    private JMenuItem gene2;
    private JMenuItem gene3;
    private JMenuItem gene4;
    private JMenuItem gene5;
    private JMenuItem gene6;
    private JMenuItem gene7;
    private JMenuItem gene8;
    private JMenuItem gene9;
    private JMenuItem gene10;
    private JMenuItem gene11;
    private JMenuItem gene12;
    private JMenuItem gene13;
    private JMenu colorMenu;
    private JMenuBar colorMenuBar;


    public AddBreeders2Window() {
        gson = new Gson();
        breedPigeonsData2 = new ArrayList<>();


        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Judels Pigeon Manager|Add Mother");

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
                HatcheryWindow hatch = new HatcheryWindow();
                hatch.show();
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
        colorMenuBar = new JMenuBar();
        colorMenu = new JMenu("Color");
        c1 = new JMenuItem();
        c1.setText("BB");
        c2 = new JMenuItem();
        c2.setText("CH");
        c3 = new JMenuItem();
        c3.setText("BB WF");
        c4 = new JMenuItem();
        c4.setText("CH WF");
        c5 = new JMenuItem();
        c5.setText("BB PD");
        c6 = new JMenuItem();
        c6.setText("CH PD");
        c7 = new JMenuItem();
        c7.setText("DRK CH");
        c8 = new JMenuItem();
        c8.setText("RED CH");
        c9 = new JMenuItem();
        c9.setText("BLACK");
        c10 = new JMenuItem();
        c10.setText("GRIZZLE");
        c11 = new JMenuItem();
        c11.setText("DUNN");
        c12 = new JMenuItem();
        c12.setText("WHITE");
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
                colorMenu.setText("BB WF");
            }
        });
        c4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("CH WF");
            }
        });
        c5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BB PD");
            }
        });
        c6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("CH PD");
            }
        });
        c7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("DRK CH");
            }
        });
        c8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("RED CH");
            }
        });
        c9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BLACK");
            }
        });
        c10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("GRIZZLE");
            }
        });
        c11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("DUNN");
            }
        });
        c12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("WHITE");
            }
        });
        colorMenu.add(c10);
        colorMenu.add(c11);
        colorMenu.add(c12);
        colorMenuBar.add(colorMenu);
        colorMenuBar.setBounds(620, 100, 100, 20);
        panel.add(colorMenuBar);
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

        menuBar = new JMenuBar();
        menu().setText("Code 1");
        menuBar.add(menu());
        menuBar.setBounds(20,130,60,20);
        panel.add(menuBar);

        menuBar2 = new JMenuBar();
        menu2().setText("Code 2");
        menuBar2.add(menu2());
        menuBar2.setBounds(90,130,60,20);
        panel.add(menuBar2);

        menuBar3 = new JMenuBar();
        menu3().setText("Code 3");
        menuBar3.add(menu3());
        menuBar3.setBounds(160,130,60,20);
        panel.add(menuBar3);

        menuBar4 = new JMenuBar();
        menu4().setText("Code 4");
        menuBar4.add(menu4());
        menuBar4.setBounds(230,130,60,20);
        panel.add(menuBar4);

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
                    String colour = colorMenu.getText();
                    String gender = "C";
                    String letters = textField6.getText();
                    String gCode1 = menu.getText();
                    String gCode2 = menu2.getText();
                    String gCode3 = menu3.getText();
                    String gCode4 = menu4.getText();
                    //---------
                    // Add to the pigeons data list
                    BreedingPigeons breedPigeon2 = new BreedingPigeons(id, callingCard, year, letters, gender, colour,gCode1,gCode2,gCode3,gCode4);;
                    breedPigeonsData2.add(breedPigeon2);
                    //----------
                    System.out.println(gender);
                    // Save updated data to JSON file
                    saveJsonToFileMother();
                    //------------
                    // Set Input Fields Back To Default
                    textField.setText("Pigeon ID");
                    textField2.setText("Name");
                    textField3.setText("Year");
                    colorMenu.setText("Colour");
                    textField6.setText("Letters");
                    //----
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


    }

    private JMenu menu(){
        menu = new JMenu();
        gene1 = new JMenuItem();
        gene1.setBackground(Color.BLUE);
        gene1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.BLUE);
                menu.setText("b");
            }
        });

        gene2 = new JMenuItem();
        gene2.setBackground(Color.GREEN);
        gene2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.GREEN);
                menu.setText("g");
            }
        });

        gene3 = new JMenuItem();
        gene3.setBackground(Color.PINK);
        gene3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.PINK);
                menu.setText("p");
            }
        });

        gene4 = new JMenuItem();
        gene4.setBackground(Color.RED);
        gene4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.RED);
                menu.setText("r");
            }
        });

        gene5 = new JMenuItem();
        gene5.setBackground(Color.YELLOW);
        gene5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.YELLOW);
                menu.setText("y");
            }
        });

        gene6 = new JMenuItem();
        gene6.setBackground(Color.BLACK);
        gene6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.BLACK);
                menu.setText("bl");
            }
        });

        gene7 = new JMenuItem();
        gene7.setBackground(Color.DARK_GRAY);
        gene7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.DARK_GRAY);
                menu.setText("dgr");
            }
        });

        gene8 = new JMenuItem();
        gene8.setBackground(Color.GRAY);
        gene8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.GRAY);
                menu.setText("gr");
            }
        });

        gene9 = new JMenuItem();
        gene9.setBackground(Color.WHITE);
        gene9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.WHITE);
                menu.setText("w");
            }
        });

        gene10 = new JMenuItem();
        gene10.setBackground(Color.CYAN);
        gene10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.CYAN);
                menu.setText("c");
            }
        });

        gene11 = new JMenuItem();
        gene11.setBackground(Color.MAGENTA);
        gene11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.MAGENTA);
                menu.setText("m");
            }
        });

        gene12 = new JMenuItem();
        gene12.setBackground(Color.LIGHT_GRAY);
        gene12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.LIGHT_GRAY);
                menu.setText("lgr");
            }
        });

        gene13 = new JMenuItem();
        gene13.setBackground(Color.ORANGE);
        gene13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setBackground(Color.ORANGE);
                menu.setText("o");
            }
        });

        menu.add(gene1); menu.add(gene2); menu.add(gene3); menu.add(gene4); menu.add(gene5); menu.add(gene6); menu.add(gene7);
        menu.add(gene8); menu.add(gene9); menu.add(gene10); menu.add(gene11); menu.add(gene12); menu.add(gene13);
        menuBar.add(menu);
        panel.add(menuBar);

        return menu;
    }
    private JMenu menu2(){
        menu2 = new JMenu();
        gene1 = new JMenuItem();
        gene1.setBackground(Color.BLUE);
        gene1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.BLUE);
                menu2.setText("b");
            }
        });

        gene2 = new JMenuItem();
        gene2.setBackground(Color.GREEN);
        gene2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.GREEN);
                menu2.setText("g");
            }
        });

        gene3 = new JMenuItem();
        gene3.setBackground(Color.PINK);
        gene3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.PINK);
                menu2.setText("p");
            }
        });

        gene4 = new JMenuItem();
        gene4.setBackground(Color.RED);
        gene4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.RED);
                menu2.setText("r");
            }
        });

        gene5 = new JMenuItem();
        gene5.setBackground(Color.YELLOW);
        gene5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.YELLOW);
                menu2.setText("y");
            }
        });

        gene6 = new JMenuItem();
        gene6.setBackground(Color.BLACK);
        gene6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.BLACK);
                menu2.setText("bl");
            }
        });

        gene7 = new JMenuItem();
        gene7.setBackground(Color.DARK_GRAY);
        gene7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.DARK_GRAY);
                menu2.setText("dgr");
            }
        });

        gene8 = new JMenuItem();
        gene8.setBackground(Color.GRAY);
        gene8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.GRAY);
                menu2.setText("gr");
            }
        });

        gene9 = new JMenuItem();
        gene9.setBackground(Color.WHITE);
        gene9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.WHITE);
                menu2.setText("w");
            }
        });

        gene10 = new JMenuItem();
        gene10.setBackground(Color.CYAN);
        gene10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.CYAN);
                menu2.setText("c");
            }
        });

        gene11 = new JMenuItem();
        gene11.setBackground(Color.MAGENTA);
        gene11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.MAGENTA);
                menu2.setText("m");
            }
        });

        gene12 = new JMenuItem();
        gene12.setBackground(Color.LIGHT_GRAY);
        gene12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.LIGHT_GRAY);
                menu2.setText("lgr");
            }
        });

        gene13 = new JMenuItem();
        gene13.setBackground(Color.ORANGE);
        gene13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar2.setBackground(Color.ORANGE);
                menu2.setText("o");
            }
        });

        menu2.add(gene1); menu2.add(gene2); menu2.add(gene3); menu2.add(gene4); menu2.add(gene5); menu2.add(gene6); menu2.add(gene7);
        menu2.add(gene8); menu2.add(gene9); menu2.add(gene10); menu2.add(gene11); menu2.add(gene12); menu2.add(gene13);
        menuBar2.add(menu2);
        panel.add(menuBar2);

        return menu2;
    }

    private JMenu menu3(){
        menu3 = new JMenu();
        gene1 = new JMenuItem();
        gene1.setBackground(Color.BLUE);
        gene1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.BLUE);
                menu3.setText("b");
            }
        });

        gene2 = new JMenuItem();
        gene2.setBackground(Color.GREEN);
        gene2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.GREEN);
                menu3.setText("g");
            }
        });

        gene3 = new JMenuItem();
        gene3.setBackground(Color.PINK);
        gene3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.PINK);
                menu3.setText("p");
            }
        });

        gene4 = new JMenuItem();
        gene4.setBackground(Color.RED);
        gene4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.RED);
                menu3.setText("r");
            }
        });

        gene5 = new JMenuItem();
        gene5.setBackground(Color.YELLOW);
        gene5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.YELLOW);
                menu3.setText("y");
            }
        });

        gene6 = new JMenuItem();
        gene6.setBackground(Color.BLACK);
        gene6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.BLACK);
                menu3.setText("bl");
            }
        });

        gene7 = new JMenuItem();
        gene7.setBackground(Color.DARK_GRAY);
        gene7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.DARK_GRAY);
                menu3.setText("dgr");
            }
        });

        gene8 = new JMenuItem();
        gene8.setBackground(Color.GRAY);
        gene8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.GRAY);
                menu3.setText("gr");
            }
        });

        gene9 = new JMenuItem();
        gene9.setBackground(Color.WHITE);
        gene9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.WHITE);
                menu3.setText("w");
            }
        });

        gene10 = new JMenuItem();
        gene10.setBackground(Color.CYAN);
        gene10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.CYAN);
                menu3.setText("c");
            }
        });

        gene11 = new JMenuItem();
        gene11.setBackground(Color.MAGENTA);
        gene11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.MAGENTA);
                menu3.setText("m");
            }
        });

        gene12 = new JMenuItem();
        gene12.setBackground(Color.LIGHT_GRAY);
        gene12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.LIGHT_GRAY);
                menu3.setText("lgr");
            }
        });

        gene13 = new JMenuItem();
        gene13.setBackground(Color.ORANGE);
        gene13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar3.setBackground(Color.ORANGE);
                menu3.setText("o");
            }
        });

        menu3.add(gene1); menu3.add(gene2); menu3.add(gene3); menu3.add(gene4); menu3.add(gene5); menu3.add(gene6); menu3.add(gene7);
        menu3.add(gene8); menu3.add(gene9); menu3.add(gene10); menu3.add(gene11); menu3.add(gene12); menu3.add(gene13);
        menuBar3.add(menu3);
        panel.add(menuBar3);

        return menu3;
    }

    private JMenu menu4(){
        menu4 = new JMenu();
        gene1 = new JMenuItem();
        gene1.setBackground(Color.BLUE);
        gene1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.BLUE);
                menu4.setText("b");
            }
        });

        gene2 = new JMenuItem();
        gene2.setBackground(Color.GREEN);
        gene2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.GREEN);
                menu4.setText("g");
            }
        });

        gene3 = new JMenuItem();
        gene3.setBackground(Color.PINK);
        gene3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.PINK);
                menu4.setText("p");
            }
        });

        gene4 = new JMenuItem();
        gene4.setBackground(Color.RED);
        gene4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.RED);
                menu4.setText("r");
            }
        });

        gene5 = new JMenuItem();
        gene5.setBackground(Color.YELLOW);
        gene5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.YELLOW);
                menu4.setText("y");
            }
        });

        gene6 = new JMenuItem();
        gene6.setBackground(Color.BLACK);
        gene6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.BLACK);
                menu4.setText("bl");
            }
        });

        gene7 = new JMenuItem();
        gene7.setBackground(Color.DARK_GRAY);
        gene7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.DARK_GRAY);
                menu4.setText("dgr");
            }
        });

        gene8 = new JMenuItem();
        gene8.setBackground(Color.GRAY);
        gene8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.GRAY);
                menu4.setText("gr");
            }
        });

        gene9 = new JMenuItem();
        gene9.setBackground(Color.WHITE);
        gene9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.WHITE);
                menu4.setText("w");
            }
        });

        gene10 = new JMenuItem();
        gene10.setBackground(Color.CYAN);
        gene10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.CYAN);
                menu4.setText("c");
            }
        });

        gene11 = new JMenuItem();
        gene11.setBackground(Color.MAGENTA);
        gene11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.MAGENTA);
                menu4.setText("m");
            }
        });

        gene12 = new JMenuItem();
        gene12.setBackground(Color.LIGHT_GRAY);
        gene12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.LIGHT_GRAY);
                menu4.setText("lgr");
            }
        });

        gene13 = new JMenuItem();
        gene13.setBackground(Color.ORANGE);
        gene13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar4.setBackground(Color.ORANGE);
                menu4.setText("o");
            }
        });

        menu4.add(gene1); menu4.add(gene2); menu4.add(gene3); menu4.add(gene4); menu4.add(gene5); menu4.add(gene6); menu4.add(gene7);
        menu4.add(gene8); menu4.add(gene9); menu4.add(gene10); menu4.add(gene11); menu4.add(gene12); menu4.add(gene13);
        menuBar4.add(menu4);
        panel.add(menuBar4);

        return menu4;
    }


    //Save New Pigeon To Mother json file
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

