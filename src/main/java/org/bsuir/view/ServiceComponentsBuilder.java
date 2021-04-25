package org.bsuir.view;

import org.bsuir.view.border.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class ServiceComponentsBuilder {
    private static final int AMOUNT_OF_BUTTONS = 4;

    private JButton[] buttons;
    private JPanel panel;

    public ServiceComponentsBuilder() {
        buttons = new JButton[AMOUNT_OF_BUTTONS];

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton searchButton = new JButton("Search");
        JButton refreshButton = new JButton("Refresh");

        addButton.setForeground(Color.BLACK);
        addButton.setBackground(Color.WHITE);

        removeButton.setForeground(Color.BLACK);
        removeButton.setBackground(Color.WHITE);

        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(Color.WHITE);

        refreshButton.setForeground(Color.BLACK);
        refreshButton.setBackground(Color.WHITE);


        buttons[0] = refreshButton;
        buttons[1] = addButton;
        buttons[2] = removeButton;
        buttons[3] = searchButton;

        addButton.setBorder(new RoundedBorder(5));
        removeButton.setBorder(new RoundedBorder(5));
        searchButton.setBorder(new RoundedBorder(5));
        refreshButton.setBorder(new RoundedBorder(5));

        panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(refreshButton)
                .addComponent(addButton)
                .addComponent(removeButton)
                .addComponent(searchButton));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(refreshButton)
                .addGap(0, 10, 20)
                .addComponent(addButton)
                .addGap(0, 10, 20)
                .addComponent(removeButton)
                .addGap(0, 10, 20)
                .addComponent(searchButton)
        );

    }

    public JPanel getPanel() {
        return panel;
    }


    /**
     * <br>[0] refresh button</br>
     * <br>[1] add button</br>
     * <br>[2] remove button</br>
     * <br>[3] search button</br>
     */
    public JButton[] getButtons() {
        return buttons;
    }
}
