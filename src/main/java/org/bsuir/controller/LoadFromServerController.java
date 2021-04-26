package org.bsuir.controller;

import org.bsuir.exception.CustomClientException;
import org.bsuir.service.PatientService;
import org.bsuir.view.Alert;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoadFromServerController {
    private final JTextField loadFromServerTextField;
    private final JButton loadButton;
    private final PatientService patientService;

    public LoadFromServerController(PatientService patientService, JTextField saveOnServerTextField, JButton saveButton) {
        this.loadButton = saveButton;
        this.loadFromServerTextField = saveOnServerTextField;
        this.patientService = patientService;
        addLoadButtonListener();
    }

    private void addLoadButtonListener() {
        loadButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String currentPath = loadFromServerTextField.getText();

                    patientService.readFromFile(currentPath);
                    SwingUtilities.getWindowAncestor(loadButton).dispose();
                } catch (CustomClientException exception) {
                    Alert.unsuccessfulOpenFileAlert();
                }
            }
        });
    }
}
