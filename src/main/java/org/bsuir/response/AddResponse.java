package org.bsuir.response;

public class AddResponse extends ServerResponse {
    private boolean isAdded;

    public AddResponse() {
        super();
        isAdded = false;
    }

    public AddResponse(boolean flag) {
        this.isAdded = flag;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void isAdded(boolean added) {
        isAdded = added;
    }
}
