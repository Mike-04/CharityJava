package com.service;

import com.domain.CazCaritabil;
import com.domain.Donatie;
import com.domain.Donator;
import com.repo.DonatieIRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DonatieService {
    private final DonatieIRepository donatieRepository;

    public DonatieService(DonatieIRepository donatieRepository) {
        this.donatieRepository = donatieRepository;
    }

    public void add(Donator donator, CazCaritabil cazCaritabil, double suma) {
        Donatie donatie = new Donatie(donator, cazCaritabil, suma);
        donatieRepository.add(donatie);
    }

    public void remove(UUID id) {
        donatieRepository.remove(id);
    }

    public List<Donatie> getAll() {
        return StreamSupport.stream(donatieRepository.getAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Donatie find(UUID id) {
        return donatieRepository.find(id);
    }

    public void update(UUID id, Donator donator, CazCaritabil cazCaritabil, double suma) {
        Donatie donatie = new Donatie(donator, cazCaritabil, suma);
        donatie.setId(id);
        donatieRepository.update(donatie);
    }
}