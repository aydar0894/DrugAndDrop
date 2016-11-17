package ru.kpfu.itis.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Hotel;
import ru.kpfu.itis.model.Rent;
import ru.kpfu.itis.repository.RentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Ilgiz on 17.11.2016.
 */
@Repository
public class RentRepositoryImpl implements RentRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Rent> findAll() {
        Query query = em.createNativeQuery("SELECT * from Rent;", Rent.class);
        return query.getResultList();
    }
}
