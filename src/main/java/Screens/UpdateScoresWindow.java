package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.BreedingPigeons;
import org.example.Pigeons;
import org.example.YearCellRenderer;

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

public class UpdateScoresWindow {

    private String currentFather;
    private JFrame frame;
    private JLabel label;
    private Gson gson;
    private JButton button;
    private JPanel panel;
    private JTextField textField, textField2, textField3;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private List<Pigeons> PigeonsData;
    private List<Pigeons> pigeonsData;
    private List<Pigeons> updateData;
    private List<Integer> indexFinder;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private int addScore;
    private int newScore;


    public UpdateScoresWindow() {
        gson = new Gson();
        PigeonsData = new ArrayList<>();
//        pigeonsData = new ArrayList<>();
        updateData = new ArrayList<>();
        indexFinder = new ArrayList<>();
        loadJsonFromFile();

        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Judels Pigeon Manager|Update Scores");


        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

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


        textField = new JTextField("Race Name/Location Name");
        textField.setBounds(100, 30, 160, 20);
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Race Name/Location Name"))
                    textField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField.getText().equals(""))
                    textField.setText("Race Name/Location Name");
            }
        });
        panel.add(textField);

        //Father Input
        menuBar = new JMenuBar();
        menuBar.setBounds(270, 30, 100, 20);
        menu = new JMenu("ID");
        for (int i = 0; i < PigeonsData.size(); i++){
            JMenuItem menuItem = new JMenuItem();
            menuItem.setText(PigeonsData.get(i).getPigeonID());
            menu.add(menuItem);

            // Capture the value of i at this point in a final variable
            final int selectedIndex = i;

            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Use selectedIndex instead of j
                    menu.setText(PigeonsData.get(selectedIndex).getPigeonID());
                    //current data
                    int currentIndex = selectedIndex;
                    String currentId = PigeonsData.get(selectedIndex).getPigeonID();
                    String currentCallingCard = PigeonsData.get(selectedIndex).getPigeonCallingCard();
                    String currentYear = PigeonsData.get(selectedIndex).getPigeonYear();
                    int currentScore = PigeonsData.get(selectedIndex).getPigeonScored();
                    double currentPercentage = PigeonsData.get(selectedIndex).getPigeonScorePercentage();
                    int currentWins = PigeonsData.get(selectedIndex).getPigeonWins();
                    String currentFather = PigeonsData.get(selectedIndex).getPigeonFather();
                    String currentMother = PigeonsData.get(selectedIndex).getPigeonMother();
                    String currentLetters = PigeonsData.get(selectedIndex).getPigeonLetters();
                    String currentColour = PigeonsData.get(selectedIndex).getPigeonColour();
                    String currentGender = PigeonsData.get(selectedIndex).getPigeonGender();
                    String currentWeaned = PigeonsData.get(selectedIndex).getPigeonWeaned();
                    int currentFlyed = PigeonsData.get(selectedIndex).getPigeonFlyed();
                    String currentG1 = PigeonsData.get(selectedIndex).getgC1();
                    String currentG2 = PigeonsData.get(selectedIndex).getgC2();
                    String currentG3 = PigeonsData.get(selectedIndex).getgC3();
                    String currentG4 = PigeonsData.get(selectedIndex).getgC4();
                    String currentG5 = PigeonsData.get(selectedIndex).getgC5();
                    String currentG6 = PigeonsData.get(selectedIndex).getgC6();
                    String currentG7 = PigeonsData.get(selectedIndex).getgC7();
                    String currentG8 = PigeonsData.get(selectedIndex).getgC8();
                    int currentTotalScore = PigeonsData.get(selectedIndex).getTotalScore();


                    Pigeons current = new Pigeons(currentId, currentCallingCard, currentYear, currentScore, currentPercentage,currentWins,
                            currentFather, currentMother, currentLetters, currentColour, currentGender, currentWeaned, currentFlyed,
                            currentG1,currentG2,currentG3,currentG4,currentG5,currentG6,currentG7,currentG8,currentTotalScore);
                    updateData.add(current);

                    indexFinder.add(currentIndex);

                }
            });
        }
        menuBar.add(menu);
        panel.add(menuBar);

        //Placement Input
        textField2 = new JTextField("Race Placing");
        textField2.setBounds(380, 30, 100, 20);
        textField2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField2.getText().equals("Race Placing"))
                    textField2.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField2.getText().equals(""))
                    textField2.setText("Race Placing");
            }
        });
        panel.add(textField2);
