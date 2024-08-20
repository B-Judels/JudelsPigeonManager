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
    private JMenuItem c1, c2, c3, c4, c5, c6, c7, c8, c9,c10,c11,c12, g1, g2;
    private JMenuItem wd1, wd2, wd3, wd4, wd5, wd6, wd7, wd8, wd9, wd10, wd11, wd12, wd13, wd14, wd15, wd16, wd17, wd18, wd19, wd20, wd21, wd22, wd23, wd24, wd25, wd26, wd27, wd28, wd29, wd30, wd31;
    private JMenuItem wm1, wm2, wm3, wm4, wm5, wm6, wm7, wm8, wm9, wm10, wm11, wm12;
    private JMenuItem wy20, wy21, wy22, wy23, wy24, wy25;
    private JMenuBar weanDayMenuBar;
    private JMenu weanDayMenu;
    private JMenuBar weanMonthMenuBar;
    private JMenu weanMonthMenu;
    private JMenuBar weanYearMenuBar;
    private JMenu weanYearMenu;

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
            JMenuItem menuItem = new JMenuItem();
            menuItem.setText(breedPigeonsData.get(i).getBPigeonName());
            menu.add(menuItem);

            // Capture the value of i at this point in a final variable
            final int selectedIndex = i;

            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Use selectedIndex instead of j
                    menu.setText(breedPigeonsData.get(selectedIndex).getBPigeonName());
                    gC1 = breedPigeonsData.get(selectedIndex).getBGeneticCode1();
                    gC2 = breedPigeonsData.get(selectedIndex).getBGeneticCode2();
                    gC3 = breedPigeonsData.get(selectedIndex).getBGeneticCode3();
                    gC4 = breedPigeonsData.get(selectedIndex).getBGeneticCode4();
                    System.out.println(selectedIndex);
                }
            });
        }
        menuBar.add(menu);
        panel.add(menuBar);


