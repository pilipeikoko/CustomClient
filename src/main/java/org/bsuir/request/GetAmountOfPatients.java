package org.bsuir.request;

import org.bsuir.util.RequestType;

public class GetAmountOfPatients extends ServerRequest {
    private int amountOfPatients;

    public GetAmountOfPatients(int amountOfPatients) {
        this.amountOfPatients = amountOfPatients;
        this.requestType = RequestType.GET_AMOUNT_OF_PATIENTS;
    }

    public GetAmountOfPatients() {
        this.requestType = RequestType.GET_AMOUNT_OF_PATIENTS;
    }

    public int getAmountOfPatients() {
        return amountOfPatients;
    }
}
