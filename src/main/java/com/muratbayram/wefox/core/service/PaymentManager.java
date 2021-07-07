package com.muratbayram.wefox.core.service;

import com.muratbayram.wefox.core.model.Payment;
import com.muratbayram.wefox.core.port.PaymentDBPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager {

    private PaymentDBPort paymentDB;

    @Autowired
    public PaymentManager(PaymentDBPort paymentDB) {
        this.paymentDB = paymentDB;
    }

    public void handle(Payment payment) {
        paymentDB.insert(payment);
    }

}
