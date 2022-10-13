package com.microservice.hrpayroll.services;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

// TO INSTANTIATE A INSTANCE OF PAYMENT //
// @Service = REGISTER THIS CLASS AS A SPRING'S COMPONENT //
@Service
public class PaymentService {

    // "MACETE" PARA GUARDAR O VALOR DO APPLICATION.PROPERTIES QUE LINK AO HR-WORKER EM UM VARIÁVEL
    @Value("${hr-worker.host}")
    private String wokerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment (Long workerId, int days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());

        // wokerHost + "/workers/{id}" = THE ID WILL RELATE TO THE ID ADDED IN THE MAP
        Worker worker = restTemplate.getForObject(wokerHost + "/workers/{id}", Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
