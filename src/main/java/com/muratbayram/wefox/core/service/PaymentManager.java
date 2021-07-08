package com.muratbayram.wefox.core.service;

import com.muratbayram.wefox.core.model.PaymentDTO;
import com.muratbayram.wefox.core.model.PaymentErrorDTO;
import com.muratbayram.wefox.core.port.PaymentDBPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.function.Consumer;

@Service
public class PaymentManager {

    @Value("${wefox.endpoint.payment}")
    private String paymentEndpoint;
    @Value("${wefox.endpoint.error-log}")
    private String logEndpoint;

    private WebClient paymentCheckClient;
    private WebClient errorLogClient;
    private PaymentDBPort paymentDB;

    @Autowired
    public PaymentManager(PaymentDBPort paymentDB) {
        this.paymentDB = paymentDB;
    }

    @PostConstruct
    private void init(){
        paymentCheckClient = WebClient.create("http://" + paymentEndpoint);
        errorLogClient = WebClient.create("http://" + logEndpoint);
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
        paymentCheckClient.post().uri("payment")
                .bodyValue(paymentDTO)
                .retrieve()
                .toBodilessEntity()
                .doOnError((ex) -> createErrorLog(paymentDTO, "network", ex.getMessage()))
                .subscribe((res) -> createPayment(paymentDTO));
    }

    private void createPayment(PaymentDTO paymentDTO){
        System.out.println("Creating successful payment " + paymentDTO.getPaymentId());
        paymentDB.insert(paymentDTO.toPayment())
                .doOnError((ex) -> createErrorLog(paymentDTO, "database", ex.getMessage()))
                .subscribe();
    }

    private void createErrorLog(PaymentDTO paymentDTO, String type, String message){
        System.out.println("Creating error log " + paymentDTO.getPaymentId());

        PaymentErrorDTO errorDTO = new PaymentErrorDTO();
        errorDTO.setPaymentId(paymentDTO.getPaymentId());
        errorDTO.setErrorType(type);
        errorDTO.setErrorDescription(message);

        errorLogClient.post().uri("log")
                .bodyValue(errorDTO)
                .retrieve()
                .toBodilessEntity().subscribe();
    }
}
