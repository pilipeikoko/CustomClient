package org.bsuir.view;

import org.bsuir.controller.MainFrameController;
import org.bsuir.service.PatientService;


public class MainFrameView {

    public MainFrameView(PatientService patientService) {
        MainFrameBuilder frameBuilder = new MainFrameBuilder();

        new MainFrameController(frameBuilder.getMenuBarItems(), frameBuilder.getButtonItems(),
                frameBuilder.getLabelItems(), frameBuilder.getPageSpinner(), frameBuilder.getTable(), frameBuilder.getServiceComponentButtons(), patientService);

    }

}