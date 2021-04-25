package org.bsuir.response;

public class DeleteResponse extends ServerResponse{
    int amount;

    public DeleteResponse(){
        super();
    }

    public DeleteResponse(int amount){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
