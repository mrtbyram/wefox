package com.muratbayram.wefox.core.model;

import java.math.BigDecimal;

public class Payment {

    private String paymentId;
    private Long accountId;
    private BigDecimal amount;
    private Integer delay;
    private String paymentType;
    private String creditCard;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", delay=" + delay +
                ", paymentType='" + paymentType + '\'' +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
