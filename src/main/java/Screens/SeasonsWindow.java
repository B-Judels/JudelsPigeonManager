package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Pigeons;
import org.example.RaceData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static Screens.MainWindow.currentWorkingSeasonName1;

public class SeasonsWindow {
    private List<Pigeons> PigeonsData;
    private List<String> seasonName;
    private List<String> races;
    private List<RaceData> raceData;
    private Gson gson;
    private JButton button;
    private JPanel panel;
    private JFrame frame;
    private JPanel panel1;
    private JFrame frame1;
    private JTextField textField;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JTable table0;
    private JScrollPane scrollPane0;
    private DefaultTableModel tableModel0;
//    public static List<String> currentWorkingSeasonName;

    public SeasonsWindow() {

        gson = new Gson();
        PigeonsData = new ArrayList<>();
        seasonName = new ArrayList<>();
//        List<String> currentWorkingSeasonName1= new ArrayList<>();
        raceData = new ArrayList<>();
        races = new ArrayList<>();
        loadJsonFromFileSeasonRaces();
        loadJsonFromFileSeasonNames();
        loadJsonFromFileSeasonRaceData();

        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Judels Pigeon Manager|Seasons");

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

        menuBar = new JMenuBar();
        menu = new JMenu("Choose Season");
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
                    frame.setVisible(false);
                    frame1.setVisible(true);
                }
            }); }

        menu.add(menuItem);
        menuBar.setBounds(0,30,100,20);
        panel.add(menuBar);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddSeasonWindow addSeasonWindow = new AddSeasonWindow();
                addSeasonWindow.show();
            }
        });

        frame1 = new JFrame();
        frame1.setVisible(false);
        frame1.setSize(800, 600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setTitle("Judels Pigeon Manager|Seasons");

        panel1 = new JPanel();
        panel1.setLayout(null);
        frame1.add(panel1);

        button = new JButton("Back");
        button.setBackground(Color.CYAN);
        button.setEnabled(true);
        button.setBounds(0, 0, 80, 20);
        panel1.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                MainWindow main = new MainWindow();
                main.show();
            }
        });

        //----------

        tableModel0 = new DefaultTableModel(new String[]{"ID"}, 0);
        table0 = new JTable(tableModel0);

        for (RaceData raceData2 : raceData) {
            tableModel0.addRow(new Object[]{raceData2.getPigeonID()});

        }

        scrollPane0 = new JScrollPane(table0);
        scrollPane0.setBounds(40, 100, 60, 500);
        panel1.add(scrollPane0);

        // Convert ArrayList to Vector
        Vector<String> racesVector = new Vector<>(races);
        tableModel = new DefaultTableModel(racesVector, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 500, 200);

        for (RaceData raceData1 : raceData) {
            tableModel.addRow(new Object[]{raceData1.getPlacement()});

        }

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(99, 100, 200, 300);
        scrollPane.setSize(500, 500);
        panel1.add(scrollPane);
//-----------


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

    private void loadJsonFromFileSeasonRaceData() {
        try (FileReader reader = new FileReader("src/"+currentWorkingSeasonName1.get(0)+"RaceData.json")) {
            Type listType = new TypeToken<ArrayList<RaceData>>() {
            }.getType();
            raceData = gson.fromJson(reader, listType);

            if (raceData == null) {
                raceData = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            raceData = new ArrayList<>();
        }
    }

    private void loadJsonFromFileSeasonRaces() {
        try (FileReader reader = new FileReader("src/"+currentWorkingSeasonName1.get(0)+"Races.json")) {
            Type listType = new TypeToken<ArrayList<String>>() {
            }.getType();
            races = gson.fromJson(reader, listType);

            if (races == null) {
                races = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            races = new ArrayList<>();
        }
    }

    public void show (){
        frame1.setVisible(true);
    }
}
