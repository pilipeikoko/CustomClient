package org.bsuir.view;

import javax.swing.*;

public class Alert {

    public static void deletionAlert(int amount) {
        if (amount == 0)
            unsuccessfulDeletionAlert();
        else
            successfulDeletionAlert(amount);
    }

    private static void successfulDeletionAlert(int amount) {
        JOptionPane.showMessageDialog(null, amount + " patients was successfully removed");
    }

    private static void unsuccessfulDeletionAlert() {
        JOptionPane.showMessageDialog(null, "Nothing found");
    }

    public static void successfulAddingAlert() {
        JOptionPane.showMessageDialog(null, "Successfully added");
    }

    public static void unsuccessfulAddingAlert(String reason) {
        JOptionPane.showMessageDialog(null, "Incorrect format: " + reason);
    }

    public static void wrongPageAlert() {
        JOptionPane.showMessageDialog(null, "Wrong page");
    }

    public static void unknownTypeAlert() {
        JOptionPane.showMessageDialog(null, "Unknown type");
    }

    public static void unsuccessfulSearchAlert(String reason) {
        JOptionPane.showMessageDialog(null, reason);
    }

    public static void unsuccessfulOpenFileAlert() {
        JOptionPane.showMessageDialog(null, "Couldn't open file");
    }

    public static void unsuccessfulWriteToFileAlert() {
        JOptionPane.showMessageDialog(null, "Couldn't write to file");
    }

    public static void loadFromFileAlert() {
        JOptionPane.showMessageDialog(null, "Couldn't save to file");
    }

    public static void incorrectFormatAlert() {
        JOptionPane.showMessageDialog(null, "Only XML formats are supported");
    }
}