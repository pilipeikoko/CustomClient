package org.bsuir.request;

import org.bsuir.util.RequestType;

public class DeleteByFullNameOrAddress extends ServerRequest {
    private String fullName;
    private String address;

    public DeleteByFullNameOrAddress() {
        super();
    }

    public DeleteByFullNameOrAddress(String fullName, String address) {
        super();
        this.fullName = fullName;
        this.address = address;
        this.requestType = RequestType.DELETE_BY_FULL_NAME_OR_ADDRESS;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }
}
