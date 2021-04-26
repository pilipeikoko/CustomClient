package org.bsuir.view;

import com.tagmycode.plugin.gui.TextPrompt;
import org.bsuir.controller.LoadFromServerController;
import org.bsuir.controller.SaveOnServerController;
import org.bsuir.service.PatientService;
import org.bsuir.view.border.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class LoadFromServerView {

    private final JTextField loadFromFileTextField;
    private final JButton saveButton;

    public LoadFromServerView(PatientService patientService) {
        JDialog dialog = new JDialog();

        Font font = new Font("TimesRoman", Font.ITALIC, 12);


        loadFromFileTextField = new JTextField();
        TextPrompt systemIdentifierPrompt = new TextPrompt("Path to file on server", loadFromFileTextField);
        systemIdentifierPrompt.setFont(font);

        saveButton = new JButton("Load");

        saveButton.setForeground(Color.BLACK);
        saveButton.setBackground(Color.WHITE);
        saveButton.setBorder(new RoundedBorder(5));

        dialog.add(loadFromFileTextField, BorderLayout.NORTH);
        dialog.add(saveButton, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        new LoadFromServerController(patientService, getLoadFromFileTextField(), getLoadButton());
    }

    public JButton getLoadButton() {
        return saveButton;
    }

    public JTextField getLoadFromFileTextField() {
        return loadFromFileTextField;
    }
}
