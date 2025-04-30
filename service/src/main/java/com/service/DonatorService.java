package com.service;

import com.domain.Donator;
import com.repo.DonatorIRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DonatorService {
    private final DonatorIRepository donatorRepository;

    public DonatorService(DonatorIRepository donatorRepository) {
        this.donatorRepository = donatorRepository;
    }

    public void add(String nume, String adresa, String telefon) {
        donatorRepository.add(new Donator(nume, adresa, telefon));
    }

    public void remove(UUID id) {
        donatorRepository.remove(id);
    }

    public void update(UUID id, String nume, String adresa, String telefon) {
        Donator donator = new Donator(nume, adresa, telefon);
        donator.setId(id);
        donatorRepository.update(donator);
    }

    public List<Donator> getAll() {
        return StreamSupport.stream(donatorRepository.getAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Donator> findByName(String text) {
        return StreamSupport.stream(donatorRepository.findByName(text).spliterator(), false)
                .collect(Collectors.toList());
    }
}