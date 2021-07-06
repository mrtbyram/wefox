package com.muratbayram.wefox.core.service;

import com.muratbayram.wefox.core.model.OnlinePayment;
import org.springframework.stereotype.Service;

@Service
public class OnlinePaymentManager {

    public void handle(OnlinePayment payment) {
        System.out.println("Online Payment arrived: " + payment);
    }
}
