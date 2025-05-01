package com.network.client;
import com.domain.CazCaritabil;
import com.domain.Donator;
import com.domain.User;
import com.google.protobuf.Empty;
import com.network.*;
import com.service.IAppService;
import com.service.observer.IObserver;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class ServiceRpc implements IAppService {
    private final CharityServiceGrpc.CharityServiceBlockingStub blockingStub;
    private final ManagedChannel channel;

    public ServiceRpc(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public ServiceRpc(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = CharityServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public User login(String username, String password, IObserver client) {
        LoginUserRequest request = LoginUserRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();

        LoginUserResponse response = blockingStub.loginUser(request);

        // Register the observer with the server
        CompletableFuture.runAsync(() -> {
            try {
                CharityServiceGrpc.CharityServiceStub asyncStub = CharityServiceGrpc.newStub(channel);
                asyncStub.subscribeToNotifications(Empty.newBuilder().build(), new StreamObserver<UpdateResponse>() {
                    @Override
                    public void onNext(UpdateResponse updateResponse) {
                        try {
                            client.update();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.err.println("Error in observer stream: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Observer stream completed.");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return new User(
                UUID.fromString(response.getUser().getId()),
                response.getUser().getUsername(),
                response.getUser().getPassword()
        );
    }

    @Override
    public List<CazCaritabil> getAllCazuri() {
        GetCazuriRequest request = GetCazuriRequest.newBuilder().build();
        GetCazuriResponse response = blockingStub.getCazuri(request);

        List<CazCaritabil> cazuri = response.getCazuriList().stream()
                .map(c -> new CazCaritabil(
                        UUID.fromString(c.getId()),
                        c.getNume(),
                        c.getSumaAdunata()
                ))
                .toList();
        return cazuri;
    }

    @Override
    public List<Donator> getDonators(String searchString) {
        GetDonatorsRequest request = GetDonatorsRequest.newBuilder()
                .setSearchString(searchString)
                .build();

        GetDonatorsResponse response = blockingStub.getDonators(request);

        List<Donator> donatori = response.getDonatorsList().stream()
                .map(d -> new Donator(
                        UUID.fromString(d.getId()),
                        d.getNume(),
                        d.getAdresa(),
                        d.getNumarTelefon()
                ))
                .toList();
        return donatori;
    }

    @Override
    public void addDonation(Donator selectedDonor, CazCaritabil selectedCase, double amount) {
        AddDonationRequest request = AddDonationRequest.newBuilder()
                .setDonator(com.network.Donator.newBuilder()
                        .setId(selectedDonor.getId().toString())
                        .setNume(selectedDonor.getNume())
                        .setAdresa(selectedDonor.getAdresa())
                        .setNumarTelefon(selectedDonor.getNumarTelefon())
                        .build())
                .setCazCaritabil(com.network.CazCaritabil.newBuilder()
                        .setId(selectedCase.getId().toString())
                        .setNume(selectedCase.getNume())
                        .setSumaAdunata(selectedCase.getSumaAdunata())
                        .build())
                .setSumaDonata(amount)
                .build();

        blockingStub.addDonation(request);
    }

    @Override
    public void addCazCaritabil(String name, double sumaAdunata) {
        AddCazCaritabilRequest request = AddCazCaritabilRequest.newBuilder()
                .setNume(name)
                .setSuma(sumaAdunata)
                .build();

        blockingStub.addCazCaritabil(request);
    }

    @Override
    public void updateCazCaritabil(UUID id, String name, double sumaAdunata) {
        UpdateCazCaritabilRequest request = UpdateCazCaritabilRequest.newBuilder()
                .setId(id.toString())
                .setNume(name)
                .setSuma(sumaAdunata)
                .build();

        blockingStub.updateCazCaritabil(request);
    }

    @Override
    public void addDonator(String name, String address, String phone) {
        AddDonatorRequest request = AddDonatorRequest.newBuilder()
                .setNume(name)
                .setAdresa(address)
                .setNumarTelefon(phone)
                .build();

        blockingStub.addDonator(request);
    }

    @Override
    public void updateDonator(UUID id, String name, String address, String phone) {
        UpdateDonatorRequest request = UpdateDonatorRequest.newBuilder()
                .setId(id.toString())
                .setNume(name)
                .setAdresa(address)
                .setNumarTelefon(phone)
                .build();

        blockingStub.updateDonator(request);
    }

    @Override
    public void logout(String username, IObserver client) {
        LogoutUserRequest request = LogoutUserRequest.newBuilder()
                .setUsername(username)
                .build();

        OkResponse response = blockingStub.logoutUser(request);
        if (response.equals(OkResponse.getDefaultInstance())) {
            System.out.println("Logout successful");
        } else {
            System.out.println("Logout failed");
        }
    }


}