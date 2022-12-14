package com.microservice.hrworker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// @Entity MAPS THIS CLASS INTO A TABLE IN THE RELATIONAL DB //
@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    // @Id = DEFINES THIS VARIABLE AS A PRIMARY KEY //
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.IDENTITY) = GENERATES A ID AUTOMATICALLY //
    private Long id;

    private String name;
    private Double dailyIncome;

    public Worker() {
    }

    public Worker(Long id, String name, Double dailyIncome) {
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
