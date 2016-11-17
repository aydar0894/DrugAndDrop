package ru.kpfu.itis.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.Booking;
import ru.kpfu.itis.repository.BookingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Ilgiz on 15.11.2016.
 */
@Repository
public class BookingRepositoryImpl implements BookingRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void save(Booking booking) {
        Query query = em.createNativeQuery("exec dbo.rentProc @custName = ?, @dateOfBirth = ?\n, " +
                "@gender = ?, @paymentForm = ?, @hId = ?, @totalPrice = ?, @nId = ?, @arrivalDate = ?, @dateOfDeparture = ?;");
        query.setParameter(1, booking.getCustName());
        query.setParameter(2, booking.getDateOfBirth());
        query.setParameter(3, booking.getGender());
        query.setParameter(4, booking.getPaymentForm());
        query.setParameter(5, booking.gethId());
        query.setParameter(6, booking.getTotalPrice());
        query.setParameter(7, booking.getnId());
        query.setParameter(8, booking.getArrivalDate());
        query.setParameter(9, booking.getDateOfDeparture());

        int result = query.executeUpdate();
        if (result != 1) {
            //// FIXME: 15.11.2016

        }

    }
}
