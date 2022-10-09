package com.microservice.hrpayroll.services;

import com.microservice.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

// TO INSTANTIATE A INSTANCE OF PAYMENT //
// @Service = REGISTER THIS CLASS AS A SPRING'S COMPONENT //
@Service
public class PaymentService {

    public Payment getPayment (Long workerId, int days){
        return new Payment("JOAO", 200.00, days);
    }
}
