package org.bsuir.controller;

import org.bsuir.parser.PatientsXMLWriter;
import org.bsuir.service.PatientService;
import org.bsuir.view.Alert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SaveToFileController {
    private final JFileChooser fileChooser;
    private final PatientService patientService;

    public SaveToFileController(JFileChooser fileChooser, PatientService patientService) {
        this.fileChooser = fileChooser;
        this.patientService = patientService;
        addActionListener();
        fileChooser.showOpenDialog(null);
    }

    private void addActionListener() {
        fileChooser.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int actionTypeNumber = fileChooser.getApproveButtonMnemonic();
                if (actionTypeNumber == JFileChooser.OPEN_DIALOG) {
                    try {
                        PatientsXMLWriter xmlWriter = new PatientsXMLWriter(fileChooser.getSelectedFile());

                        //todo server get all patients
                       // xmlWriter.writeAll(patientsTableModel.getAllPatients());
                    } catch (IOException exception) {
                        Alert.unsuccessfulWriteToFileAlert();
                    }
                }
            }
        });
    }
}