//---------

        //Score Input
        textField3 = new JTextField("Race Score");
        textField3.setBounds(490, 30, 100, 20);
        textField3.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField3.getText().equals("Race Score"))
                    textField3.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField3.getText().equals(""))
                    textField3.setText("Race Score");
            }
        });
        panel.add(textField3);

        button = new JButton("Add");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(200, 50, 80, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = menu.getText();
                String placing = textField2.getText();

                if(placing.equals("1")){
                    placing = "WIN!";
                }else{
                    placing = textField2.getText();
                }

                String score = textField3.getText();
                addScore = Integer.parseInt(score);
                tableModel.addRow(new Object[]{id, placing, addScore});

                //update total score
                int tempIndex = indexFinder.get(0);
                int theCurrentScore = updateData.get(tempIndex).getTotalScore();
                System.out.println("old times scored: " + theCurrentScore);

                int newestTotalScore = theCurrentScore + Integer.parseInt(textField3.getText());
                updateData.get(tempIndex).setTotalScore(newestTotalScore);

                System.out.println("new times scored: " + newestTotalScore);
                //---
                //update wins
                int theCurrentWins = updateData.get(tempIndex).getPigeonWins();
                if (textField2.getText().equals("1")) {
                    updateData.get(tempIndex).setPigeonWins(theCurrentWins + 1);
                }else {
                    updateData.get(tempIndex).setPigeonWins(theCurrentWins);
                }
                //----
                //update times scored
                int theCurrentTimesScore = updateData.get(tempIndex).getPigeonScored();
                System.out.println("old score: " + theCurrentTimesScore);

                int extraScore = Integer.parseInt(textField3.getText());
                if (extraScore > 0) {
                    updateData.get(tempIndex).setPigeonScored(theCurrentTimesScore + 1);
                }else {
                    updateData.get(tempIndex).setPigeonScored(theCurrentTimesScore);
                }
                System.out.println("new score: " + updateData.get(tempIndex).getPigeonScored());
                //---
                //update times flyed
                int currentFlys = updateData.get(tempIndex).getPigeonFlyed();
                int newFlys = currentFlys + 1;
                updateData.get(tempIndex).setPigeonFlyed(newFlys);
                //----
                //update score odds
                System.out.println(newFlys);

                double currentOdds = updateData.get(tempIndex).getPigeonScorePercentage();
                int newTimesPigeonScored = updateData.get(tempIndex).getPigeonScored();
                double newPercentage = (Double.parseDouble(String.valueOf(newTimesPigeonScored)) / Double.parseDouble(String.valueOf(newFlys))) * 100;
                updateData.get(tempIndex).setPigeonScorePercentage(newPercentage);

                System.out.println(newTimesPigeonScored);
                System.out.println(newPercentage);
                //----
                //UPDATE
                PigeonsData.set(tempIndex, updateData.get(tempIndex));
                saveJsonToFile();
                //----
                //setting gui text and some values back to default
                menu.setText("ID");
                textField2.setText("Race Placing");
                textField3.setText("Race Score");
                indexFinder.clear();
                //---

            }
        });
        panel.add(button);

//----------

        tableModel = new DefaultTableModel(new String[]{"ID", "Placement", "Score"}, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 500, 200);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 100, 200, 300);
        scrollPane.setSize(500, 500);
        panel.add(scrollPane);


//-----------
    }

    //Save New Pigeons To json file
    private void saveJsonToFile() {
        try (FileWriter writer = new FileWriter("src/pigeons.json")) {
            gson.toJson(PigeonsData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//-----------

    private void loadJsonFromFile() {
        try (FileReader reader = new FileReader("src/pigeons.json")) {
            Type listType = new TypeToken<ArrayList<Pigeons>>() {
            }.getType();
            PigeonsData = gson.fromJson(reader, listType);

            if (PigeonsData == null) {
                PigeonsData = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            PigeonsData = new ArrayList<>();
        }
    }

    public void show() {
        frame.setVisible(true);
    }
}
