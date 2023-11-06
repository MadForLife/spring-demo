package com.spring.service;

import com.spring.model.Minion;

import java.util.List;

public interface MinionService {
    Minion save(Minion minion);
    Minion findById(Integer id);
    List<Minion> findAll();
    void delete(Minion minion);
}
