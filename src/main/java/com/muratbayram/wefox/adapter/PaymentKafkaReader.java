package com.muratbayram.wefox.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.muratbayram.wefox.core.model.OfflinePayment;
import com.muratbayram.wefox.core.model.OnlinePayment;
import com.muratbayram.wefox.core.service.OfflinePaymentManager;
import com.muratbayram.wefox.core.service.OnlinePaymentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentKafkaReader {

    private ObjectMapper mapper = new ObjectMapper();

    private OfflinePaymentManager offlinePaymentManager;
    private OnlinePaymentManager onlinePaymentManager;

    @Autowired
    public PaymentKafkaReader(OfflinePaymentManager offlinePaymentManager, OnlinePaymentManager onlinePaymentManager) {
        this.offlinePaymentManager = offlinePaymentManager;
        this.onlinePaymentManager = onlinePaymentManager;
    }

    @KafkaListener(topics = "offline")
    public void receiveOfflinePayment(String paymentData){
        PaymentDTO paymentDTO = readPayment(paymentData);

        offlinePaymentManager.handle(paymentDTO.toOfflinePayment());
    }

    @KafkaListener(topics = "online")
    public void receiveOnlinePayment(String paymentData){
        PaymentDTO paymentDTO = readPayment(paymentData);

        onlinePaymentManager.handle(paymentDTO.toOnlinePayment());
    }

    private PaymentDTO readPayment(String data){
        try {
            return mapper.readValue(data, PaymentDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
