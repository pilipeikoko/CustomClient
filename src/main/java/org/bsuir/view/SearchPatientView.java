package org.bsuir.view;

import org.bsuir.controller.SearchPatientController;
import org.bsuir.service.PatientService;

public class SearchPatientView {

    public SearchPatientView(PatientService patientService) {
        SearchPatientBuilder searchPatientBuilder = new SearchPatientBuilder();
        new SearchPatientController(searchPatientBuilder.getDeleteButton(),
                searchPatientBuilder.getCardsTextFields(), searchPatientBuilder.getCardsLabelItems(),
                searchPatientBuilder.getCardsDatePanels(), searchPatientBuilder.getSearchByTypeComboBox(),
                searchPatientBuilder.getTable(), searchPatientBuilder.getPageButtonItems(),
                searchPatientBuilder.getPageSpinner(), searchPatientBuilder.getPageLabelItems(),
                searchPatientBuilder.getCards(),patientService);
    }

}
