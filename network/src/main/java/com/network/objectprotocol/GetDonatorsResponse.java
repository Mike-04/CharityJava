package com.network.objectprotocol;

import com.network.dto.DonatorDTO;

import java.io.Serializable;
import java.util.List;

public class GetDonatorsResponse implements IResponse, Serializable {
    private static final long serialVersionUID = 1L;

    private List<DonatorDTO> donators;

    public GetDonatorsResponse(List<DonatorDTO> donators) {
        this.donators = donators;
    }

    public List<DonatorDTO> getDonators() {
        return donators;
    }

    public void setDonators(List<DonatorDTO> donators) {
        this.donators = donators;
    }
}