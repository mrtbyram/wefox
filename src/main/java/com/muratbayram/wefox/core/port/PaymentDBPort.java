package com.muratbayram.wefox.core.port;

import com.muratbayram.wefox.core.model.Payment;
import reactor.core.publisher.Mono;

public interface PaymentDBPort {
    Mono<Void> insert(Payment payment);
}
