package ru.kpfu.itis.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Search;
import ru.kpfu.itis.model.HotelNumber;
import ru.kpfu.itis.repository.HotelNumberRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ilgiz on 14.11.2016.
 */
@Repository
public class HotelNumberRepositoryImpl implements HotelNumberRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public HotelNumber findById(Long id) {
        Query query = em.createNativeQuery("SELECT * from HotelNumbers where id = ?", HotelNumber.class);
        query.setParameter(1, id);
        List<HotelNumber> results = query.getResultList();
        HotelNumber hotelNumber = null;
        if (!results.isEmpty()) {
            hotelNumber = results.get(0);
        }

        return hotelNumber;
    }

    @Override
    public List<HotelNumber> getAllByBooking(Search search) {
        Query query = em.createNativeQuery("exec dbo.selection @capacity = ?, @location = ?, @fromDate = ?, @toDate = ?;", HotelNumber.class);
        query.setParameter(1, search.getPeopleQuantity());
        query.setParameter(2, search.getPlace());
        query.setParameter(3, search.getFrom());
        query.setParameter(4, search.getTo());

        Double money = search.getMoney();
        List<HotelNumber> result = query.getResultList();
        if (money == null) {
            return result;
        }

        long diffInMillies = search.getTo().getTime() - search.getFrom().getTime();
        long days = (TimeUnit.DAYS).convert(diffInMillies, TimeUnit.MILLISECONDS);


        result.removeIf(hotelNumber -> {
            return days * hotelNumber.getPrice() > search.getMoney();
        });

        return result;
    }
}
