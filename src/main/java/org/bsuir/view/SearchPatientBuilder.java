package org.bsuir.view;

import org.bsuir.util.Parameters;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.*;

public class SearchPatientBuilder {
    private final CardsBuilder cardsBuilder;
    private final JButton searchButton;
    private final JComboBox<String> searchByTypeComboBox;
    private final TableBuilder tableBuilder;
    private final PageComponentsBuilder pageComponentsBuilder;

    public SearchPatientBuilder() {
        cardsBuilder = new CardsBuilder();

        searchButton = new JButton("Search");

        JDialog dialog = new JDialog();
        dialog.setLocation(350, 200);
        dialog.setPreferredSize(new Dimension(920, 525));

        searchByTypeComboBox = new JComboBox<>(Parameters.SEARCH_TYPES);
        searchByTypeComboBox.setMaximumSize(new Dimension(30, 100));


        tableBuilder = new TableBuilder();
        pageComponentsBuilder = new PageComponentsBuilder();

        JPanel defaultSearchPanel = createDefaultDeletePanel();
        JPanel tablePanel = createTablePanel();

        dialog.add(defaultSearchPanel, BorderLayout.NORTH);
        dialog.add(cardsBuilder.getCards(), BorderLayout.CENTER);
        dialog.add(searchButton, BorderLayout.SOUTH);
        dialog.add(tablePanel, BorderLayout.EAST);


        dialog.pack();
        dialog.setVisible(true);
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(700, 300));
        GroupLayout layout = new GroupLayout(tablePanel);
        tablePanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        setHorizontalLayout(layout);
        setVerticalLayout(layout);

        return tablePanel;
    }

    private void setVerticalLayout(GroupLayout layout) {
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(tableBuilder.getTable().getTableHeader())
                .addComponent(tableBuilder.getTableScrollPane())
                .addGroup(layout.createParallelGroup()
                        .addComponent(pageComponentsBuilder.getLabelItems()[0])
                        .addComponent(pageComponentsBuilder.getPageSpinner()))
                .addGroup(layout.createParallelGroup()
                        .addComponent(pageComponentsBuilder.getLabelItems()[1])
                        .addComponent(pageComponentsBuilder.getButtonItems()[0])
                        .addComponent(pageComponentsBuilder.getButtonItems()[1])
                        .addComponent(pageComponentsBuilder.getButtonItems()[2])
                        .addComponent(pageComponentsBuilder.getButtonItems()[3]))
                .addComponent(pageComponentsBuilder.getLabelItems()[2])
                .addComponent(pageComponentsBuilder.getLabelItems()[3]));

    }

    private void setHorizontalLayout(GroupLayout layout) {
        layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(
                layout.createParallelGroup()
                        .addComponent(tableBuilder.getTable().getTableHeader())
                        .addComponent(tableBuilder.getTableScrollPane())
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pageComponentsBuilder.getLabelItems()[0])
                                .addComponent(pageComponentsBuilder.getPageSpinner()))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pageComponentsBuilder.getLabelItems()[1])
                                .addComponent(pageComponentsBuilder.getButtonItems()[0])
                                .addComponent(pageComponentsBuilder.getButtonItems()[1])
                                .addComponent(pageComponentsBuilder.getButtonItems()[2])
                                .addComponent(pageComponentsBuilder.getButtonItems()[3]))
                        .addComponent(pageComponentsBuilder.getLabelItems()[2])
                        .addComponent(pageComponentsBuilder.getLabelItems()[3], GroupLayout.Alignment.CENTER)));

    }

    private JPanel createDefaultDeletePanel() {
        JLabel searchByLabel = new JLabel("Search by:");

        JPanel defaultSearchPanel = new JPanel();

        defaultSearchPanel.add(searchByLabel);
        defaultSearchPanel.add(searchByTypeComboBox);
        defaultSearchPanel.setMaximumSize(new Dimension(300, 100));

        return defaultSearchPanel;
    }

    public JButton[] getPageButtonItems() {
        return pageComponentsBuilder.getButtonItems();
    }

    public JLabel[] getPageLabelItems() {
        return pageComponentsBuilder.getLabelItems();
    }

    public JSpinner getPageSpinner() {
        return pageComponentsBuilder.getPageSpinner();
    }

    public JButton getDeleteButton() {
        return searchButton;
    }

    public JTextField[] getCardsTextFields() {
        return cardsBuilder.getTextFields();
    }

    public JLabel[] getCardsLabelItems() {
        return cardsBuilder.getLabelItems();
    }

    public JDatePanelImpl[] getCardsDatePanels() {
        return cardsBuilder.getDatePanels();
    }

    public JComboBox<String> getSearchByTypeComboBox() {
        return searchByTypeComboBox;
    }

    public JTable getTable() {
        return tableBuilder.getTable();
    }

    public JPanel getCards() {
        return cardsBuilder.getCards();
    }
}
