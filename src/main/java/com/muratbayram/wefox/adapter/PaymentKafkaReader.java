package com.muratbayram.wefox.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.muratbayram.wefox.core.service.PaymentManager;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentKafkaReader {

    private ObjectMapper mapper = new ObjectMapper();

    private PaymentManager paymentManager;

    public PaymentKafkaReader(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    @KafkaListener(topics = {"offline", "online"})
    public void receiveOfflinePayment(String paymentData){
        PaymentDTO paymentDTO = readPayment(paymentData);

        paymentManager.handle(paymentDTO.toPayment());
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
