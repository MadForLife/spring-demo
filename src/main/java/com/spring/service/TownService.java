package com.spring.service;

import com.spring.model.Town;

import java.util.List;

public interface TownService {
    Town save(Town town);
    Town findById(Integer id);
    List<Town> findAll();
    void delete(Town town);
}
