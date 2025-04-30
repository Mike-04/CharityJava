package com.network.dto;

import com.domain.CazCaritabil;
import com.domain.Donatie;
import com.domain.Donator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class DonatieDTO extends EntityDTO<UUID> implements Serializable {
    private DonatorDTO donator;
    private CazCaritabilDTO cazCaritabil;
    private double sumaDonata;
    private LocalDateTime timestamp;

    public DonatieDTO(UUID id, Donator donator, CazCaritabil cazCaritabil, double sumaDonata, LocalDateTime timestamp) {
        super(id);
        this.donator = DonatorDTO.fromDonator(donator);
        this.cazCaritabil = CazCaritabilDTO.fromCazCaritabil(cazCaritabil);
        this.sumaDonata = sumaDonata;
        this.timestamp = timestamp;
    }

    public DonatorDTO getDonator() {
        return donator;
    }

    public void setDonator(DonatorDTO donator) {
        this.donator = donator;
    }

    public CazCaritabilDTO getCazCaritabil() {
        return cazCaritabil;
    }

    public void setCazCaritabil(CazCaritabilDTO cazCaritabil) {
        this.cazCaritabil = cazCaritabil;
    }

    public double getSumaDonata() {
        return sumaDonata;
    }

    public void setSumaDonata(double sumaDonata) {
        this.sumaDonata = sumaDonata;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static DonatieDTO fromDonatie(Donatie donatie) {
        return new DonatieDTO(
                donatie.getId(),
                donatie.getDonator(),
                donatie.getCazCaritabil(),
                donatie.getSumaDonata(),
                donatie.getTimestamp()
        );
    }

    public Donatie toDonatie() {
        return new Donatie(
                getId(),
                donator.toDonator(),
                cazCaritabil.toCazCaritabil(),
                sumaDonata,
                timestamp
        );
    }
}