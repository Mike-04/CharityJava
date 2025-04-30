package com.network.objectprotocol;

import com.network.dto.CazCaritabilDTO;
import com.network.dto.DonatorDTO;

import java.io.Serializable;

public class AddDonationRequest implements IRequest, Serializable {
    private static final long serialVersionUID = 1L;

    private CazCaritabilDTO cazCaritabil;
    private DonatorDTO donator;
    private double sumaDonata;

    public AddDonationRequest(DonatorDTO donator, CazCaritabilDTO cazCaritabil, double sumaDonata) {
        this.cazCaritabil = cazCaritabil;
        this.donator = donator;
        this.sumaDonata = sumaDonata;
    }

    public CazCaritabilDTO getCazCaritabil() {
        return cazCaritabil;
    }

    public void setCazCaritabil(CazCaritabilDTO cazCaritabil) {
        this.cazCaritabil = cazCaritabil;
    }

    public DonatorDTO getDonator() {
        return donator;
    }

    public void setDonator(DonatorDTO donator) {
        this.donator = donator;
    }

    public double getSumaDonata() {
        return sumaDonata;
    }

    public void setSumaDonata(double sumaDonata) {
        this.sumaDonata = sumaDonata;
    }
}