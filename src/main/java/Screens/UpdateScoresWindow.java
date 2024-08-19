package Screens;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.BreedingPigeons;
import org.example.Pigeons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UpdateScoresWindow {

    private JFrame frame;
    private JLabel label;
    private Gson gson;
    private JButton button;
    private JPanel panel;
    private JTextField textField, textField2;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private List<Pigeons> PigeonsData;


    public UpdateScoresWindow() {
        gson = new Gson();
        PigeonsData = new ArrayList<>();
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
        menu = new JMenu("Father");
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

                    System.out.println(selectedIndex);
                }
            });
        }
        menuBar.add(menu);
        panel.add(menuBar);

        //Score Input
        textField2 = new JTextField("Race Score");
        textField2.setBounds(380, 30, 100, 20);
        textField2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField2.getText().equals("Race Score"))
                    textField2.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (textField2.getText().equals(""))
                    textField2.setText("Race Score");
            }
        });
        panel.add(textField2);
//----------


//-----------
    }

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
