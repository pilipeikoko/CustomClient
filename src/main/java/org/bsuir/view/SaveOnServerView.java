package org.bsuir.view;

import com.tagmycode.plugin.gui.TextPrompt;
import org.bsuir.controller.SaveOnServerController;
import org.bsuir.service.PatientService;
import org.bsuir.view.border.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class SaveOnServerView {

    private final JTextField saveOnServerTextField;
    private final JButton saveButton;

    public SaveOnServerView(PatientService patientService){
        JDialog dialog = new JDialog();

        Font font = new Font("TimesRoman", Font.ITALIC, 12);


        saveOnServerTextField = new JTextField();
        TextPrompt systemIdentifierPrompt = new TextPrompt("Path to file on server", saveOnServerTextField);
        systemIdentifierPrompt.setFont(font);

        saveButton = new JButton("Save");

        saveButton.setForeground(Color.BLACK);
        saveButton.setBackground(Color.WHITE);
        saveButton.setBorder(new RoundedBorder(5));

        dialog.add(saveOnServerTextField,BorderLayout.NORTH);
        dialog.add(saveButton,BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        new SaveOnServerController(patientService,getSaveOnServerTextField(),getSaveButton());
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JTextField getSaveOnServerTextField() {
        return saveOnServerTextField;
    }
}
