package com.network.dto;

import com.domain.Donator;

import java.io.Serializable;
import java.util.UUID;

public class DonatorDTO extends EntityDTO<UUID> implements Serializable {
    private String nume;
    private String adresa;
    private String numarTelefon;

    public DonatorDTO(UUID id, String nume, String adresa, String numarTelefon) {
        super(id);
        this.nume = nume;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
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

    public static DonatorDTO fromDonator(Donator donator) {
        return new DonatorDTO(donator.getId(), donator.getNume(), donator.getAdresa(), donator.getNumarTelefon());
    }

    public Donator toDonator() {
        return new Donator(getId(), nume, adresa, numarTelefon);
    }
}