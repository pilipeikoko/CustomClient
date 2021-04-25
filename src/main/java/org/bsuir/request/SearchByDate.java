package org.bsuir.request;

import org.bsuir.util.CustomDate;
import org.bsuir.util.RequestType;

public class SearchByDate extends ServerRequest{
    private CustomDate date;

    public SearchByDate(){
        super();
        this.requestType = RequestType.SEARCH_BY_BIRTHDAY;
    }

    public SearchByDate(CustomDate date){
        this.date = date;
        this.requestType = RequestType.SEARCH_BY_BIRTHDAY;
    }

    public CustomDate getDate() {
        return date;
    }
}
