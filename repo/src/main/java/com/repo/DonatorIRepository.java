package com.repo;

import com.domain.Donator;
import com.repo.IRepository;

import java.util.List;
import java.util.UUID;

public interface DonatorIRepository extends IRepository<UUID, Donator> {
    public List<Donator> findByName(String name);
}
