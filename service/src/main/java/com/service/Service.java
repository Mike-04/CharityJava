package com.service;

import com.domain.CazCaritabil;
import com.domain.Donator;
import com.domain.User;
import com.service.observer.IObserver;

import java.util.List;
import java.util.UUID;

public class Service implements IAppService {
    private final CazCaritabilService cazCaritabilService;
    private final UserService userService;
    private final DonatorService donatorService;
    private final DonatieService donatieService;

    public Service(UserService userService, CazCaritabilService cazCaritabilService, DonatorService donatorService, DonatieService donatieService) {
        this.userService = userService;
        this.cazCaritabilService = cazCaritabilService;
        this.donatorService = donatorService;
        this.donatieService = donatieService;
    }

    @Override
    public void addDonation(Donator selectedDonor, CazCaritabil selectedCase, double amount) {
        selectedCase.adaugaDonatie(amount);
        cazCaritabilService.update(selectedCase.getId(), selectedCase.getNume(), selectedCase.getSumaAdunata());
        donatieService.add(selectedDonor, selectedCase, amount);
    }

    @Override
    public void addCazCaritabil(String name, double sumaAdunata) {
        cazCaritabilService.add(name, sumaAdunata);
    }

    @Override
    public void updateCazCaritabil(UUID id, String name, double sumaAdunata) {
        cazCaritabilService.update(id, name, sumaAdunata);
    }

    @Override
    public void addDonator(String name, String address, String phone) {
        donatorService.add(name, address, phone);
    }

    @Override
    public void updateDonator(UUID id, String name, String address, String phone) {
        donatorService.update(id, name, address, phone);
    }

    @Override
    public void logout(String username, IObserver client) {
        // No implementation needed
    }

    @Override
    public User login(String username, String password, IObserver client) {
        if (userService.checkUser(username, password)) {
            return userService.findByUsername(username);
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @Override
    public List<CazCaritabil> getAllCazuri() {
        return cazCaritabilService.getAll();
    }

    @Override
    public List<Donator> getDonators(String searchString) {
        return donatorService.findByName(searchString);
    }
}