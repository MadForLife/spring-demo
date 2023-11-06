package com.spring.repository;

import jakarta.persistence.EntityManager;
import com.spring.model.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TownRepositoryImpl implements  TownRepository {
    private final EntityManager entityManager;

    @Autowired
    public TownRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Town save(Town town) {
        if (town.getId() == null) {
            entityManager.persist(town);
        } else {
            entityManager.merge(town);
        }
        return town;
    }

    @Override
    public Town findById(Integer id) {
        return entityManager.find(Town.class, id);
    }

    @Override
    public List<Town> findAll() {
        String jpql = "SELECT t FROM Town t";
        return entityManager.createQuery(jpql, Town.class).getResultList();
    }

    @Override
    public void delete(Town town) {
        entityManager.remove(entityManager.contains(town) ? town : entityManager.merge(town));
    }
}
