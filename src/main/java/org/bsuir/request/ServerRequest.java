package org.bsuir.request;

import org.bsuir.util.RequestType;

import java.io.Serializable;

public class ServerRequest implements Serializable {
    protected static final long serialVersionUID = 1L;

    protected RequestType requestType;

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }
}
