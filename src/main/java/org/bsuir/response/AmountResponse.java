package org.bsuir.response;

public class AmountResponse extends ServerResponse {
    int amount;

    public AmountResponse() {
        super();
    }

    public AmountResponse(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
