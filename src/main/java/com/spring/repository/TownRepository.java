package com.spring.repository;

import com.spring.model.Town;

import java.util.List;

public interface TownRepository {
    Town save(Town town);
    Town findById(Integer id);
    List<Town> findAll();
    void delete(Town town);
}
