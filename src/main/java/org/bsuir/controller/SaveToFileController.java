package org.bsuir.controller;

import org.bsuir.exception.CustomClientException;
import org.bsuir.model.Patient;
import org.bsuir.parser.PatientsXMLWriter;
import org.bsuir.service.PatientService;
import org.bsuir.view.Alert;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

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

                        List<Patient> fullPatientsList = patientService.getAllPatients();
                        xmlWriter.writeAll(fullPatientsList);
                    } catch (IOException | ParserConfigurationException | TransformerException | SAXException | CustomClientException exception) {
                        Alert.unsuccessfulWriteToFileAlert();
                    }
                }
            }
        });
    }
}

