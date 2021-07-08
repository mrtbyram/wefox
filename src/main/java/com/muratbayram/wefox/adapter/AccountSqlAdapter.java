package com.muratbayram.wefox.adapter;

import com.muratbayram.wefox.adapter.db.AccountsRepository;
import com.muratbayram.wefox.core.port.AccountDBPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Service
public class AccountSqlAdapter implements AccountDBPort {

    private AccountsRepository repository;

    @Autowired
    public AccountSqlAdapter(AccountsRepository repository) {
        this.repository = repository;
    }

    public void updateLastPayment(Long accountId, Date paymentDate){
        repository.updateLastPaymentDate(accountId, paymentDate);
    }
}
