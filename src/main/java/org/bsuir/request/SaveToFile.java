package org.bsuir.request;

public class SaveToFile extends ServerRequest {
    private String path;

    public SaveToFile(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
