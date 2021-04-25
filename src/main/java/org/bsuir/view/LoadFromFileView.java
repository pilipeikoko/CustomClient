package org.bsuir.view;

import org.bsuir.controller.LoadFromFileController;
import org.bsuir.service.PatientService;

import javax.swing.*;

public class LoadFromFileView {

    public LoadFromFileView(PatientService patientService) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load from");
        new LoadFromFileController(fileChooser,patientService);
    }
}
