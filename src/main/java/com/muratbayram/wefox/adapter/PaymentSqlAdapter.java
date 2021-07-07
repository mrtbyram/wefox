package com.muratbayram.wefox.adapter;

import com.muratbayram.wefox.adapter.db.PaymentEntity;
import com.muratbayram.wefox.adapter.db.PaymentsRepository;
import com.muratbayram.wefox.core.model.Payment;
import com.muratbayram.wefox.core.port.PaymentDBPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentSqlAdapter implements PaymentDBPort {

    private PaymentsRepository repository;

    @Autowired
    public PaymentSqlAdapter(PaymentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Payment payment) {
        repository.save(new PaymentEntity(payment));
    }
}
