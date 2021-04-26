package org.bsuir.model;

import org.bsuir.util.Parameters;

import javax.swing.table.DefaultTableModel;
import java.util.*;

public class CustomTableModel extends DefaultTableModel {

    private CustomTableModel() {

        super(Parameters.defaultData, Parameters.TABLE_HEADER);
    }

    public static CustomTableModel parseListToTableModel(List<Patient> list) {
        CustomTableModel model = new CustomTableModel();

        for (Patient patient : list) {
            model.addRow(parsePatient(patient));
        }

        return model;
    }

    private static Object[] parsePatient(Patient patient) {

        Object[] objects = new Object[6];
        objects[0] = patient.getFullName();
        objects[1] = patient.getPlaceOfResidence();
        objects[2] = patient.getBirthday().toString();
        objects[3] = patient.getDateOfReceipt().toString();
        objects[4] = patient.getDoctorsFullName();
        objects[5] = patient.getConclusion();
        return objects;
    }

}
