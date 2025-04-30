package com.network.objectprotocol;

import java.io.Serializable;
import java.util.UUID;

public class UpdateDonatorRequest implements IRequest, Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String nume;
    private String adresa;
    private String numarTelefon;

    public UpdateDonatorRequest(UUID id, String nume, String adresa, String numarTelefon) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }
}