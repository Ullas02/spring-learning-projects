package com.example.di.component.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentGateway gateway;

    public PaymentService(
            @Qualifier("upiPayment")
            PaymentGateway gateway) {

        this.gateway = gateway;
    }

    public void makePayment() {
        gateway.pay();
    }

}