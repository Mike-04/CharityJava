package com.network.dto;

import com.domain.CazCaritabil;

import java.io.Serializable;
import java.util.UUID;

public class CazCaritabilDTO extends EntityDTO<UUID> implements Serializable {
    private String nume;
    private double sumaAdunata;

    public CazCaritabilDTO(UUID id, String nume, double sumaAdunata) {
        super(id);
        this.nume = nume;
        this.sumaAdunata = sumaAdunata;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getSumaAdunata() {
        return sumaAdunata;
    }

    public void setSumaAdunata(double sumaAdunata) {
        this.sumaAdunata = sumaAdunata;
    }

    public static CazCaritabilDTO fromCazCaritabil(CazCaritabil cazCaritabil) {
        return new CazCaritabilDTO(cazCaritabil.getId(), cazCaritabil.getNume(), cazCaritabil.getSumaAdunata());
    }

    public CazCaritabil toCazCaritabil() {
        return new CazCaritabil(getId(), nume, sumaAdunata);
    }
}