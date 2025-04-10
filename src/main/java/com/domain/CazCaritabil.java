package com.domain;

import java.util.UUID;

public class CazCaritabil extends Entity<UUID>{
    String nume;
    double sumaAdunata;

    public CazCaritabil(String nume, double sumaAdunata)
    {
        super(UUID.randomUUID());
        this.nume = nume;
        this.sumaAdunata = sumaAdunata;
    }

    void adaugaDonatie(double suma)
    {
        sumaAdunata += suma;
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

    @Override
    public String toString() {
        return "CazCaritabil{" +
                "id=" + getId() +
                ", nume='" + nume + '\'' +
                ", sumaAdunata=" + sumaAdunata +
                '}';
    }
}
