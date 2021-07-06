package com.muratbayram.wefox.adapter.db;

import com.muratbayram.wefox.core.port.PaymentDBPort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends CrudRepository<PaymentEntity, String> {

}
