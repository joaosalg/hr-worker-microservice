package com.microservice.hrpayroll.feignclients;

import com.microservice.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @COMPONENT = MEANS THAT THIS IS A COMPONENT GERENCIADO PELO SPRING PARA INJETAR EM OUTRAS CLASSES
@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping(value = "{id}")
    ResponseEntity<Worker> findById (@PathVariable Long id);
}
