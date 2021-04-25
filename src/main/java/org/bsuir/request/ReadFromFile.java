package org.bsuir.request;

public class ReadFromFile extends ServerRequest{
    private String path;

    public ReadFromFile(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
