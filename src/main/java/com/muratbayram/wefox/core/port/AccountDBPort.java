package com.muratbayram.wefox.core.port;

import java.util.Date;

public interface AccountDBPort {

    void updateLastPayment(Long accountId, Date paymentDate);

}
