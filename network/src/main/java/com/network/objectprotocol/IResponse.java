package com.network.objectprotocol;

import java.io.Serializable;

public interface IResponse extends Serializable {
    // This interface is a marker interface for response objects in the network protocol.
    // It extends Serializable to allow response objects to be serialized for network transmission.
    // No additional methods or fields are defined here, as this is a simple marker interface.
}
