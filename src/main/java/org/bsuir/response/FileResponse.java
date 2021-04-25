package org.bsuir.response;

public class FileResponse extends ServerResponse{
    private boolean isSuccess;

    public FileResponse(boolean flag){
        this.isSuccess = flag;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
