package org.bsuir.view;

import org.bsuir.util.DateLabelFormatter;
import org.bsuir.util.Parameters;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;
//TODO mb refactor
public class CardsBuilder {
    private static final int AMOUNT_OF_TEXT_FIELDS = 3;
    private static final int AMOUNT_OF_DATE_PANELS = 2;
    private static final int AMOUNT_OF_LABEL_ITEMS = 5;

    private final JPanel cards;
    private final JTextField[] textFields;
    private final JDatePanelImpl[] datePanels;
    private final JLabel[] labelItems;

    public CardsBuilder(){
        textFields = new JTextField[AMOUNT_OF_TEXT_FIELDS];
        datePanels = new JDatePanelImpl[AMOUNT_OF_DATE_PANELS];
        labelItems = new JLabel[AMOUNT_OF_LABEL_ITEMS];

        cards = new JPanel(new CardLayout());

        JPanel surnameOrAddressPanel = createSurnameOrAddressPanel();
        JPanel birthdayPanel = createBirthdayPanel();
        JPanel fullDoctorsNameOrReceiptDatePanel = createFullDoctorsNameOrReceiptDatePanel();

        cards.add(surnameOrAddressPanel, Parameters.SEARCH_TYPES[0]);
        cards.add(birthdayPanel, Parameters.SEARCH_TYPES[1]);
        cards.add(fullDoctorsNameOrReceiptDatePanel,Parameters.SEARCH_TYPES[2]);
    }

    private JPanel createFullDoctorsNameOrReceiptDatePanel() {

        JPanel receiptDatePanel = new JPanel();
        JLabel receiptDateLabel = new JLabel("Receipt date:");

        UtilDateModel dateOfReceiptModel = new UtilDateModel();
        JDatePanelImpl dateOfReceiptPanel = new JDatePanelImpl(dateOfReceiptModel, new Properties());
        JDatePickerImpl dateOfReceiptPicker = new JDatePickerImpl(dateOfReceiptPanel, new DateLabelFormatter());
        dateOfReceiptPanel.setMaximumSize(new Dimension(150,30));
        dateOfReceiptPicker.setMaximumSize(new Dimension(150,30));

        JLabel doctorsFullNameLabel = new JLabel("Doctors full name");
        JTextField doctorsFullNameTextField = new JTextField();
        doctorsFullNameTextField.setMaximumSize(new Dimension(150,30));

        GroupLayout layout = new GroupLayout(receiptDatePanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        receiptDatePanel.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(doctorsFullNameLabel)
                        .addComponent(doctorsFullNameTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(receiptDateLabel)
                        .addComponent(dateOfReceiptPicker)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(doctorsFullNameLabel)
                        .addComponent(doctorsFullNameTextField))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(receiptDateLabel)
                        .addComponent(dateOfReceiptPicker)
                )
        );

        labelItems[3] = receiptDateLabel;
        labelItems[4] = doctorsFullNameLabel;

        textFields[2] = doctorsFullNameTextField;

        datePanels[1] = dateOfReceiptPanel;

        return receiptDatePanel;
    }

    private JPanel createBirthdayPanel() {
        JPanel birthdayPanel = new JPanel();
        JLabel birthdayLabel = new JLabel("Birthday:");

        UtilDateModel dateOfBirthModel = new UtilDateModel();
        JDatePanelImpl dateOfBirthPanel = new JDatePanelImpl(dateOfBirthModel, new Properties());
        JDatePickerImpl dateOfBirthPicker = new JDatePickerImpl(dateOfBirthPanel, new DateLabelFormatter());

        birthdayPanel.add(birthdayLabel);
        birthdayPanel.add(dateOfBirthPicker);

        labelItems[2] = birthdayLabel;
        datePanels[0] = dateOfBirthPanel;

        return birthdayPanel;
    }
    private JPanel createSurnameOrAddressPanel(){
        JPanel surnameOrAddressPanel = new JPanel();

        addSurnameOrAddressPanelComponents();

        surnameOrAddressPanel.setPreferredSize(new Dimension(300,200));

        GroupLayout layout = new GroupLayout(surnameOrAddressPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        surnameOrAddressPanel.setLayout(layout);


        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(labelItems[0])
                        .addComponent(textFields[0]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labelItems[1])
                        .addComponent(textFields[1])
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelItems[0])
                        .addComponent(textFields[0]))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelItems[1])
                        .addComponent(textFields[1])
                )
        );


        return surnameOrAddressPanel;
    }

    private void addSurnameOrAddressPanelComponents() {
        JLabel fullNameLabel = new JLabel("Full name");
        JLabel addressLabel = new JLabel("Address");

        JTextField fullNameTextField = new JTextField();
        fullNameTextField.setMaximumSize(new Dimension(150,30));

        JTextField addressTextField = new JTextField();
        addressTextField.setMaximumSize(new Dimension(150,30));

        textFields[0] = fullNameTextField;
        textFields[1] = addressTextField;

        labelItems[0] = fullNameLabel;
        labelItems[1] = addressLabel;
    }

    /**
     * <br>[0] birthday</br>
     * <br>[1] date of receipt</br>
     */
    public JDatePanelImpl[] getDatePanels() {
        return datePanels;
    }

    /**
     * <br>[0] full name</br>
     * <br>[1] address</br>
     * <br>[2] birthday </br>
     * <br>[3] receipt date</br>
     * <br>[4] doctors full name </br>
     */
    public JLabel[] getLabelItems() {
        return labelItems;
    }

    /**
     * <br>[0] full name</br>
     * <br>[1] address</br>
     * <br>[2] doctors full name</br>
     */
    public JTextField[] getTextFields() {
        return textFields;
    }

    public JPanel getCards() {
        return cards;
    }
}
