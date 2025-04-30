package com.server;

import com.domain.CazCaritabil;
import com.domain.Donator;
import com.domain.User;
import com.service.IAppService;
import com.service.observer.IObserver;
import com.service.observer.ISubject;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceImpl implements IAppService, ISubject {
    private final IAppService innerService;
    private final Map<String, IObserver> observers = new HashMap<>();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public ServiceImpl(IAppService innerService) {
        this.innerService = innerService;
    }

    @Override
    public User login(String username, String password, IObserver client) {
        try {
            System.out.println("Login request for user " + username);
            User user = innerService.login(username, password, client);
            if (user == null) {
                System.out.println("Login failed for user " + username);
            }
            observers.put(user.getUsername(), client);
            System.out.println("User " + username + " logged in");
            System.out.println("Observer " + client.toString() + " registered");
            return user;
        } catch (Exception e) {
            System.out.println("Login failed for user " + username + ": " + e.getMessage());
            throw new RuntimeException("Login failed", e);
        } finally {
            System.out.println("Current observers:");
            observers.values().forEach(observer -> System.out.println(observer.toString()));
        }
    }

    @Override
    public List<CazCaritabil> getAllCazuri() {
        try {
            return innerService.getAllCazuri();
        } catch (Exception e) {
            throw new RuntimeException("GetAllCazuri failed", e);
        }
    }

    @Override
    public List<Donator> getDonators(String searchString) {
        try {
            return innerService.getDonators(searchString);
        } catch (Exception e) {
            throw new RuntimeException("GetDonators failed", e);
        }
    }

    @Override
    public void addDonation(Donator selectedDonor, CazCaritabil selectedCase, double amount) {
        try {
            innerService.addDonation(selectedDonor, selectedCase, amount);
            notifyObservers();
        } catch (Exception e) {
            throw new RuntimeException("AddDonation failed", e);
        }
    }

    @Override
    public void addCazCaritabil(String name, double sumaAdunata) {
        try {
            innerService.addCazCaritabil(name, sumaAdunata);
            notifyObservers();
        } catch (Exception e) {
            throw new RuntimeException("AddCazCaritabil failed", e);
        }
    }

    @Override
    public void updateCazCaritabil(UUID id, String name, double sumaAdunata) {
        try {
            innerService.updateCazCaritabil(id, name, sumaAdunata);
            notifyObservers();
        } catch (Exception e) {
            throw new RuntimeException("UpdateCazCaritabil failed", e);
        }
    }

    @Override
    public void addDonator(String name, String address, String phone) {
        try {
            innerService.addDonator(name, address, phone);
            notifyObservers();
        } catch (Exception e) {
            throw new RuntimeException("AddDonator failed", e);
        }
    }

    @Override
    public void updateDonator(UUID id, String name, String address, String phone) {
        try {
            innerService.updateDonator(id, name, address, phone);
            notifyObservers();
        } catch (Exception e) {
            throw new RuntimeException("UpdateDonator failed", e);
        }
    }

    @Override
    public void logout(String username, IObserver client) {
        try {
            innerService.logout(username, client);
            System.out.println("User " + username + " logged out");
            if (observers.containsKey(username)) {
                observers.remove(username);
                System.out.println("Observer " + client.toString() + " unregistered");
            } else {
                System.out.println("Observer " + client.toString() + " not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Logout failed", e);
        } finally {
            removeObserver(client);
            System.out.println("Remaining observers:");
            observers.values().forEach(observer -> System.out.println(observer.toString()));
        }
    }

    @Override
    public void registerObserver(IObserver observer) {
        // Implementation can be added if needed
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.values().removeIf(o -> o.equals(observer));
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers.values()) {
            executor.submit(() -> {
                try {
                    observer.update();
                } catch (Exception e) {
                    System.out.println("Error notifying observer " + observer.toString() + ": " + e.getMessage());
                }
            });
        }
    }
}