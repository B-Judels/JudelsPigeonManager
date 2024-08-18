package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.BreedingPigeons;
import org.example.GCodeCellRenderer;
import org.example.Pigeons;
import org.example.YearCellRenderer;

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
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton button;
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






        tableModel = new DefaultTableModel(new String[]{"ID", "Calling Card", "Year", "Score", "Score Odds", "Wins"}, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 500, 200);

        // Load data into the table
        for (Pigeons pigeon : pigeonsData) {
            tableModel.addRow(new Object[]{pigeon.getPigeonID(), pigeon.getPigeonCallingCard(),
                    pigeon.getPigeonYear(), pigeon.getPigeonScored(), (String.format("%.2f", pigeon.getPigeonScorePercentage())) + "%", pigeon.getPigeonWins()});
        }

        // Set custom renderer for the "Year" column (index 2)
        table.getColumnModel().getColumn(2).setCellRenderer(new YearCellRenderer());

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 200, 300);
        scrollPane.setSize(500, 500);
        panel.add(scrollPane);

//        tableModel_2 = new DefaultTableModel(new String[]{"G1", "G2", "G3","G4","G5", "G6", "G7","G8"}, 0);
//        table_2 = new JTable(tableModel_2);
//        table_2.setBounds(550, 100, 100, 200);
//
//        // Load data into the table
//        for (BreedingPigeons pigeon2 : pigeonsData2) {
//            tableModel_2.addRow(new Object[]{pigeon2.getBGeneticCode1(),
//                    pigeon2.getBGeneticCode2(), pigeon2.getBGeneticCode3(), pigeon2.getBGeneticCode4()});
//        }
//
//        table_2.getColumnModel().getColumn(0).setCellRenderer(new GCodeCellRenderer());
//        table_2.getColumnModel().getColumn(1).setCellRenderer(new GCodeCellRenderer());
//        table_2.getColumnModel().getColumn(2).setCellRenderer(new GCodeCellRenderer());
//        table_2.getColumnModel().getColumn(3).setCellRenderer(new GCodeCellRenderer());
//
//
//        scrollPane_2 = new JScrollPane(table_2);
//        scrollPane_2.setBounds(499, 50, 40, 300);
//        scrollPane_2.setSize(80, 500);
//        panel.add(scrollPane_2);

    }


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

    public void show() {
        frame.setVisible(true);
    }
}