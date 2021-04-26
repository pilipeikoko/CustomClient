package org.bsuir.response;

import org.bsuir.model.Patient;

import java.util.List;

public class PageResponse extends ServerResponse {
    private final List<Patient> listOfPatients;

    public PageResponse(List<Patient> list) {
        this.listOfPatients = list;
    }

    public List<Patient> getListOfPatients() {
        return listOfPatients;
    }
}
