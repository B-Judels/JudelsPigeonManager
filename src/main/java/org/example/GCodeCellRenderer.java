package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class GCodeCellRenderer extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


            String gCode = (String) value;

            // Set the background color based on the year value
            switch (gCode) {
                case "m":
                    cellComponent.setForeground(Color.MAGENTA);
                    cellComponent.setBackground(Color.MAGENTA);
                    break;
                case "o":
                    cellComponent.setForeground(Color.ORANGE);
                    cellComponent.setBackground(Color.ORANGE);
                    break;
                case "bl":
                    cellComponent.setForeground(Color.BLACK);
                    cellComponent.setBackground(Color.BLACK);
                    break;
                case "p":
                    cellComponent.setForeground(Color.PINK);
                    cellComponent.setBackground(Color.PINK);
                    break;
                case "dgr":
                    cellComponent.setForeground(Color.DARK_GRAY);
                    cellComponent.setBackground(Color.DARK_GRAY);
                    break;
                case "gr":
                    cellComponent.setForeground(Color.GRAY);
                    cellComponent.setBackground(Color.GRAY);
                    break;
                case "c":
                    cellComponent.setForeground(Color.CYAN);
                    cellComponent.setBackground(Color.CYAN);
                    break;
                case "b":
                    cellComponent.setForeground(Color.BLUE);
                    cellComponent.setBackground(Color.BLUE);
                    break;
                case "r":
                    cellComponent.setForeground(Color.RED);
                    cellComponent.setBackground(Color.RED);
                    break;
                case "y":
                    cellComponent.setForeground(Color.YELLOW);
                    cellComponent.setBackground(Color.YELLOW);
                    break;
                case "g":
                    cellComponent.setForeground(Color.GREEN);
                    cellComponent.setBackground(Color.GREEN);
                    break;
                case "lgr":
                    cellComponent.setForeground(Color.LIGHT_GRAY);
                    cellComponent.setBackground(Color.LIGHT_GRAY);
                    break;
                default:
                    cellComponent.setForeground(Color.WHITE);
                    cellComponent.setBackground(Color.WHITE);// Default color
                    break;
            }

                return cellComponent;


        }}