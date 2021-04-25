package org.bsuir.controller;

import org.bsuir.exception.CustomClientException;
import org.bsuir.model.Patient;
import org.bsuir.model.CustomTableModel;
import org.bsuir.service.PatientService;
import org.bsuir.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainFrameController {

    /**
     * @see MenuBarBuilder#getMenuBarItems()
     */
    private final MenuItem[] menuItems;
    /**
     * @see PageComponentsBuilder#getButtonItems()
     */
    private final JButton[] buttonItems;
    /**
     * @see PageComponentsBuilder#getLabelItems()
     */
    private final JLabel[] labelItems;
    /**
     * @see ServiceComponentsBuilder#getButtons()
     */
    private final JButton[] serviceButtons;
    private final JSpinner pageSpinner;
    private final JTable table;
    private final PatientService patientService;

    public MainFrameController(MenuItem[] menuItems, JButton[] buttonItems,
                               JLabel[] labelItems, JSpinner pageSpinner, JTable table,
                               JButton[] serviceButtons, PatientService patientService) {
        this.buttonItems = buttonItems;
        this.menuItems = menuItems;
        this.labelItems = labelItems;
        this.pageSpinner = pageSpinner;
        this.table = table;
        this.serviceButtons = serviceButtons;
        this.patientService = patientService;

        setMenuItemsController();
        setButtonItemsController();
        setServiceButtonController();
        addPageSpinnerChangeListener();
    }

    private void setServiceButtonController() {
        serviceButtons[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateComponents(getCurrentPage());
                } catch (CustomClientException exception) {
                    Alert.wrongPageAlert();

                }
            }
        });

        serviceButtons[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatientView(patientService);
            }
        });

        serviceButtons[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletePatientView(patientService);
            }
        });

        serviceButtons[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchPatientView(patientService);
            }
        });
    }


    private void addPageSpinnerChangeListener() {
        pageSpinner.addChangeListener(e -> {
            try {
                int newPageNumber = Integer.parseInt(labelItems[3].getText());
                updateComponents(newPageNumber);
            } catch (ArrayIndexOutOfBoundsException | CustomClientException exception) {
                Alert.wrongPageAlert();
            }
        });
    }

    private void updateComponents(int newPageNumber) throws ArrayIndexOutOfBoundsException, CustomClientException {
        if (newPageNumber <= 0) {
            throw new CustomClientException("Wrong page");
        }

        int amountOfNotesOnTheTable = getAmountOfNotesOnTheTable();

        int totalAmountOfPatients = patientService.getAmountOfPatients();
        int amountOfPages = (totalAmountOfPatients - 1) / amountOfNotesOnTheTable + 1;

        List<Patient> currentPatientList = patientService.getPage(newPageNumber, amountOfNotesOnTheTable);

        table.setModel(CustomTableModel.parseListToTableModel(currentPatientList));

        labelItems[1].setText("Page count: " + amountOfPages);
        labelItems[2].setText("Total record counter: " + totalAmountOfPatients);
        labelItems[3].setText(String.valueOf(newPageNumber));
    }

    private void setButtonItemsController() {
        buttonItems[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateComponents(1);
                } catch (ArrayIndexOutOfBoundsException | CustomClientException exception) {
                    Alert.wrongPageAlert();
                }
            }

        });

        buttonItems[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newPageNumber = Integer.parseInt(labelItems[3].getText()) - 1;
                    updateComponents(newPageNumber);
                } catch (ArrayIndexOutOfBoundsException | CustomClientException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });

        buttonItems[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newPageNumber = Integer.parseInt(labelItems[3].getText()) + 1;
                    updateComponents(newPageNumber);
                } catch (ArrayIndexOutOfBoundsException | CustomClientException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });


        buttonItems[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int amountOfNotesOnTheTable = getAmountOfNotesOnTheTable();

                    int totalAmountOfPatients = patientService.getAmountOfPatients();

                    int newPageNumber = (totalAmountOfPatients - 1) / amountOfNotesOnTheTable + 1;
                    updateComponents(newPageNumber);

                } catch (ArrayIndexOutOfBoundsException | CustomClientException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });
    }

    private int getCurrentPage() {
        return Integer.parseInt(labelItems[3].getText());
    }

    private int getAmountOfNotesOnTheTable() {
        return (int) pageSpinner.getValue();
    }

    public void setMenuItemsController() {
        menuItems[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadFromFileView(patientService);
            }
        });

        menuItems[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveToFileView(patientService);
            }
        });

        menuItems[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatientView(patientService);
            }
        });

        menuItems[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletePatientView(patientService);
            }
        });

        menuItems[4].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchPatientView(patientService);
            }
        });
    }
}
