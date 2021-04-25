package org.bsuir.request;

import org.bsuir.util.CustomDate;
import org.bsuir.util.RequestType;

public class DeleteByDate extends ServerRequest {
    private CustomDate date;

    public DeleteByDate() {
        super();
    }

    public DeleteByDate(CustomDate date) {
        super();
        this.date = date;
        this.requestType = RequestType.SEARCH_BY_BIRTHDAY;
    }

    public CustomDate getDate() {
        return date;
    }
}
