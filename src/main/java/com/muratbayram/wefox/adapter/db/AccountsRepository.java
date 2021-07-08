package com.muratbayram.wefox.adapter.db;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AccountsRepository extends CrudRepository<AccountEntity, Long> {

    @Modifying
    @Query(value = "Update AccountEntity acc set acc.lastPaymentDate=:paymentDate " +
            "where acc.accountId = :accountId and (acc.lastPaymentDate is null or acc.lastPaymentDate < :paymentDate)")
    void updateLastPaymentDate(Long accountId, Date paymentDate);
}
