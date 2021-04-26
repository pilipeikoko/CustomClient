package org.bsuir.request;

import org.bsuir.util.RequestType;

public class SaveToFile extends ServerRequest {
    private String path;

    public SaveToFile(String path) {
        this.requestType = RequestType.SAVE_TO_FILE;
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
