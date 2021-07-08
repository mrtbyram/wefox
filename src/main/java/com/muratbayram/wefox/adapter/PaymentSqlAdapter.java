package com.muratbayram.wefox.adapter;

import com.muratbayram.wefox.adapter.db.PaymentEntity;
import com.muratbayram.wefox.adapter.db.PaymentsRepository;
import com.muratbayram.wefox.core.model.Payment;
import com.muratbayram.wefox.core.port.PaymentDBPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentSqlAdapter implements PaymentDBPort {

    private PaymentsRepository repository;

    @Autowired
    public PaymentSqlAdapter(PaymentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Void> insert(Payment payment) {
        PaymentEntity entity = new PaymentEntity(payment);
        entity.setCreatedOn(new Date());
        return Mono.fromFuture(CompletableFuture.runAsync(() -> repository.save(entity)));
    }
}
