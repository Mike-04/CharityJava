package com.network.objectprotocol;

import java.io.Serializable;

public interface IRequest extends Serializable {
    // This interface can be used to mark all request classes
    // as implementing the IRequest interface, allowing for
    // polymorphic behavior when handling requests.
}
