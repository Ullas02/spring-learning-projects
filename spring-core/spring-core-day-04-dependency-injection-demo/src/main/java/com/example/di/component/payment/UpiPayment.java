package com.example.di.component.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UpiPayment implements PaymentGateway {

    @Override
    public void pay() {
        System.out.println("Payment using UPI");
    }

}