package com.network.objectprotocol;

import com.network.dto.CazCaritabilDTO;

import java.io.Serializable;
import java.util.List;

public class GetCazuriResponse implements IResponse, Serializable {
    private static final long serialVersionUID = 1L;

    private List<CazCaritabilDTO> cazuri;

    public GetCazuriResponse(List<CazCaritabilDTO> cazuri) {
        this.cazuri = cazuri;
    }

    public List<CazCaritabilDTO> getCazuri() {
        return cazuri;
    }

    public void setCazuri(List<CazCaritabilDTO> cazuri) {
        this.cazuri = cazuri;
    }
}