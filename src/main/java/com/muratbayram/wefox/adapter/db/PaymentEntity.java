package com.muratbayram.wefox.adapter.db;

import com.muratbayram.wefox.core.model.Payment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    private String paymentId;
    private Long accountId;
    private String paymentType;
    private String creditCard;
    private BigDecimal amount;
    private Date createdOn;

    public PaymentEntity() {
    }

    public PaymentEntity(Payment payment) {
        this.paymentId = payment.getPaymentId();
        this.accountId = payment.getAccountId();
        this.paymentType = payment.getPaymentType();
        this.creditCard = payment.getCreditCard();
        this.amount = payment.getAmount();
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
