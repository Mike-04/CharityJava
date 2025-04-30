package com.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Donatie extends Entity<UUID> {
    Donator donator;
    CazCaritabil cazCaritabil;
    double sumaDonata;
    LocalDateTime timestamp;

    public Donatie(Donator donator, CazCaritabil cazCaritabil, double sumaDonata)
    {
        super(UUID.randomUUID());
        this.donator = donator;
        this.cazCaritabil = cazCaritabil;
        this.sumaDonata = sumaDonata;
        this.timestamp = LocalDateTime.now();
    }

    public Donatie(UUID id, Donator donator, CazCaritabil cazCaritabil, double sumaDonata, LocalDateTime timestamp) {
        super(id);
        this.donator = donator;
        this.cazCaritabil = cazCaritabil;
        this.sumaDonata = sumaDonata;
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public CazCaritabil getCazCaritabil() {
        return cazCaritabil;
    }

    public void setCazCaritabil(CazCaritabil cazCaritabil) {
        this.cazCaritabil = cazCaritabil;
    }

    public double getSumaDonata() {
        return sumaDonata;
    }

    public void setSumaDonata(double sumaDonata) {
        this.sumaDonata = sumaDonata;
    }

    @Override
    public String toString() {
        return "Donatie{" +
                "id=" + getId() +
                ", donator=" + donator +
                ", cazCaritabil=" + cazCaritabil +
                ", sumaDonata=" + sumaDonata +
                ", timestamp=" + timestamp +
                '}';
    }
}
