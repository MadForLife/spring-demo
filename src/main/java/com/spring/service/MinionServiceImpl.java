package com.spring.service;

import com.spring.model.Minion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.repository.MinionRepository;

import java.util.List;

@Service
@Transactional
public class MinionServiceImpl implements MinionService {

    private final MinionRepository minionRepository;

    @Autowired
    public MinionServiceImpl(MinionRepository minionRepository) {
        this.minionRepository = minionRepository;
    }

    @Override
    public Minion save(Minion minion) {
        if (minion.getName() == null || minion.getName().isEmpty()) {
            throw new IllegalArgumentException("Minion name cannot be empty");
        }
        return minionRepository.save(minion);
    }

    @Override
    public Minion findById(Integer id) {
        return minionRepository.findById(id);
    }

    @Override
    public List<Minion> findAll() {
        return minionRepository.findAll();
    }

    @Override
    public void delete(Minion minion) {

    }
}
