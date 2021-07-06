package com.muratbayram.wefox.core.service;

import com.muratbayram.wefox.core.model.OfflinePayment;
import org.springframework.stereotype.Service;

@Service
public class OfflinePaymentManager {

    public void handle(OfflinePayment payment) {
        System.out.println("Offline Payment arrived: " + payment);
    }

}
