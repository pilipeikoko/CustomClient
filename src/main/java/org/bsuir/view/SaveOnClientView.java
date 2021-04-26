package org.bsuir.view;

import org.bsuir.controller.SaveToFileController;
import org.bsuir.service.PatientService;

import javax.swing.*;

public class SaveOnClientView {
    public SaveOnClientView(PatientService patientService) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save to");
        new SaveToFileController(fileChooser,patientService);
    }
}
