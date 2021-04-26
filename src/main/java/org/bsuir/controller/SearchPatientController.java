package org.bsuir.controller;

import org.bsuir.exception.CustomClientException;
import org.bsuir.exception.EmptyFieldException;
import org.bsuir.model.Patient;
import org.bsuir.service.PatientService;
import org.bsuir.util.CustomDate;
import org.bsuir.model.CustomTableModel;
import org.bsuir.util.Parameters;
import org.bsuir.view.Alert;
import org.bsuir.view.CardsBuilder;
import org.bsuir.view.PageComponentsBuilder;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;

public class SearchPatientController {
    /**
     * @see CardsBuilder#getLabelItems()
     */
    private final JTextField[] cardsTextFields;
    /**
     * @see CardsBuilder#getLabelItems()
     */
    private final JLabel[] cardsLabelItems;
    /**
     * @see CardsBuilder#getLabelItems()
     */
    private final JDatePanelImpl[] cardsDatePanels;

    /**
     * @see PageComponentsBuilder#getButtonItems()
     */
    private final JButton[] pageButtonItems;
    /**
     * @see PageComponentsBuilder#getLabelItems()
     */
    private final JLabel[] pageLabelItems;
    private final JSpinner pageSpinner;

    private final JButton SearchButton;
    private final JComboBox<String> searchByTypeComboBox;
    private final JTable table;
    private final JPanel cards;
    private final PatientService patientService;
    private List<Patient> foundListOfPatients;

    public SearchPatientController(JButton SearchButton, JTextField[] cardsTextFields,
                                   JLabel[] cardsLabelItems, JDatePanelImpl[] datePanel,
                                   JComboBox<String> searchByTypeComboBox, JTable table, JButton[] pageButtonItems,
                                   JSpinner pageSpinner, JLabel[] pageLabelItems, JPanel cards, PatientService patientService) {

        this.table = table;
        this.SearchButton = SearchButton;
        this.searchByTypeComboBox = searchByTypeComboBox;

        this.cards = cards;
        this.cardsDatePanels = datePanel;
        this.cardsLabelItems = cardsLabelItems;
        this.cardsTextFields = cardsTextFields;

        this.pageButtonItems = pageButtonItems;
        this.pageLabelItems = pageLabelItems;
        this.pageSpinner = pageSpinner;
        this.patientService = patientService;
        // this.foundListOfPatients = new ArrayList<>();

        setSearchButtonAction();
        setPageButtonItemsController();
        addComboBoxItemListener();
        addPageSpinnerChangeListener();
    }

    private void addComboBoxItemListener() {
        searchByTypeComboBox.addItemListener(e -> {
            CardLayout layout = (CardLayout) (cards.getLayout());
            layout.show(cards, (String) e.getItem());
        });
    }

    private void setPageButtonItemsController() {
        pageButtonItems[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateComponents(1);
                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                }
            }

        });

        pageButtonItems[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newPageNumber = Integer.parseInt(pageLabelItems[3].getText()) - 1;
                    updateComponents(newPageNumber);
                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });

        pageButtonItems[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newPageNumber = Integer.parseInt(pageLabelItems[3].getText()) + 1;
                    updateComponents(newPageNumber);
                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });


        pageButtonItems[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int amountOfNotesOnTheTable = getAmountOfNotesOnTheTable();

                    if (foundListOfPatients == null) {
                        throw new CustomClientException("Haven't searched");
                    }

                    int totalAmountOfFoundPatients = foundListOfPatients.size();

                    int newPageNumber = (totalAmountOfFoundPatients - 1) / amountOfNotesOnTheTable + 1;
                    updateComponents(newPageNumber);

                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                } catch (CustomClientException exception) {
                    Alert.unsuccessfulSearchAlert("Haven't searched: Click search");
                }
            }
        });
    }

    private void updateComponents(int newPageNumber) throws ArrayIndexOutOfBoundsException {
        int amountOfNotesOnTheTable = getAmountOfNotesOnTheTable();

        try {
            if (foundListOfPatients == null) {
                throw new CustomClientException("Haven't searched");
            }
            if (newPageNumber <= 0) {
                throw new EmptyFieldException("Wrong page number");
            }

            int totalAmountOfFoundPatients = foundListOfPatients.size();
            int amountOfPages = (totalAmountOfFoundPatients - 1) / amountOfNotesOnTheTable + 1;

            List<Patient> currentList = patientService.getPageByList(foundListOfPatients, newPageNumber, amountOfNotesOnTheTable);

            table.setModel(CustomTableModel.parseListToTableModel(currentList));

            pageLabelItems[1].setText("Page count: " + amountOfPages);
            pageLabelItems[2].setText("Total record counter: " + totalAmountOfFoundPatients);
            pageLabelItems[3].setText(String.valueOf(newPageNumber));
        } catch (CustomClientException exception) {
            Alert.unsuccessfulSearchAlert("Haven't searched: click search");
        } catch (EmptyFieldException exception) {
            Alert.wrongPageAlert();
        }
    }

    private void setSearchButtonAction() {
        SearchButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String currentSearchType = (String) searchByTypeComboBox.getSelectedItem();

                    if (currentSearchType == null) {
                        throw new EmptyFieldException("Unknown type");
                    }

                    if (currentSearchType.equals(Parameters.SEARCH_TYPES[0])) {
                        String fullName = getFullName();
                        String address = getAddress();

                        foundListOfPatients = patientService.searchPatientByFullNameOrAddress(fullName, address);
                        updateComponents(1);

                    } else if (currentSearchType.equals(Parameters.SEARCH_TYPES[1])) {
                        CustomDate birthday = new CustomDate(getBirthday());

                        foundListOfPatients = patientService.searchPatientByDate(birthday);
                        updateComponents(1);

                    } else if (currentSearchType.equals(Parameters.SEARCH_TYPES[2])) {
                        String doctorsFullName = getDoctorFullName();
                        CustomDate dateOfReceipt = new CustomDate(getDateOfReceipt());

                        foundListOfPatients = patientService.searchPatientByDoctorsFullNameOrReceiptDate(doctorsFullName, dateOfReceipt);

                        updateComponents(1);
                    }
                } catch (EmptyFieldException exception) {
                    Alert.unknownTypeAlert();
                } catch (CustomClientException exception) {
                    Alert.serverAlert("Couldn't get response");
                }
            }
        });
    }

    private void addPageSpinnerChangeListener() {
        pageSpinner.addChangeListener(e -> {
            try {
                int newPageNumber = Integer.parseInt(pageLabelItems[3].getText());
                updateComponents(newPageNumber);
            } catch (ArrayIndexOutOfBoundsException exception) {
                Alert.wrongPageAlert();
            }
        });
    }

    private int getCurrentPage() {
        return Integer.parseInt(pageLabelItems[3].getText());
    }

    private int getAmountOfNotesOnTheTable() {
        return (int) pageSpinner.getValue();
    }

    private Date getDateOfReceipt() {
        return (Date) cardsDatePanels[1].getModel().getValue();
    }

    private String getDoctorFullName() {
        return cardsTextFields[2].getText();
    }

    private Date getBirthday() {
        return (Date) cardsDatePanels[0].getModel().getValue();
    }

    private String getAddress() {
        return cardsTextFields[1].getText();
    }

    private String getFullName() {
        return cardsTextFields[0].getText();
    }
}
