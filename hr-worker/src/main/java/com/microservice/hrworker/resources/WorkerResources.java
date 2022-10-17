package com.microservice.hrworker.resources;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// CONNECTING INTO WEB AND @RequestMapping(value = "/workers") CREATES A ENDPOINT
@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

    // TO PRINT INFO INTO LOG
    private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    // ENCAPSULATES A HTTP RESPONSE //
    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> listWorker = repository.findAll();
        return ResponseEntity.ok(listWorker);
    }

    // @PathVariable = RECOGNIZES Long id w/ MAPPED id "/{id}"
    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        // TO PRINT THE NUMBER OF THE PORT THAT THE INSTANCE IS RUNNING
        logger.info("Port = " + env.getProperty("local.server.port"));

        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
