package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class YearCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);

        // Check if this is the "Year" column (column index 2 in your case)
        if (column == 2) {
            String year = (String) value;

            // Set the background color based on the year value
            switch (year) {
                case "2020":
                    cellComponent.setBackground(Color.RED);
                    break;
                case "2021":
                    cellComponent.setBackground(Color.BLUE);
                    break;
                case "2022":
                    cellComponent.setBackground(Color.YELLOW);
                    break;
                case "2023":
                    cellComponent.setBackground(Color.GREEN);
                    break;
                case "2024":
                    cellComponent.setBackground(Color.LIGHT_GRAY);
                    break;
                default:
                    cellComponent.setBackground(Color.WHITE); // Default color
                    break;
            }
        } else {
            cellComponent.setBackground(Color.WHITE); // Default color for other columns
        }

        return cellComponent;
    }
}

