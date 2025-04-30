package com.network.objectprotocol;

import java.io.Serializable;
import java.util.UUID;

public class UpdateCazCaritabilRequest implements IRequest, Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String nume;
    private double suma;

    public UpdateCazCaritabilRequest(UUID id, String nume, double suma) {
        this.id = id;
        this.nume = nume;
        this.suma = suma;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }
}