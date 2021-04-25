package org.bsuir.response;

import org.bsuir.model.Patient;

import java.util.List;

public class SearchResponse extends ServerResponse {
    private List<Patient> listOfPatients;

    public SearchResponse() {
        super();
    }

    public SearchResponse(List<Patient> list) {
        this.listOfPatients = list;
    }

    public List<Patient> getListOfPatients() {
        return listOfPatients;
    }

    public void setListOfPatients(List<Patient> listOfPatients) {
        this.listOfPatients = listOfPatients;
    }

    public int amountOfPatients() {
        return listOfPatients.size();
    }
}
