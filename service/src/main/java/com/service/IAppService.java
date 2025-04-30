package com.service;

import com.domain.CazCaritabil;
import com.domain.Donator;
import com.domain.User;
import com.service.observer.IObserver;

import java.util.List;
import java.util.UUID;

public interface IAppService {
    User login(String username, String password, IObserver client);
    List<CazCaritabil> getAllCazuri();
    List<Donator> getDonators(String searchString);
    void addDonation(Donator selectedDonor, CazCaritabil selectedCase, double amount);
    void addCazCaritabil(String name, double sumaAdunata);
    void updateCazCaritabil(UUID id, String name, double sumaAdunata);
    void addDonator(String name, String address, String phone);
    void updateDonator(UUID id, String name, String address, String phone);
    void logout(String username, IObserver client);
}