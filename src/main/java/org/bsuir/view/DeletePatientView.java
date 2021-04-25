package org.bsuir.view;

import org.bsuir.controller.DeletePatientController;
import org.bsuir.service.PatientService;

public class DeletePatientView {
    public DeletePatientView(PatientService patientService) {
        DeletePatientBuilder deletePatientBuilder = new DeletePatientBuilder();
        new DeletePatientController(deletePatientBuilder.getDeleteButton(),
                deletePatientBuilder.getTextFields(), deletePatientBuilder.getLabelItems(),
                deletePatientBuilder.getDatePanels(), deletePatientBuilder.getDeleteByTypeComboBox(),
                deletePatientBuilder.getCards(),patientService);
    }
}
