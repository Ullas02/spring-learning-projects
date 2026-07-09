package com.example.di.component.payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentGateway {

    @Override
    public void pay() {
        System.out.println("Payment using Credit Card");
    }

}