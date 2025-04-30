package com.network.objectprotocol;

import java.io.Serializable;

public class AddCazCaritabilRequest implements IRequest, Serializable {
    private static final long serialVersionUID = 1L;

    private String nume;
    private double suma;

    public AddCazCaritabilRequest(String nume, double suma) {
        this.nume = nume;
        this.suma = suma;
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