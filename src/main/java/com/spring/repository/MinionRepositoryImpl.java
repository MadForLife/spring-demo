package com.spring.repository;

import jakarta.persistence.EntityManager;
import com.spring.model.Minion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MinionRepositoryImpl implements MinionRepository {
    private final EntityManager entityManager;

    @Autowired
    public MinionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Minion save(Minion minion) {
        if (minion.getId() == null) {
            entityManager.persist(minion);
        } else {
            entityManager.merge(minion);
        }
        return minion;
    }

    @Override
    public Minion findById(Integer id) {
        return entityManager.find(Minion.class, id);
    }

    @Override
    public List<Minion> findAll() {
        String jpql = "SELECT m FROM Minion m";
        return entityManager.createQuery(jpql, Minion.class).getResultList();
    }

    @Override
    public void delete(Minion minion) {
        entityManager.remove(entityManager.contains(minion) ? minion : entityManager.merge(minion));
    }
}
