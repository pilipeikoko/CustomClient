package org.bsuir.view;

import org.bsuir.util.DateLabelFormatter;
import org.jdatepicker.impl.*;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;


public class AddPatientBuilder {
    private final JDialog dialog;

    private final static int AMOUNT_OF_LABELS = 6;
    private final static int AMOUNT_OF_TEXT_FIELDS = 4;
    private final static int AMOUNT_OF_DATE_PANELS = 2;

    private final JLabel[] labelItems;
    private final JTextField[] textFields;
    private final JDatePanelImpl[] datePanels;
    private final JDatePickerImpl[] datePickers;
    private final JButton enterButton;


    public AddPatientBuilder() {
        labelItems = new JLabel[AMOUNT_OF_LABELS];
        textFields = new JTextField[AMOUNT_OF_TEXT_FIELDS];
        datePanels = new JDatePanelImpl[AMOUNT_OF_DATE_PANELS];
        datePickers = new JDatePickerImpl[AMOUNT_OF_DATE_PANELS];
        enterButton = new JButton("Enter");

        addLabels();
        addTextFields();
        addDateComponents();

        dialog = new JDialog();
        setDialog();
    }

    private void setDialog() {
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocation(550, 250);
        dialog.setPreferredSize(new Dimension(450, 300));

        GroupLayout layout = new GroupLayout(dialog.getContentPane());
        dialog.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        setHorizontalLayout(layout);
        setVerticalLayout(layout);

        dialog.pack();
        dialog.setVisible(true);
    }

    private void addDateComponents() {
        UtilDateModel dateOfBirthModel = new UtilDateModel();
        JDatePanelImpl dateOfBirthPanel = new JDatePanelImpl(dateOfBirthModel, new Properties());
        JDatePickerImpl dateOfBirthPicker = new JDatePickerImpl(dateOfBirthPanel, new DateLabelFormatter());

        UtilDateModel dateOfReceiptModel = new UtilDateModel();
        JDatePanelImpl dateOfReceiptPanel = new JDatePanelImpl(dateOfReceiptModel, new Properties());
        JDatePickerImpl dateOfReceiptPicker = new JDatePickerImpl(dateOfReceiptPanel, new DateLabelFormatter());


        datePanels[0] = dateOfBirthPanel;
        datePanels[1] = dateOfReceiptPanel;


        datePickers[0] = dateOfBirthPicker;
        datePickers[1] = dateOfReceiptPicker;
    }

    private void setVerticalLayout(GroupLayout layout) {
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(labelItems[0])
                        .addComponent(labelItems[4]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(textFields[0])
                        .addComponent(datePickers[0]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labelItems[1])
                        .addComponent(labelItems[5]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(textFields[1])
                        .addComponent(datePickers[1]))
                .addComponent(labelItems[2])
                .addComponent(textFields[2])
                .addComponent(labelItems[3])
                .addComponent(textFields[3])
                .addComponent(enterButton)
        );
    }

    private void setHorizontalLayout(GroupLayout layout) {
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(labelItems[0])
                        .addComponent(textFields[0])
                        .addComponent(labelItems[1])
                        .addComponent(textFields[1])
                        .addComponent(labelItems[2])
                        .addComponent(textFields[2])
                        .addComponent(labelItems[3])
                        .addComponent(textFields[3])
                        .addComponent(enterButton))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labelItems[4])
                        .addComponent(datePickers[0])
                        .addComponent(labelItems[5])
                        .addComponent(datePickers[1])
                )
        );
    }

    private void addTextFields() {
        JTextField fullNameTextField = new JTextField();
        JTextField addressTextField = new JTextField();
        JTextField doctorsNameTextField = new JTextField();
        JTextField conclusionTextField = new JTextField();

        textFields[0] = fullNameTextField;
        textFields[1] = addressTextField;
        textFields[2] = doctorsNameTextField;
        textFields[3] = conclusionTextField;
    }

    private void addLabels() {
        JLabel fullNameLabel = new JLabel("Full name");
        JLabel addressLabel = new JLabel("Address");
        JLabel doctorsNameLabel = new JLabel("Doctor name");
        JLabel conclusionLabel = new JLabel("Conclusion");
        JLabel dateOfBirthLabel = new JLabel("Date of birth");
        JLabel dateOfReceiptLabel = new JLabel("Date of receipt");

        labelItems[0] = fullNameLabel;
        labelItems[1] = addressLabel;
        labelItems[2] = doctorsNameLabel;
        labelItems[3] = conclusionLabel;
        labelItems[4] = dateOfBirthLabel;
        labelItems[5] = dateOfReceiptLabel;
    }

    public JDatePanelImpl[] getDatePanels() {
        return datePanels;
    }

    public JDatePickerImpl[] getDatePickers() {
        return datePickers;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public JLabel[] getLabelItems() {
        return labelItems;
    }

    public JTextField[] getTextFields() {
        return textFields;
    }
}
