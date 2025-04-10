package com.service;

import com.domain.CazCaritabil;
import com.repository.CazCaritabilIRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CazCaritabilService {
    private final CazCaritabilIRepository cazCaritabilRepository;

    public CazCaritabilService(CazCaritabilIRepository cazCaritabilRepository) {
        this.cazCaritabilRepository = cazCaritabilRepository;
    }

    public void add(String nume, double sumaAdunata) {
        cazCaritabilRepository.add(new CazCaritabil(nume, sumaAdunata));
    }

    public void remove(UUID id) {
        cazCaritabilRepository.remove(id);
    }

    public void update(UUID id, String nume, double sumaAdunata) {
        CazCaritabil cazCaritabil = new CazCaritabil(nume, sumaAdunata);
        cazCaritabil.setId(id);
        cazCaritabilRepository.update(cazCaritabil);
    }

    public List<CazCaritabil> getAll() {
        return StreamSupport.stream(cazCaritabilRepository.getAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}