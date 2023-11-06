package com.spring.service;

import com.spring.model.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.spring.repository.TownRepository;

import java.util.List;

@Repository
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public Town save(Town town) {
        if (town.getName() == null || town.getName().isEmpty()) {
            throw new IllegalArgumentException("Town name cannot be empty");
        }
        return townRepository.save(town);
    }

    @Override
    public Town findById(Integer id) {
        return townRepository.findById(id);
    }

    @Override
    public List<Town> findAll() {
        return townRepository.findAll();
    }

    @Override
    public void delete(Town town) {

    }
}
