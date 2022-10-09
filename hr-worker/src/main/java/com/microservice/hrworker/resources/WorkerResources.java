package com.microservice.hrworker.resources;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
