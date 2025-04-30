package com.network.client;

import com.domain.CazCaritabil;
import com.domain.Donator;
import com.domain.User;
import com.network.dto.CazCaritabilDTO;
import com.network.dto.DonatorDTO;
import com.network.objectprotocol.*;
import com.service.IAppService;
import com.service.observer.IObserver;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ServiceObjectProxy extends ServiceObjectProxyBase implements IAppService {

    public ServiceObjectProxy(String host, int port) {
        super(host, port);
    }

    @Override
    public User login(String username, String password, IObserver client) {
        initializeConnection();
        this.client = client;
        sendRequest(new LoginUserRequest(username, password));
        try {
            LoginUserResponse resp = awaitResponse(LoginUserResponse.class);
            return resp.getUser().toUser();
        } catch (Exception e) {
            closeConnection();
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    public List<CazCaritabil> getAllCazuri() {
        testConnectionOpen();
        sendRequest(new GetCazuriRequest());
        try {
            GetCazuriResponse resp = awaitResponse(GetCazuriResponse.class);
            return resp.getCazuri().stream().map(CazCaritabilDTO::toCazCaritabil).collect(Collectors.toList());
        } catch (Exception e) {
            closeConnection();
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    public List<Donator> getDonators(String searchString) {
        testConnectionOpen();
        sendRequest(new GetDonatorsRequest(searchString));
        try {
            GetDonatorsResponse resp = awaitResponse(GetDonatorsResponse.class);
            return resp.getDonators().stream().map(DonatorDTO::toDonator).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    public void addDonation(Donator selectedDonor, CazCaritabil selectedCase, double amount) {
        testConnectionOpen();
        sendRequest(new AddDonationRequest(
                DonatorDTO.fromDonator(selectedDonor),
                CazCaritabilDTO.fromCazCaritabil(selectedCase),
                amount));
        try {
            OkResponse resp = awaitResponse(OkResponse.class);
            if (resp == null) {
                throw new ProxyException("Error adding donation");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    public void addCazCaritabil(String name, double amountCollected) {
        testConnectionOpen();
        sendRequest(new AddCazCaritabilRequest(name, amountCollected));
        try {
            OkResponse resp = awaitResponse(OkResponse.class);
            if (resp == null) {
                throw new ProxyException("Error adding charity case");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    public void updateCazCaritabil(UUID id, String name, double amountCollected) {
        testConnectionOpen();
        sendRequest(new UpdateCazCaritabilRequest(id, name, amountCollected));
        try {
            OkResponse resp = awaitResponse(OkResponse.class);
            if (resp == null) {
                throw new ProxyException("Error updating charity case");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    public void addDonator(String name, String address, String phone) {
        testConnectionOpen();
        sendRequest(new AddDonatorRequest(name, address, phone));
        try {
            OkResponse resp = awaitResponse(OkResponse.class);
            if (resp == null) {
                throw new ProxyException("Error adding donor");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    public void updateDonator(UUID id, String name, String address, String phone) {
        testConnectionOpen();
        sendRequest(new UpdateDonatorRequest(id, name, address, phone));
        try {
            OkResponse resp = awaitResponse(OkResponse.class);
            if (resp == null) {
                throw new ProxyException("Error updating donor");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    public void logout(String username, IObserver client) {
        initializeConnection();
        this.client = client;
        sendRequest(new LogoutUserRequest(username));
        try {
            OkResponse resp = awaitResponse(OkResponse.class);
            if (resp == null) {
                throw new ProxyException("Error logging out user");
            }
        } catch (Exception e) {
            closeConnection();
            System.out.println(e.getMessage());
            throw new ProxyException(e);
        }
    }

    @Override
    protected void handleUpdate(UpdateResponse update) {
        System.out.println("HandleUpdate called");
        try {
            client.update();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    private <R extends IResponse> R awaitResponse(Class<R> responseType) {
        IResponse resp = readResponse();
        if (resp instanceof ErrorResponse) {
            throw new ProxyException(((ErrorResponse) resp).getMessage());
        }
        if (!responseType.isInstance(resp)) {
            throw new ProxyException("Wrong response: expected " + responseType.getSimpleName() + ", received " + resp.getClass().getSimpleName());
        }
        return responseType.cast(resp);
    }
}