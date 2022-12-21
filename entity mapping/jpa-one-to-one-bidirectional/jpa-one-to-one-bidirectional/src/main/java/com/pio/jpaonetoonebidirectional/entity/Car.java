package com.pio.jpaonetoonebidirectional.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String model;
    @OneToOne(mappedBy = "car")
    @JsonBackReference
    private Owner owner;

    public Car() {
    }

    public Car(long id, String model, Owner owner) {
        this.id = id;
        this.model = model;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
