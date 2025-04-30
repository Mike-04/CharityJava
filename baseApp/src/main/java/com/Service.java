package com;

import com.domain.CazCaritabil;
import com.domain.Donatie;
import com.domain.Donator;
import com.domain.User;
import com.service.CazCaritabilService;
import com.service.DonatieService;
import com.service.DonatorService;
import com.service.UserService;

import java.util.List;
import java.util.UUID;

public class Service {
    UserService userService;
    DonatieService donatieService;
    CazCaritabilService cazCaritabilService;
    DonatorService donatorService;

    public Service(UserService userService, DonatieService donatieService, CazCaritabilService cazCaritabilService, DonatorService donatorService) {
        this.userService = userService;
        this.donatieService = donatieService;
        this.cazCaritabilService = cazCaritabilService;
        this.donatorService = donatorService;
    }

    //add all the UserService methods

    public void addUser(String username, String password) {
        userService.addUser(username, password);
    }

    public boolean checkUser(String username, String password) {
        return userService.checkUser(username, password);
    }

    public void deleteUser(String username) {
        userService.deleteUser(username);
    }

    public void updateUser(String username, String password) {
        userService.updateUser(username, password);
    }

    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public void addDonator(String nume, String adresa, String nrTelefon) {
        donatorService.add(nume, adresa, nrTelefon);
    }

    public void updateDonator(UUID id, String nume, String adresa, String nrTelefon) {
        donatorService.update(id,nume, adresa, nrTelefon);
    }

    public void deleteDonator(UUID id) {
        donatorService.remove(id);
    }

    public List<Donator> getAllDonatori() {
        return donatorService.getAll();
    }

    public List<Donator> findByName(String name) {
        return donatorService.findByName(name);
    }

    public void addCazCaritabil(String descriere, double sumaNecesara) {
        cazCaritabilService.add(descriere, sumaNecesara);
    }

    public void updateCazCaritabil(UUID id, String descriere, double sumaNecesara) {
        cazCaritabilService.update(id, descriere, sumaNecesara);
    }

    public void deleteCazCaritabil(UUID id) {
        cazCaritabilService.remove(id);
    }

    public List<CazCaritabil> getAllCazuriCaritabile() {
        return cazCaritabilService.getAll();
    }

    public void addDonatie(Donator donator, CazCaritabil cazCaritabil, double suma){
        donatieService.add(donator, cazCaritabil, suma);
    }

    public void updateDonatie(UUID id, Donator donator, CazCaritabil cazCaritabil, double suma){
        donatieService.update(id, donator, cazCaritabil, suma);
    }

    public void deleteDonatie(UUID id){
        donatieService.remove(id);
    }

    public List<Donatie> getAllDonatii(){
        return donatieService.getAll();
    }

    public Donatie findDonatie(UUID id){
        return donatieService.find(id);
    }

    public void donate(Donator selectedDonor, CazCaritabil selectedCase, double v) {
        // Get the caz and add the donation to its value
        selectedCase.setSumaAdunata(selectedCase.getSumaAdunata() + v);
        // Update the caz in repository
        cazCaritabilService.update(selectedCase.getId(), selectedCase.getNume(), selectedCase.getSumaAdunata());
        // Add the donation to the repository
        donatieService.add(selectedDonor, selectedCase, v);
    }



}
