package com.muratbayram.wefox.core.model;

import java.math.BigDecimal;

public abstract class Payment {

    private String paymentId;
    private String accountId;
    private BigDecimal amount;
    private Integer delay;

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", delay=" + delay +
                '}';
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
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
}
