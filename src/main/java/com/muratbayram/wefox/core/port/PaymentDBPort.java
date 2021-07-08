package com.muratbayram.wefox.core.port;

import com.muratbayram.wefox.adapter.db.PaymentEntity;
import com.muratbayram.wefox.core.model.Payment;
import reactor.core.publisher.Mono;

public interface PaymentDBPort {
    Mono<PaymentEntity> insert(Payment payment);
}
