package org.bsuir;

import org.bsuir.service.PatientService;
import org.bsuir.service.impl.PatientServiceImpl;
import org.bsuir.view.MainFrameView;

public class Run
{
    public static void main( String[] args )
    {
        PatientService patientService = new PatientServiceImpl();

        new MainFrameView(patientService);
    }
}
