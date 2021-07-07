package com.muratbayram.wefox.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PaymentDTO {

    @JsonProperty("payment_id")
    private String paymentId;
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("payment_type")
    private String paymentType;
    @JsonProperty("credit_card")
    private String creditCard;
    private BigDecimal amount;
    private Integer delay;

    public Payment toPayment(){
        Payment payment = new Payment();
        payment.setPaymentId(this.paymentId);
        payment.setAccountId(this.accountId);
        payment.setAmount(this.amount);
        payment.setDelay(this.delay);
        payment.setCreditCard(this.creditCard);
        payment.setPaymentType(this.paymentType);
        return payment;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentId='" + paymentId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", creditCard='" + creditCard + '\'' +
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
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
