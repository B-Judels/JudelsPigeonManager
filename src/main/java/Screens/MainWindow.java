package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
    private DefaultTableModel tableModel_2;
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JTable table_2;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane_2;
    private JButton button;
    private JLabel label;
    private Gson gson;
    private List<Pigeons> pigeonsData;
    private List<String> seasonName;
    private JTextField textField3;
    JMenu menu, submenu;
    JMenu menu0;
    JMenuItem i1, i2, i3, i4, i5, i6, menuItem;
    public static List<String> currentWorkingSeasonName1;
    private List<String> races;
    private List<RaceData> raceData;
    private JMenuBar menuBar;

    public MainWindow() {
        gson = new Gson();
        pigeonsData = new ArrayList<>();
        seasonName = new ArrayList<>();
        races = new ArrayList<>();
        raceData = new ArrayList<>();
        currentWorkingSeasonName1 = new ArrayList<>();
        loadJsonFromFileSeasonNames();
//        loadJsonFromFileSeasonRaceData();
//        loadJsonFromFileSeasonRaces();


        // Load data from JSON file
        loadJsonFromFile();

        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Judels Pigeon Manager|Racing Team");

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        button = new JButton("Team");
        button.setBackground(Color.CYAN);
        button.setEnabled(false);
        button.setBounds(0, 0, 80, 20);
        panel.add(button);

        button = new JButton("+ Racer");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(20, 35, 90, 15);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddPigeonWindow add = new AddPigeonWindow();
                add.show();
            }
        });

        button = new JButton("Update Scores");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(120, 35, 120, 15);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UpdateScoresWindow update = new UpdateScoresWindow();
                update.show();
            }
        });

        button = new JButton("Hatchery");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(85, 0, 120, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                HatcheryWindow hatch = new HatcheryWindow();
                hatch.show();
            }
        });

//        button = new JButton("Seasons");
//        button.setBackground(Color.CYAN);
//        button.setEnabled(true);
//        button.setBounds(210, 0, 100, 20);
//        panel.add(button);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
//                SeasonsWindow seasonsWindow = new SeasonsWindow();
//                seasonsWindow.show();
//            }
//        });

        menuBar = new JMenuBar();
        menu = new JMenu("Seasons");
        menuBar.add(menu);
        menuItem = new JMenuItem("Add Season");
        menuItem.setBackground(Color.CYAN);

        for (int i = 0; i < seasonName.size(); i++){
            JMenuItem menuItem00 = new JMenuItem();
            menuItem00.setText(seasonName.get(i));
            menu.add(menuItem00);

            // Capture the value of i at this point in a final variable
            final int selectedIndex = i;

            menuItem00.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Use selectedIndex instead of j
                    currentWorkingSeasonName1.clear();
                    menu.setText(seasonName.get(selectedIndex));
                    currentWorkingSeasonName1.add(seasonName.get(selectedIndex));
                    System.out.println(currentWorkingSeasonName1.get(0));
                    frame.setVisible(false);
                    SeasonsWindow seasonsWindow = new SeasonsWindow();
                    seasonsWindow.show();

                }
            }); }

        menu.add(menuItem);
        menuBar.setBounds(210, 0, 100, 20);
        panel.add(menuBar);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddSeasonWindow addSeasonWindow = new AddSeasonWindow();
                addSeasonWindow.show();
            }
        });


        tableModel = new DefaultTableModel(new String[]{"ID", "Calling Card", "Year", "Score", "Score Odds", "Wins"}, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 500, 200);

        // Load data into the table
        for (Pigeons pigeon : pigeonsData) {
            tableModel.addRow(new Object[]{pigeon.getPigeonID(), pigeon.getPigeonCallingCard(),
                    pigeon.getPigeonYear(), pigeon.getTotalScore(), (String.format("%.2f", pigeon.getPigeonScorePercentage())) + "%", pigeon.getPigeonWins()});
        }

        // Set custom renderer for the "Year" column (index 2)
        table.getColumnModel().getColumn(2).setCellRenderer(new YearCellRenderer());

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 200, 300);
        scrollPane.setSize(500, 500);
        panel.add(scrollPane);

        tableModel_2 = new DefaultTableModel(new String[]{"G1", "G2", "G3","G4","G5", "G6", "G7","G8"}, 0);
        table_2 = new JTable(tableModel_2);
        table_2.setBounds(550, 100, 100, 200);

        // Load data into the table
        for (Pigeons pigeon2 : pigeonsData) {
            tableModel_2.addRow(new Object[]{pigeon2.getgC1(),pigeon2.getgC2(), pigeon2.getgC3(), pigeon2.getgC4(), pigeon2.getgC5(),
            pigeon2.getgC6(), pigeon2.getgC7(), pigeon2.getgC8()});

        }

        table_2.getColumnModel().getColumn(0).setCellRenderer(new GCodeCellRenderer());
        table_2.getColumnModel().getColumn(1).setCellRenderer(new GCodeCellRenderer());
        table_2.getColumnModel().getColumn(2).setCellRenderer(new GCodeCellRenderer());
        table_2.getColumnModel().getColumn(3).setCellRenderer(new GCodeCellRenderer());
        table_2.getColumnModel().getColumn(4).setCellRenderer(new GCodeCellRenderer());
        table_2.getColumnModel().getColumn(5).setCellRenderer(new GCodeCellRenderer());
        table_2.getColumnModel().getColumn(6).setCellRenderer(new GCodeCellRenderer());
        table_2.getColumnModel().getColumn(7).setCellRenderer(new GCodeCellRenderer());


        scrollPane_2 = new JScrollPane(table_2);
        scrollPane_2.setBounds(519, 50, 40, 300);
        scrollPane_2.setSize(160, 500);
        panel.add(scrollPane_2);

    }

    private void loadJsonFromFileSeasonNames() {
        try (FileReader reader = new FileReader("src/Seasons.json")) {
            Type listType = new TypeToken<ArrayList<String>>() {
            }.getType();
            seasonName = gson.fromJson(reader, listType);

            if (seasonName == null) {
                seasonName = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            seasonName = new ArrayList<>();
        }
    }
//
//    private void loadJsonFromFileSeasonRaceData() {
//        try (FileReader reader = new FileReader("src/"+currentWorkingSeasonName.get(0)+"RaceData.json")) {
//            Type listType = new TypeToken<ArrayList<String>>() {
//            }.getType();
//            raceData = gson.fromJson(reader, listType);
//
//            if (raceData == null) {
//                raceData = new ArrayList<>();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            raceData = new ArrayList<>();
//        }
//    }
//
//    private void loadJsonFromFileSeasonRaces() {
//        try (FileReader reader = new FileReader("src/"+currentWorkingSeasonName.get(0)+"Races.json")) {
//            Type listType = new TypeToken<ArrayList<String>>() {
//            }.getType();
//            races = gson.fromJson(reader, listType);
//
//            if (races == null) {
//                races = new ArrayList<>();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            races = new ArrayList<>();
//        }
//    }



    private void loadJsonFromFile() {
        try (FileReader reader = new FileReader("src/pigeons.json")) {
            Type listType = new TypeToken<ArrayList<Pigeons>>() {
            }.getType();
            pigeonsData = gson.fromJson(reader, listType);

            if (pigeonsData == null) {
                pigeonsData = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            pigeonsData = new ArrayList<>();
        }
    }

    public void show(){
        frame.setVisible(true);
    }
}