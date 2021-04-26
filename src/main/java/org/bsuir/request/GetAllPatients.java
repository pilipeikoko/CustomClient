package org.bsuir.request;

import org.bsuir.util.RequestType;

public class GetAllPatients extends ServerRequest {

    public GetAllPatients() {
        this.requestType = RequestType.GET_ALL_PATIENTS;
    }
}
