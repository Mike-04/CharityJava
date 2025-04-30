package com.network.client;

import com.network.dto.*;
import com.network.objectprotocol.*;
import com.service.IAppService;
import com.service.observer.IObserver;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientObjectWorker extends ClientObjectWorkerBase implements IObserver {

    private final IAppService service;

    public ClientObjectWorker(IAppService service, Socket connection) {
        super(connection);
        this.service = service;
    }

    @Override
    protected IResponse handleRequest(IRequest request) {
        if (request instanceof LoginUserRequest) {
            String username = ((LoginUserRequest) request).getUsername();
            String password = ((LoginUserRequest) request).getPassword();
            return responseOrError(() -> {
                var user = service.login(username, password, this);
                return new LoginUserResponse(UserDTO.fromUser(user));
            });
        }

        if (request instanceof GetCazuriRequest) {
            return responseOrError(() -> new GetCazuriResponse(
                    List.of(service.getAllCazuri().stream()
                            .map(CazCaritabilDTO::fromCazCaritabil)
                            .toArray(CazCaritabilDTO[]::new))
            ));
        }

        if (request instanceof GetDonatorsRequest) {
            String searchString = ((GetDonatorsRequest) request).getSearchString();
            return responseOrError(() -> new GetDonatorsResponse(
                    List.of(service.getDonators(searchString).stream()
                            .map(DonatorDTO::fromDonator)
                            .toArray(DonatorDTO[]::new))
            ));
        }

        if (request instanceof AddDonationRequest) {
            var selectedDonor = ((AddDonationRequest) request).getDonator().toDonator();
            var selectedCase = ((AddDonationRequest) request).getCazCaritabil().toCazCaritabil();
            double amount = ((AddDonationRequest) request).getSumaDonata();
            return responseOrError(() -> {
                service.addDonation(selectedDonor, selectedCase, amount);
                return new OkResponse();
            });
        }

        if (request instanceof AddDonatorRequest) {
            String name = ((AddDonatorRequest) request).getNume();
            String address = ((AddDonatorRequest) request).getAdresa();
            String phone = ((AddDonatorRequest) request).getNumarTelefon();
            return responseOrError(() -> {
                service.addDonator(name, address, phone);
                return new OkResponse();
            });
        }

        if (request instanceof UpdateDonatorRequest) {
            UUID id = ((UpdateDonatorRequest) request).getId();
            String name = ((UpdateDonatorRequest) request).getNume();
            String address = ((UpdateDonatorRequest) request).getAdresa();
            String phone = ((UpdateDonatorRequest) request).getNumarTelefon();
            return responseOrError(() -> {
                service.updateDonator(id, name, address, phone);
                return new OkResponse();
            });
        }

        if (request instanceof AddCazCaritabilRequest) {
            String name = ((AddCazCaritabilRequest) request).getNume();
            double amountCollected = ((AddCazCaritabilRequest) request).getSuma();
            return responseOrError(() -> {
                service.addCazCaritabil(name, amountCollected);
                return new OkResponse();
            });
        }

        if (request instanceof UpdateCazCaritabilRequest) {
            UUID id = ((UpdateCazCaritabilRequest) request).getId();
            String name = ((UpdateCazCaritabilRequest) request).getNume();
            double amountCollected = ((UpdateCazCaritabilRequest) request).getSuma();
            return responseOrError(() -> {
                service.updateCazCaritabil(id, name, amountCollected);
                return new OkResponse();
            });
        }

        if (request instanceof LogoutUserRequest) {
            String username = ((LogoutUserRequest) request).getUsername();
            return responseOrError(() -> {
                service.logout(username, this);
                return new OkResponse();
            });
        }

        return new ErrorResponse("Unknown request");
    }

    private IResponse responseOrError(ResponseSupplier<IResponse> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return new ErrorResponse(e.getMessage());
        }
    }

    @Override
    public void update() {
        // Print the message
        System.out.println("The database has been updated!");
        // Send the update response

        try {
            sendResponse(new UpdateResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    private interface ResponseSupplier<T> {
        T get() throws Exception;
    }
}