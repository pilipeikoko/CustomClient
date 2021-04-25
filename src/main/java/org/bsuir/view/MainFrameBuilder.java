package org.bsuir.view;

import javax.swing.*;
import java.awt.*;

public class MainFrameBuilder {

    private final JFrame frame;

    private final MenuBarBuilder menuBarBuilder;
    private final TableBuilder tableBuilder;
    private final PageComponentsBuilder pageComponentsBuilder;
    private final ServiceComponentsBuilder serviceComponentsBuilder;

    public MainFrameBuilder() {

        menuBarBuilder = new MenuBarBuilder();
        tableBuilder = new TableBuilder();
        pageComponentsBuilder = new PageComponentsBuilder();
        serviceComponentsBuilder = new ServiceComponentsBuilder();

        frame = new JFrame("Hospital database");
        setFrame();
    }

    private void setFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMenuBar(menuBarBuilder.getMenuBar());

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        setHorizontalLayout(layout);
        setVerticalLayout(layout);

        frame.pack();
        frame.setBounds(300, 150, 1000, 500);

        frame.setVisible(true);
    }

    private void setVerticalLayout(GroupLayout layout) {
        layout.setVerticalGroup(layout.createParallelGroup()
                .addComponent(serviceComponentsBuilder.getPanel())
                .addGroup(layout.createSequentialGroup()
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
                        .addComponent(pageComponentsBuilder.getLabelItems()[3])));
    }

    private void setHorizontalLayout(GroupLayout layout) {
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(serviceComponentsBuilder.getPanel())
                .addGroup(
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

    public JTable getTable() {
        return tableBuilder.getTable();
    }

    public MenuItem[] getMenuBarItems() {
        return this.menuBarBuilder.getMenuBarItems();
    }

    public JButton[] getButtonItems() {
        return this.pageComponentsBuilder.getButtonItems();
    }

    public JLabel[] getLabelItems() {
        return this.pageComponentsBuilder.getLabelItems();
    }

    public JSpinner getPageSpinner() {
        return this.pageComponentsBuilder.getPageSpinner();
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton[] getServiceComponentButtons(){
        return serviceComponentsBuilder.getButtons();
    }
}
