package org.bsuir.request;

import org.bsuir.model.Patient;
import org.bsuir.util.RequestType;

import java.util.List;

public class FindPageByList extends ServerRequest {
    private final int page;
    private final int amountOfDataOnThePage;
    private final List<Patient> listOfPatients;


    public FindPageByList(int page, int amountOfDataOnThePage, List<Patient> listOfPatients) {
        this.page = page;
        this.amountOfDataOnThePage = amountOfDataOnThePage;
        this.listOfPatients = listOfPatients;
        this.requestType = RequestType.FIND_PAGE_BY_LIST;
    }

    public int getAmountOfDataOnThePage() {
        return amountOfDataOnThePage;
    }

    public int getPage() {
        return page;
    }

    public List<Patient> getListOfPatients() {
        return listOfPatients;
    }
}
