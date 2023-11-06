package com.spring.repository;

import com.spring.model.Minion;

import java.util.List;

public interface MinionRepository {
    Minion save(Minion minion);
    Minion findById(Integer id);
    List<Minion> findAll();
    void delete(Minion minion);
}
