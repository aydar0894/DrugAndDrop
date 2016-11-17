package ru.kpfu.itis.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Hotel;
import ru.kpfu.itis.repository.HotelRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Repository

public class HotelRepositoryImpl implements HotelRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Hotel> findAll() {
        Query query = em.createNativeQuery("SELECT * from Hotels;", Hotel.class);
        return query.getResultList();
    }
}
