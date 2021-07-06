package com.muratbayram.wefox.core.model;

public class OnlinePayment extends Payment {
    private String creditCard;

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "OnlinePayment{" +
                "creditCard='" + creditCard + '\'' +
                "} " + super.toString();
    }
}
