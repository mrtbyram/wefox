package com.muratbayram.wefox.core.port;

import com.muratbayram.wefox.core.model.Payment;

public interface PaymentDBPort {
    void insert(Payment payment);
}
