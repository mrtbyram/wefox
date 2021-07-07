package com.muratbayram.wefox.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentErrorDTO {

    @JsonProperty("payment_id")
    private String paymentId;
    @JsonProperty("error_type")
    private String errorType;
    @JsonProperty("error_description")
    private String errorDescription;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
