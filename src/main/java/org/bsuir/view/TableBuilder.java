package org.bsuir.view;

import org.bsuir.model.CustomTableModel;
import org.bsuir.util.Parameters;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableBuilder {
    private final JTable table;
    private final JScrollPane tableScrollPane;

    public TableBuilder() {
        DefaultTableModel model = new DefaultTableModel(Parameters.defaultData, Parameters.TABLE_HEADER);
        this.table = new JTable();
        this.tableScrollPane = new JScrollPane(table);


        setTableInfo(model);
        setScrollPane();
    }

    private void setScrollPane() {
        //tableScrollPane.setPreferredSize(new Dimension(700, 400));
    }

    private void setTableInfo(DefaultTableModel model) {
        table.setModel(model);
        table.getTableHeader().setFont(new Font("Segou UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(32, 136, 203));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setGridColor(new Color(100, 100, 100));
        // table.setPreferredSize(new Dimension(700, 200));
    }

    public JTable getTable() {
        return table;
    }

    public JScrollPane getTableScrollPane() {
        return tableScrollPane;
    }
}
