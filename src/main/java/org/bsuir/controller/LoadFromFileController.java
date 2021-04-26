package org.bsuir.controller;

import org.bsuir.parser.PatientsXMLReader;
import org.bsuir.service.PatientService;
import org.bsuir.view.Alert;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;

public class LoadFromFileController {
    private final JFileChooser fileChooser;
    private final PatientService patientService;

    public LoadFromFileController(JFileChooser fileChooser, PatientService patientService) {
        this.fileChooser = fileChooser;

        this.patientService = patientService;
        addActionListener();
        fileChooser.showOpenDialog(null);
    }

    private void addActionListener() {
        fileChooser.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int actionTypeNumber = fileChooser.getApproveButtonMnemonic();
                    if (actionTypeNumber == JFileChooser.APPROVE_OPTION) {

                        PatientsXMLReader xmlReader = new PatientsXMLReader(fileChooser.getSelectedFile());

                        //todo reset model
                        //  patientsTableModel.resetModel(xmlReader.readAll());
                    }
                } catch (IllegalArgumentException | SAXException | ParserConfigurationException exception) {
                    Alert.incorrectFormatAlert();
                }
            }
        });
    }

}
