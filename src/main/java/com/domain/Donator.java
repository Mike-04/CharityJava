package com.domain;

import java.util.UUID;

public class Donator extends Entity<UUID> {
    String Nume;
    String adresa;
    String numarTelefon;

    public Donator(String Nume, String adresa, String numarTelefon)
    {
        super(UUID.randomUUID());
        this.Nume = Nume;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String Nume) {
        this.Nume = Nume;
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

    @Override
    public String toString() {
        return "Donator{" +
                "id=" + getId() +
                ", Nume='" + Nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", numarTelefon='" + numarTelefon + '\'' +
                '}';
    }
}
