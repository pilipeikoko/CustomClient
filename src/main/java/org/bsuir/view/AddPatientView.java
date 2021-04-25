package org.bsuir.view;

import org.bsuir.controller.AddPatientController;
import org.bsuir.service.PatientService;

public class AddPatientView {

    public AddPatientView(PatientService patientService){
        AddPatientBuilder addPatientBuilder = new AddPatientBuilder();
        new AddPatientController(addPatientBuilder.getTextFields(), addPatientBuilder.getDatePanels(),
                addPatientBuilder.getEnterButton(),patientService);
    }
}
