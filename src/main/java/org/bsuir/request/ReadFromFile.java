package org.bsuir.request;

import org.bsuir.util.RequestType;

public class ReadFromFile extends ServerRequest {
    private String path;

    public ReadFromFile(String path) {
        this.requestType = RequestType.READ_FROM_FILE;
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
