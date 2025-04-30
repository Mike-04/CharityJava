package com.network.objectprotocol;

import java.io.Serializable;

public class GetDonatorsRequest implements IRequest, Serializable {
    private static final long serialVersionUID = 1L;

    private String searchString;

    public GetDonatorsRequest(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}