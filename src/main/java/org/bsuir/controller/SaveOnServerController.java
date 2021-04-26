package org.bsuir.controller;

import org.bsuir.exception.CustomClientException;
import org.bsuir.service.PatientService;
import org.bsuir.view.Alert;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveOnServerController {
    private final JTextField saveOnServerTextField;
    private final JButton saveButton;
    private final PatientService patientService;

    public SaveOnServerController(PatientService patientService, JTextField saveOnServerTextField, JButton saveButton) {
        this.saveButton = saveButton;
        this.saveOnServerTextField = saveOnServerTextField;
        this.patientService = patientService;
        addSaveButtonListener();
    }

    private void addSaveButtonListener() {
        saveButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String currentPath = saveOnServerTextField.getText();

                    patientService.saveToFile(currentPath);
                } catch (CustomClientException exception) {
                    Alert.unsuccessfulOpenFileAlert();
                }
                SwingUtilities.getWindowAncestor(saveButton).dispose();
            }
        });
    }
}
