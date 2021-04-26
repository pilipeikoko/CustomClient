package org.bsuir.request;

import org.bsuir.util.RequestType;

public class SearchByFullNameOrAddress extends ServerRequest {
    private String fullName;
    private String address;

    public SearchByFullNameOrAddress() {
        super();
    }

    public SearchByFullNameOrAddress(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
        this.requestType = RequestType.SEARCH_BY_FULL_NAME_OR_ADDRESS;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }
}
