package org.bsuir.request;

import org.bsuir.model.Patient;
import org.bsuir.util.RequestType;

public class AddRequest extends ServerRequest {
    private Patient patient;

    public AddRequest() {
        super();
        this.requestType = RequestType.ADD;
    }

    public AddRequest(Patient patient) {
        this.patient = patient;
        this.requestType = RequestType.ADD;
    }

    public Patient getPatient() {
        return patient;
    }
}