//-----------
//Mother Input
        menuBar = new JMenuBar();
        menuBar.setBounds(500, 150, 100, 20);
        menu2 = new JMenu("Mother");
        for (int i = 0; i < breedPigeonsData2.size(); i++){
            JMenuItem menuItem = new JMenuItem();
            menuItem.setText(breedPigeonsData2.get(i).getBPigeonName());
            menu2.add(menuItem);

            // Capture the value of i at this point in a final variable
            final int selectedIndex2 = i;

            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Use selectedIndex instead of j
                    menu2.setText(breedPigeonsData2.get(selectedIndex2).getBPigeonName());
                    gC5 = breedPigeonsData2.get(selectedIndex2).getBGeneticCode1();
                    gC6 = breedPigeonsData2.get(selectedIndex2).getBGeneticCode2();
                    gC7 = breedPigeonsData2.get(selectedIndex2).getBGeneticCode3();
                    gC8 = breedPigeonsData2.get(selectedIndex2).getBGeneticCode4();
                    System.out.println(selectedIndex2);
                }
            });
        }

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
        weanDayMenuBar = new JMenuBar();
        weanDayMenu = new JMenu("dd");
        weanDayMenuBar.setBounds(620, 170, 30, 20);
        weanDayMenuBar.add(weanDayMenu);
        weanMonthMenuBar = new JMenuBar();
        weanMonthMenu = new JMenu("mm");
        weanMonthMenuBar.setBounds(650, 170, 30, 20);
        weanMonthMenuBar.add(weanMonthMenu);
        weanYearMenuBar = new JMenuBar();
        weanYearMenu = new JMenu("yy");
        weanYearMenuBar.setBounds(680, 170, 30, 20);
        weanYearMenuBar.add(weanYearMenu);

        wd1 = new JMenuItem();wd1.setText("01");
        wd2 = new JMenuItem();wd2.setText("02");
        wd3 = new JMenuItem();wd3.setText("03");
        wd4 = new JMenuItem();wd4.setText("04");
        wd5 = new JMenuItem();wd5.setText("05");
        wd6 = new JMenuItem();wd6.setText("06");
        wd7 = new JMenuItem();wd7.setText("07");
        wd8 = new JMenuItem();wd8.setText("08");
        wd9 = new JMenuItem();wd9.setText("09");
        wd10 = new JMenuItem();wd10.setText("10");
        wd11 = new JMenuItem();wd11.setText("11");
        wd12 = new JMenuItem();wd12.setText("12");
        wd13 = new JMenuItem();wd13.setText("13");
        wd14 = new JMenuItem();wd14.setText("14");
        wd15 = new JMenuItem();wd15.setText("15");
        wd16 = new JMenuItem();wd16.setText("16");
        wd17 = new JMenuItem();wd17.setText("17");
        wd18 = new JMenuItem();wd18.setText("18");
        wd19 = new JMenuItem();wd19.setText("19");
        wd20 = new JMenuItem();wd20.setText("20");
        wd21 = new JMenuItem();wd21.setText("21");
        wd22 = new JMenuItem();wd22.setText("22");
        wd23 = new JMenuItem();wd23.setText("23");
        wd24 = new JMenuItem();wd24.setText("24");
        wd25 = new JMenuItem();wd25.setText("25");
        wd26 = new JMenuItem();wd26.setText("26");
        wd27 = new JMenuItem();wd27.setText("27");
        wd28 = new JMenuItem();wd28.setText("28");
        wd29 = new JMenuItem();wd29.setText("29");
        wd30 = new JMenuItem();wd30.setText("30");
        wd31 = new JMenuItem();wd31.setText("31");

        wd1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("01");
            }
        });
        wd2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("02");
            }
        });
        wd3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("03");
            }
        });
        wd4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("04");
            }
        });
        wd5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("05");
            }
        });
        wd6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("06");
            }
        });
        wd7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("07");
            }
        });
        wd8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("08");
            }
        });
        wd9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("09");
            }
        });
        wd10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("10");
            }
        });
        wd11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("11");
            }
        });
        wd12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("12");
            }
        });
        wd13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("13");
            }
        });
        wd14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("14");
            }
        });
        wd15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("15");
            }
        });
        wd16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("16");
            }
        });
        wd17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("17");
            }
        });
        wd18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("18");
            }
        });
        wd19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("19");
            }
        });
        wd20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("20");
            }
        });
        wd21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("22");
            }
        });
        wd23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("23");
            }
        });
        wd24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("24");
            }
        });
        wd25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("25");
            }
        });
        wd26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("26");
            }
        });
        wd27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("27");
            }
        });
        wd28.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("28");
            }
        });
        wd29.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("29");
            }
        });
        wd30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("30");
            }
        });
        wd31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanDayMenu.setText("31");
            }
        });
        weanDayMenu.add(wd1);weanDayMenu.add(wd2);weanDayMenu.add(wd3);weanDayMenu.add(wd4);
        weanDayMenu.add(wd5);weanDayMenu.add(wd6);weanDayMenu.add(wd7);weanDayMenu.add(wd8);weanDayMenu.add(wd9);
        weanDayMenu.add(wd10);weanDayMenu.add(wd11);weanDayMenu.add(wd12);weanDayMenu.add(wd13);weanDayMenu.add(wd14);weanDayMenu.add(wd15);
        weanDayMenu.add(wd16);weanDayMenu.add(wd17);weanDayMenu.add(wd18);weanDayMenu.add(wd19);weanDayMenu.add(wd20);
        weanDayMenu.add(wd21);weanDayMenu.add(wd22);weanDayMenu.add(wd23);weanDayMenu.add(wd24);weanDayMenu.add(wd25);
        weanDayMenu.add(wd26);weanDayMenu.add(wd27);weanDayMenu.add(wd28);weanDayMenu.add(wd29);weanDayMenu.add(wd30);weanDayMenu.add(wd31);

        wm1 = new JMenuItem();wm1.setText("01");
        wm2 = new JMenuItem();wm2.setText("02");
        wm3 = new JMenuItem();wm3.setText("03");
        wm4 = new JMenuItem();wm4.setText("04");
        wm5 = new JMenuItem();wm5.setText("05");
        wm6 = new JMenuItem();wm6.setText("06");
        wm7 = new JMenuItem();wm7.setText("07");
        wm8 = new JMenuItem();wm8.setText("08");
        wm9 = new JMenuItem();wm9.setText("09");
        wm10 = new JMenuItem();wm10.setText("10");
        wm11 = new JMenuItem();wm11.setText("11");
        wm12 = new JMenuItem();wm12.setText("12");

        wm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("01");
            }
        });
        wm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("02");
            }
        });
        wm3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("03");
            }
        });
        wm4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("04");
            }
        });
        wm5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("05");
            }
        });
        wm6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("06");
            }
        });
        wm7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("07");
            }
        });
        wm8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("08");
            }
        });
        wm9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("09");
            }
        });
        wm10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("10");
            }
        });
        wm11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("11");
            }
        });
        wm12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanMonthMenu.setText("12");
            }
        });

        weanMonthMenu.add(wm1);weanMonthMenu.add(wm2);weanMonthMenu.add(wm3);
        weanMonthMenu.add(wm4);weanMonthMenu.add(wm5);weanMonthMenu.add(wm6);
        weanMonthMenu.add(wm7);weanMonthMenu.add(wm8);weanMonthMenu.add(wm9);
        weanMonthMenu.add(wm10);weanMonthMenu.add(wm11);weanMonthMenu.add(wm12);

        wy20 = new JMenuItem();wy20.setText("20");
        wy21 = new JMenuItem();wy21.setText("21");
        wy22 = new JMenuItem();wy22.setText("22");
        wy23 = new JMenuItem();wy23.setText("23");
        wy24 = new JMenuItem();wy24.setText("24");
        wy25 = new JMenuItem();wy25.setText("25");

        wy20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanYearMenu.setText("20");
            }
        });
        wy21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanYearMenu.setText("21");
            }
        });
        wy22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanYearMenu.setText("22");
            }
        });
        wy23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanYearMenu.setText("23");
            }
        });
        wy24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanYearMenu.setText("24");
            }
        });
        wy25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weanYearMenu.setText("25");
            }
        });

        weanYearMenu.add(wy20);weanYearMenu.add(wy21);weanYearMenu.add(wy22);
        weanYearMenu.add(wy23);weanYearMenu.add(wy24);weanYearMenu.add(wy25);

        panel.add(weanDayMenuBar);panel.add(weanMonthMenuBar);panel.add(weanYearMenuBar);

        label = new JLabel("Date Weaned:");
        label.setBounds(620, 150, 100, 20);
        panel.add(label);
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
                    String weaned = weanDayMenu.getText() + "/" + weanMonthMenu.getText() + "/" + weanYearMenu.getText();
                    System.out.println(weaned);
                    //---------
                    // Add to the pigeons data list
                    Pigeons pigeon = new Pigeons(id, callingCard, year, score, scoreOdss, wins, father, mother, colour, gender, letters, weaned, flyed,
                            gC1, gC2, gC3, gC4, gC5, gC6, gC7, gC8,0);
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
                    weanDayMenu.setText("dd");
                    weanMonthMenu.setText("mm");
                    weanYearMenu.setText("yy");
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