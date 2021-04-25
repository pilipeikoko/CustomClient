package org.bsuir.request;

import org.bsuir.util.RequestType;

public class FindPage extends ServerRequest {
    private final int page;
    private final int amountOfDataOnThePage;


    public FindPage(int page, int amountOfDataOnThePage) {
        this.page = page;
        this.amountOfDataOnThePage = amountOfDataOnThePage;
        this.requestType = RequestType.FIND_PAGE;
    }

    public int getAmountOfDataOnThePage() {
        return amountOfDataOnThePage;
    }

    public int getPage() {
        return page;
    }
}
