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
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HatcheryWindow {
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModel2;
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JTable table2;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;
    private JButton button;
    private Gson gson;
    private List<BreedingPigeons> pigeonsData;
    private List<BreedingPigeons> pigeonsData2;

    public HatcheryWindow() {
        gson = new Gson();
        pigeonsData = new ArrayList<>();
        pigeonsData2 = new ArrayList<>();

        loadJsonFromFileFather();
        loadJsonFromFileMother();

        frame = new JFrame();
        frame.setSize(1200,600);
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
        button.setEnabled(true);
        button.setBounds(220, 0, 120, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddBreedersWindow addB = new AddBreedersWindow();
                addB.show();
            }
        });

        button = new JButton("Hatchery");
        button.setBackground(Color.CYAN);
        button.setEnabled(false);
        button.setBounds(350, 0, 120, 20);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                HatcheryWindow hatch = new HatcheryWindow();
                hatch.show();
            }
        });




        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Year", "Letters", "Colour"}, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 500, 200);

        // Load data into the table
        for (BreedingPigeons pigeon : pigeonsData) {
            tableModel.addRow(new Object[]{pigeon.getBPigeonID(), pigeon.getBPigeonName(),
                    pigeon.getBPigeonYear(), pigeon.getBPigeonLetters(), pigeon.getBPigeonColour()});
        }

        // Set custom renderer for the "Year" column (index 2)
        table.getColumnModel().getColumn(2).setCellRenderer(new YearCellRenderer());

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 200, 300);
        scrollPane.setSize(500, 500);
        panel.add(scrollPane);

        tableModel2 = new DefaultTableModel(new String[]{"ID", "Name", "Year", "Letters", "Colour"}, 0);
        table2 = new JTable(tableModel2);
        table2.setBounds(30, 100, 500, 200);

        // Load data into the table
        for (BreedingPigeons pigeon2 : pigeonsData2) {
            tableModel2.addRow(new Object[]{pigeon2.getBPigeonID(), pigeon2.getBPigeonName(),
                    pigeon2.getBPigeonYear(), pigeon2.getBPigeonLetters(), pigeon2.getBPigeonColour()});
        }

        // Set custom renderer for the "Year" column (index 2)
        table2.getColumnModel().getColumn(2).setCellRenderer(new YearCellRenderer());

        scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(540, 50, 200, 300);
        scrollPane2.setSize(500, 500);
        panel.add(scrollPane2);

    }

    private void loadJsonFromFileFather() {
        try (FileReader reader = new FileReader("src/Fathers.json")) {
            Type listType = new TypeToken<ArrayList<BreedingPigeons>>() {
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

    private void loadJsonFromFileMother() {
        try (FileReader reader2 = new FileReader("src/Mothers.json")) {
            Type listType2 = new TypeToken<ArrayList<BreedingPigeons>>() {
            }.getType();
            pigeonsData2 = gson.fromJson(reader2, listType2);

            if (pigeonsData2 == null) {
                pigeonsData2 = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            pigeonsData2 = new ArrayList<>();
        }
    }

    //Set HatcheryWindow visible
    public void show() {
        frame.setVisible(true);
    }
}
