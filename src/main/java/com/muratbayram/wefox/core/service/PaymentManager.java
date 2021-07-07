package com.muratbayram.wefox.core.service;

import com.muratbayram.wefox.core.model.PaymentDTO;
import com.muratbayram.wefox.core.model.PaymentErrorDTO;
import com.muratbayram.wefox.core.port.PaymentDBPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

@Service
public class PaymentManager {

    private WebClient webClient = WebClient.create("http://localhost:9000");
    private PaymentDBPort paymentDB;

    @Autowired
    public PaymentManager(PaymentDBPort paymentDB) {
        this.paymentDB = paymentDB;
    }

    public void handle(PaymentDTO paymentDTO) {
        Consumer<PaymentDTO> handler = "online".equals(paymentDTO.getPaymentType())
                ? this::handleOnline
                : this::handleOffline;

        handler.accept(paymentDTO);
    }

    private void handleOffline(PaymentDTO paymentDTO){
        createPayment(paymentDTO);
    }

    private void handleOnline(PaymentDTO paymentDTO){
        webClient.post().uri("payment")
                .bodyValue(paymentDTO)
                .retrieve()
                .toBodilessEntity()
                .doOnError((ex) -> createErrorLog(paymentDTO, ex.getMessage()))
                .subscribe((res) -> createPayment(paymentDTO));
    }

    private void createPayment(PaymentDTO paymentDTO){
        System.out.println("Creating successful payment " + paymentDTO.getPaymentId());
        paymentDB.insert(paymentDTO.toPayment());

    }

    private void createErrorLog(PaymentDTO paymentDTO, String error){
        System.out.println("Creating error log " + paymentDTO.getPaymentId());

        PaymentErrorDTO errorDTO = new PaymentErrorDTO();
        errorDTO.setPaymentId(paymentDTO.getPaymentId());
        errorDTO.setErrorType("network");
        errorDTO.setErrorDescription(error);

        webClient.post().uri("log")
                .bodyValue(errorDTO)
                .retrieve()
                .toBodilessEntity().subscribe();

    }
}
